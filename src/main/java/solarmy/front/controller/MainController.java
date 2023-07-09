package solarmy.front.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import solarmy.front.common.JsonUtil;
import solarmy.front.common.MandatoryParamCheck;
import solarmy.front.common.SolarmyException;
import solarmy.front.model.MainDAO;
import solarmy.front.vo.*;

@RestController
public class MainController extends MandatoryParamCheck {

    @Autowired
    MainDAO mainDao;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);


    /*
     * 소켓 통신 테스트 시작
     */

//    @ApiOperation(value = "회원정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
//    @GetMapping(value = "/api/sel-member-socket", headers = "content-type=text/plain;charset=UTF-8", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<String> selMemberSocket(HttpServletRequest request, @RequestBody(required = true) String requestParam) throws Exception {
//        String ret = null;
//        String reqUrl = request.getRequestURL().toString();
//
//        try {
//            Map<String, Object> paramMap = JsonUtil.JsonToMap(requestParam);
//
//            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
//            ret = this.isHeaderCheck(reqUrl, headerParam);
//            if (ret != null) {
//                return new ResponseEntity<String>(ret, HttpStatus.OK);
//            }
//
//            String[] sKey = {"customer_link_number", "sns_key"};
//            ret = this.isParamCheck(reqUrl, sKey, paramMap);
//            if (ret != null) {
//                return new ResponseEntity<String>(ret, HttpStatus.OK);
//            }
//
//            Map<String, Object> retObj = mainDao.selMemberSocket(paramMap);
//
//            JSONObject Obj1 = new JSONObject();
//            JSONObject Obj2 = new JSONObject();
//            JSONObject Obj3 = new JSONObject();
//
//            Obj2.put("cnt", retObj == null ? 0 : 1);
//            Obj2.put("list", retObj);
//
//            Obj3.put("srv", reqUrl);
//            Obj3.put("var", paramMap);
//
//            Obj1.put("code", "00");
//            Obj1.put("data", Obj2);
//            Obj1.put("req", Obj3);
//
//            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);
//
//        } catch (MyBatisSystemException e) {
//            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @ApiOperation(value = "회원정보 등록", notes = "회원정보를 등록합니다.")
//    @PostMapping(value = "/api/ins-member-socket", headers = "content-type=application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<String> insMemberSocket(HttpServletRequest request, @RequestBody(required = true) String requestParam) throws Exception {
//        // main_dao.insMember(vo);
//        String ret = null;
//        String reqUrl = request.getRequestURL().toString();
//
//        try {
//            Map<String, Object> paramMap = JsonUtil.JsonToMap(requestParam);
//
//            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
//            ret = this.isHeaderCheck(reqUrl, headerParam);
//            if (ret != null) {
//                return new ResponseEntity<String>(ret, HttpStatus.OK);
//            }
//
//            int retVal = mainDao.insMemberSocket(paramMap);
//            if (retVal < 1)
//                return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
//
//            JSONObject Obj1 = new JSONObject();
//
//            Obj1.put("code", "00");
//            Obj1.put("success", "Y");
//            Obj1.put("messageText", "데이터 입력에 성공하였습니다.");
//
//            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);
//
//        } catch (MyBatisSystemException e) {
//            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @ApiOperation(value = "회원정보 수정", notes = "customer_link_number를 이용하여 회원정보를 수정합니다.")
//    @PutMapping(value = "/api/upd-member-socket", headers = "content-type=application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<String> updMemberSocket(HttpServletRequest request, @RequestBody(required = true) String requestParam) throws Exception {
//        // main_dao.updMember(vo);
//        String ret = null;
//        String reqUrl = request.getRequestURL().toString();
//
//        try {
//            Map<String, Object> paramMap = JsonUtil.JsonToMap(requestParam);
//
//            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
//            ret = this.isHeaderCheck(reqUrl, headerParam);
//            if (ret != null) {
//                return new ResponseEntity<String>(ret, HttpStatus.OK);
//            }
//
//            String[] sKey = {"customer_link_number", "sns_key"};
//            ret = this.isParamCheck(reqUrl, sKey, paramMap);
//            if (ret != null) {
//                return new ResponseEntity<String>(ret, HttpStatus.OK);
//            }
//
//            int retVal = mainDao.updMemberSocket(paramMap);
//            if (retVal < 1)
//                return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
//
//            JSONObject Obj1 = new JSONObject();
//
//            Obj1.put("code", "00");
//            Obj1.put("success", "Y");
//            Obj1.put("messageText", "데이터 수정에 성공하였습니다.");
//
//            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);
//
//        } catch (MyBatisSystemException e) {
//            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    /*
     * 소켓 통신 테스트 끝
     */



    @ApiOperation(value = "(조회) 공통 코드", notes = "공통 코드 목록을 조회합니다.")
    @GetMapping(value = "/api/sel-commCode")
    public ResponseEntity<String> sel_commCode(HttpServletRequest request, @ModelAttribute CommCodeVO vo) throws Exception {
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);

            String[] sKey = {};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selCommCode(vo);

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

    @ApiOperation(value = "(조회) 회원정보", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-member")
    public ResponseEntity<String> selMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);

            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selMember(vo);

            JSONObject Obj1 = new JSONObject();
            JSONObject Obj2 = new JSONObject();
            JSONObject Obj3 = new JSONObject();

//            Obj2.put("cnt", retObj == null ? 0 : 1);
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

    @ApiOperation(value = "(조회) 기상 외부 데이터", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-outputData")
    public ResponseEntity<String> selOutputData(HttpServletRequest request, @ModelAttribute OutputDataVO vo)
            throws Exception {

        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
//            String[] sKey = {"customer_link_number", "date", "time"};
            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

//            Map<String, Object> retObj = mainDao.selOutputData(vo);
            List<Map> retObj = mainDao.selOutputData(vo);

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

    @ApiOperation(value = "(조회) IOT 제품 인증", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-iotProdtAuth")
    public ResponseEntity<String> selIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo)
            throws Exception {
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            String[] sKey = {"product_serial_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selIotProdtAuth(vo);

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

    @ApiOperation(value = "(조회) 한전API 제품 인증", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-kepProdtAuth")
    public ResponseEntity<String> selKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo)
            throws Exception {
        /*
         * else if(vo.getKepco_api_key() == null){ code = "30"; throw new
         * NullPointerException(); }else { obj = main_dao.selKepProdtAuth(vo); }
         */
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            String[] sKey = {"kepco_api_key"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selKepProdtAuth(vo);

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

    @ApiOperation(value = "(조회) 메시지 정보", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-msgInfo")
    public ResponseEntity<String> selMsgInfo(HttpServletRequest request, @ModelAttribute MsgInfoVO vo)
            throws Exception {
        // obj = main_dao.selMsgInfo(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
//            String[] sKey = {"msg_code"};
            String[] sKey = {};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selMsgInfo(vo);

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

    @ApiOperation(value = "(조회) 시스템 정보", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-sysInfo")
    public ResponseEntity<String> selSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo)
            throws Exception {

        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selSysInfo(vo);

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

    @ApiOperation(value = "(조회) IOT 내부 데이터", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-inputData")
    public ResponseEntity<String> selInputData(HttpServletRequest request, @ModelAttribute InputDataVO vo)
            throws Exception {
        /*
         * else if(vo.getProduct_serial_number() == null || vo.getDate() == null ||
         * vo.getTime() == null){ code = "11"; throw new NullPointerException(); }else {
         * obj = main_dao.selInputData(vo);
         */
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
//            String[] sKey = {"product_serial_number", "date", "time"};
            String[] sKey = {"product_serial_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selInputData(vo);

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

    @ApiOperation(value = "(조회) 기상 외부 통계 데이터", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-outputStatData")
    public ResponseEntity<String> selOutputStatData(HttpServletRequest request, @ModelAttribute OutputStatDataVO vo)
            throws Exception {

        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
//            String[] sKey = {"customer_link_number", "date", "time"};
            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            List<Map> retObj = mainDao.selOutputStatData(vo);

            JSONObject Obj1 = new JSONObject();
            JSONObject Obj2 = new JSONObject();
            JSONObject Obj3 = new JSONObject();

            Obj2.put("cnt", retObj == null ? 0 : 1);
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

    @ApiOperation(value = "(등록) 회원정보", notes = "회원정보를 등록합니다.")
    @PostMapping(value = "/api/ins-member")
    public ResponseEntity<String> insMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
        // main_dao.insMember(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.insMember(vo);
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

    @ApiOperation(value = "(등록) 시스템 정보", notes = "시스템 정보를 등록합니다.")
    @PostMapping(value = "/api/ins-sysInfo")
    public ResponseEntity<String> insSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo)
            throws Exception {
        // main_dao.insSysInfo(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.insSysInfo(vo);
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

    @ApiOperation(value = "(등록) 약관 동의", notes = "약관 동의를 등록합니다.")
    @PostMapping(value = "/api/ins-termsCond")
    public ResponseEntity<String> insTermsCond(HttpServletRequest request, @ModelAttribute TermsCondVO vo) throws Exception {
        // main_dao.insTermsCond(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.insTermsCond(vo);
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

    @ApiOperation(value = "(등록) 한전API 제품 인증", notes = "한전API 제품 인증을 등록합니다.")
    @PostMapping(value = "/api/ins-kepProdtAuth")
    public ResponseEntity<String> insKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo)
            throws Exception {
        // main_dao.insKepProdtAuth(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.insKepProdtAuth(vo);
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

    @ApiOperation(value = "(등록) IOT 제품 인증", notes = "IOT 제품 인증을 등록합니다.")
    @PostMapping(value = "/api/ins-iotProdtAuth")
    public ResponseEntity<String> insIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo)
            throws Exception {
        // main_dao.insIotProdtAuth(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.insIotProdtAuth(vo);
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

    @ApiOperation(value = "(수정) 회원정보", notes = "customer_link_number를 이용하여 회원정보를 수정합니다.")
    @PutMapping(value = "/api/upd-member")
    public ResponseEntity<String> updMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
        // main_dao.updMember(vo);
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
//            String[] sKey = {"customer_link_number", "sns_key"};
            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.updMember(vo);
            if (retVal < 1)
                return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);

            JSONObject Obj1 = new JSONObject();

            Obj1.put("code", "00");
            Obj1.put("success", "Y");
            Obj1.put("messageText", "데이터 수정에 성공하였습니다.");

            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);

        } catch (MyBatisSystemException e) {
//            e.printStackTrace();
            log.error(e.getMessage());
            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "(수정) 시스템 정보", notes = "customer_link_number를 이용하여 시스템 정보를 수정합니다.")
    @PutMapping(value = "/api/upd-sysInfo")
    public ResponseEntity<String> updSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
        /*
         * else if(vo.getCustomer_link_number() == null){ code = "11"; throw new
         * NullPointerException(); }else { main_dao.updSysInfo(vo); }
         */
        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.updSysInfo(vo);

            if (retVal < 1)
                return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);

            JSONObject Obj1 = new JSONObject();

            Obj1.put("code", "00");
            Obj1.put("success", "Y");
            Obj1.put("messageText", "데이터 수정에 성공하였습니다.");

            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);

        } catch (MyBatisSystemException e) {
//            e.printStackTrace();
            log.error(e.getMessage());
            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "(수정) 약관 동의", notes = "customer_link_number를 이용하여 약관 동의를 수정합니다.")
    @PutMapping(value = "/api/upd-termsCond")
    public ResponseEntity<String> updTermsCond(HttpServletRequest request, @ModelAttribute TermsCondVO vo) throws Exception {

        String ret = null;
        String reqUrl = request.getRequestURL().toString();

        try {

            String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
            ret = this.isHeaderCheck(reqUrl, headerParam);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            JSONObject requestBody = new JSONObject(vo);
            String[] sKey = {"customer_link_number"};
            ret = this.isParamCheck(reqUrl, sKey, requestBody);
            if (ret != null) {
                return new ResponseEntity<String>(ret, HttpStatus.OK);
            }

            int retVal = mainDao.updTermsCond(vo);

            if (retVal < 1)
                return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);

            JSONObject Obj1 = new JSONObject();

            Obj1.put("code", "00");
            Obj1.put("success", "Y");
            Obj1.put("messageText", "데이터 수정에 성공하였습니다.");

            return new ResponseEntity<String>(Obj1.toString(), HttpStatus.OK);

        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}