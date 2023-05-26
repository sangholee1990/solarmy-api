package solarmy.front.common;

import java.util.HashMap;
import java.util.Map;

public class SolarmyException extends Exception{
	
	private String messageCode = "";
	private String messageText = "";
	
	public SolarmyException() {super();}
	
	public SolarmyException(String messageText) 
	{
		super(messageText);
		this.messageText = messageText;
	}
	
	public SolarmyException(String messageCode, String messageText) 
	{
		super(messageText);
		this.messageCode = messageCode;
		this.messageText = messageText;
	}
	
	public String getMessageCode() {return this.messageCode;}
	
	public static String errorMessage(String messageCode, String messageText)
	{
		Map<String, Object> exceptionMap = new HashMap<String, Object>();
		
		exceptionMap.put("success","N");
		exceptionMap.put("messageCode",messageCode);
		exceptionMap.put("messageText",messageText);
		
		return JsonUtil.MapToJson(exceptionMap);
	}
	
	public static String systemError()
	{
		Map<String, Object> exceptionMap = new HashMap<String, Object>();
		
		exceptionMap.put("success","N");
		exceptionMap.put("messageCode","02");
		exceptionMap.put("messageText","DB시스템 오류입니다");
		
		return JsonUtil.MapToJson(exceptionMap);
	}
}
