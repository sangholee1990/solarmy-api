package solarmy.front.common;

import org.json.JSONException;
import org.json.JSONObject;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solarmy.front.controller.MainController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ServiceHelper {

    private static final String headerKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2FjY291bnQiOjI0fQ.pXluG0rOyeoO8xSvAFYCOrkIaYofUkUR3dIijJOT6xg";
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

//    protected String isParamCheck(String reqUrl, String[] skey, Map<String, Object> requestParam) throws Exception {
//        String[] sKey = skey;
//        if (skey != null && skey.length > 0) {
//            for (int i = 0; i < sKey.length; i++) {
//                if (requestParam.containsKey(sKey[i]) == false || requestParam.get(sKey[i]).toString().length() == 0) {
//                    log.info("[{}] {}", reqUrl, "[" + sKey[i] + "] " + "EMPTY");
//                    System.out.println(reqUrl + "[" + sKey[i] + "] " + "EMPTY");
//                    return SolarmyException.errorMessage("11", "PARAMETER ERROR");
//                }
//            }
//        }
//
//        return null;
//    }

    protected String paramCheck(String reqUrl, String[] sKey, JSONObject requestBody) throws JSONException {

        if (sKey == null || sKey.length < 1) return null;

        for (String key : sKey) {
            String value = requestBody.get(key).toString();
            if ("0".equals(value) || "null".equals(value)) {
                return SolarmyException.errorMessage("11", String.format("파라미터 에러 발생 (%s)", key));
            }
        }

        return null;
    }

    protected String headerCheck(String reqUrl, String headerParam) {
        if ("".equals(headerParam) || !headerKey.equals(headerParam)) {
            log.info("[{}] {}", reqUrl, "HEADER ERROR");
            return SolarmyException.systemError();
        }
        return null;
    }

    protected <T> ResponseEntity<String> selHelper(HttpServletRequest request, T vo, Function<T, List<Map>> dbFunction, String[] sKey) throws Exception {

        String ret = null;

        try {
            String reqUrl = request.getRequestURL().toString();
            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.headerCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            ret = this.paramCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = dbFunction.apply(vo);

            JSONObject Obj1 = new JSONObject();
            JSONObject Obj2 = new JSONObject();
            JSONObject Obj3 = new JSONObject();

            Obj2.put("cnt", retObj == null ? 0 : retObj.size());
            Obj2.put("list", retObj);

            Obj3.put("srv", reqUrl);
            Obj3.put("var", JsonUtil.getParamMap(sKey, requestBody));

            Obj1.put("code", "00");
            Obj1.put("data", Obj2);
            Obj1.put("req", Obj3);

            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);

        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    protected <T> ResponseEntity<String> mergeHelper(HttpServletRequest request, T vo, Function<T, Integer> daoFunction, String[] sKey) throws Exception {

        String ret;

        try {
            String reqUrl = request.getRequestURL().toString();
            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

            ret = this.headerCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            ret = this.paramCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = daoFunction.apply(vo);
            if (retVal < 1)
                return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);

            JSONObject Obj1 = new JSONObject();

            Obj1.put("code", "00");
            Obj1.put("success", "Y");
            Obj1.put("messageText", "데이터 입력에 성공하였습니다.");

            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
