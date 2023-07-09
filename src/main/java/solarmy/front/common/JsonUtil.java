package solarmy.front.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonUtil {

    private static Gson gson = new Gson();
    private static Gson gsonBuilder = new GsonBuilder().serializeNulls().create();

    // 생성자
    public JsonUtil() {
        // 생성자 Code
    }

    /**
     * FuncName : JsonToMap()
     * FuncDesc : Json String -> Map 형태 변환
     * Param    : param : Json String
     * Return   : Map<String, Object>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> JsonToMap(String param) {
        return gson.fromJson(param, new HashMap<String, Object>().getClass());
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> jsonToList(String param) {
        return gson.fromJson(param, new ArrayList<Map<String, String>>().getClass());
    }

    /**
     * FuncName : ListToJson()
     * FuncDesc : List -> Json String 변환
     * Param    : res : Json String
     * Return   : Json String
     */
    public static String ListToJson(List<Map<String, Object>> res) {
        return gsonBuilder.toJson(res);
    }

    /**
     * FuncName : JsonToLinkedHashMap()
     * FuncDesc : Json String -> LinkedHashMap 형태 변환(들어온 순서대로)
     * Param    : param : Json String
     * Return   : Map<String, Object>
     */
    @SuppressWarnings("unchecked")
    public static LinkedHashMap<String, Object> JsonToLinkedHashMap(String param) {
        return gson.fromJson(param, new LinkedHashMap<String, Object>().getClass());
    }

    /**
     * FuncName : OneStringToJson()
     * FuncDesc : Json String 변환
     * Param    : sData : String
     * Return   : String
     */
    public static String OneStringToJson(String sData) {
        return gson.toJson(sData);
    }

    /**
     * FuncName : HashMapToJson()
     * FuncDesc : Json String 변환
     * Param    : sData : String
     * Return   : String
     */
    public static String HashMapToJson(HashMap<String, Object> map) {
        return gson.toJson(map);
    }

    /**
     * FuncName : MapToJson()
     * FuncDesc : Json String 변환
     * Param    : sData : String
     * Return   : String
     */
    public static String MapToJson(Map<String, Object> map) {
        return gson.toJson(map);
    }

    /**
     * FuncName : ObjectToJson()
     * FuncDesc : Object -> Json String 변환
     * Param    : res : Json String
     * Return   : Json String
     */
    public static String ObjectToJson(Object obj) {
        return gsonBuilder.toJson(obj);
    }

    public static Map<String, Object> getParamMap(String[] skey, JSONObject requestBody) throws JSONException {
        Map<String, Object> paramMap = new HashMap<>();

        if (skey != null && skey.length > 0) {
            for (int i = 0; i < skey.length; i++) {
                paramMap.put(skey[i], requestBody.get(skey[i]).toString());
            }
        }

        return paramMap;
    }
}