package solarmy.front.common;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import solarmy.front.controller.MainController;

public class MandatoryParamCheck {
	
	private static final String headerKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2FjY291bnQiOjI0fQ.pXluG0rOyeoO8xSvAFYCOrkIaYofUkUR3dIijJOT6xg";
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	//protected ResponseEntity<String> isParamCheck(String reqUrl, String[] skey, JSONObject requestBody) throws Exception
	protected String isParamCheck(String reqUrl, String[] skey, JSONObject requestBody) throws Exception
	{
        String[] sKey = skey;

        for (int i = 0 ; i < sKey.length ; i++)
        {	
        	System.out.println(requestBody.get(sKey[i]).toString());
            if ("0".equals(requestBody.get(sKey[i]).toString()) || "null".equals(requestBody.get(sKey[i]).toString())) // 파라미터 값 공백
            {
            	//throw new SolarmyException(SolarmyMessage.PARAMETER_EMPTY.getMessageCode(), "[" + sKey[i] + "] " + SolarmyMessage.PARAMETER_EMPTY.getMessageText());
            	log.info("[{}] {}", reqUrl, "[" + sKey[i] + "] "+"EMPTY");
            	//throw new SolarmyException("11", "[" + sKey[i] + "] "+"EMPTY");
            	//return new ResponseEntity<String>(SolarmyException.errorMessage(), HttpStatus.OK);
            	return SolarmyException.errorMessage("11","PARAMETER ERROR");
            }
        }
		return null;
    }
	
	protected String isHeaderCheck(String reqUrl, String headerParam) throws Exception
	{
		
        if("".equals(headerParam) || !headerKey.equals(headerParam)) 
        {
        	System.out.println("bbb : "+headerParam);
        	log.info("[{}] {}", reqUrl, "HEADER ERROR");
        	//throw new SolarmyException("30","ERROR");
        	//return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
        	return SolarmyException.systemError();
        }
        return null;
    }
	
}
