package solarmy.front.common;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;

public class JsonUtil {
	
	public JsonUtil() 
	{
		
	}
	
	public static String MapToJson(Map<String, Object> map)
	{
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	public static Map<String, Object> getParamMap(String[] skey, JSONObject requestBody) throws Exception
	{
        String[] sKey = skey;
        Map<String, Object> paramMap = new HashMap<>();
        for (int i = 0 ; i < sKey.length ; i++)
        {	
            paramMap.put(sKey[i], requestBody.get(sKey[i]).toString());
        }
		return paramMap;
    }
}
