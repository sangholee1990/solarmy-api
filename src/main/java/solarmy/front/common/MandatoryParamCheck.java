package solarmy.front.common;

import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import solarmy.front.controller.MainController;

public class MandatoryParamCheck {
	
	private static final String headerKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2FjY291bnQiOjI0fQ.pXluG0rOyeoO8xSvAFYCOrkIaYofUkUR3dIijJOT6xg";
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	protected String isParamCheck(String reqUrl, String[] skey, Map<String, Object> requestParam) throws Exception
	{
        String[] sKey = skey;
        for (int i = 0 ; i < sKey.length ; i++)
        {	
            if (requestParam.containsKey(sKey[i]) == false || requestParam.get(sKey[i]).toString().length() == 0) 
            {
            	log.info("[{}] {}", reqUrl, "[" + sKey[i] + "] "+"EMPTY");
            	System.out.println(reqUrl+"[" + sKey[i] + "] "+"EMPTY");
            	return SolarmyException.errorMessage("11","PARAMETER ERROR");
            }
        }
		return null;
    }
	
	protected String isParamCheck(String reqUrl, String[] skey, JSONObject requestBody) throws Exception
	{
        String[] sKey = skey;
        for (int i = 0 ; i < sKey.length ; i++)
        {	
            if ("0".equals(requestBody.get(sKey[i]).toString()) || "null".equals(requestBody.get(sKey[i]).toString())) // 파라미터 값 공백
            {
            	log.info("[{}] {}", reqUrl, "[" + sKey[i] + "] "+"EMPTY");
            	return SolarmyException.errorMessage("11","PARAMETER ERROR");
            }
        }
		return null;
    }
	
	protected String isHeaderCheck(String reqUrl, String headerParam) throws Exception
	{
        if("".equals(headerParam) || !headerKey.equals(headerParam)) 
        {
        	log.info("[{}] {}", reqUrl, "HEADER ERROR");
        	return SolarmyException.systemError();
        }
        return null;
    }
	
}
