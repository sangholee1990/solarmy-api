package solarmy.front.common;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
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
	
	public static String convertListToJson(List<Map<String, Object>> list) throws JSONException {

	    JSONArray jsonArray = new JSONArray();
	    for (Map<String, Object> map : list) {
	        jsonArray.put(convertMapToJson(map));
	    }
	    return jsonArray.toString();
	}
	
	//map 처리
	public static String convertMapToJson(Map<String, Object> map) throws JSONException {

	    JSONObject json = new JSONObject();
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
	        String key = entry.getKey();
	        Object value = entry.getValue();
	        json.put(key, value);
	    }
	    return json.toString();
	}
}
