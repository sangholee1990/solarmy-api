package solarmy.front.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import solarmy.front.common.JsonUtil;
import solarmy.front.common.MandatoryParamCheck;
import solarmy.front.common.SolarmyException;
import solarmy.front.model.MainDAO;
import solarmy.front.vo.InputDataVO;
import solarmy.front.vo.IotPrdctAuthVO;
import solarmy.front.vo.KepcoApiAuthVO;
import solarmy.front.vo.MemberVO;
import solarmy.front.vo.MsgInfoVO;
import solarmy.front.vo.OutputDataVO;
import solarmy.front.vo.OutputStatDataVO;
import solarmy.front.vo.SysInfoVO;
import solarmy.front.vo.TermsCondVO;

@RestController
public class MainController extends MandatoryParamCheck {
	
	@Autowired
	MainDAO main_dao;
	 
	@ApiOperation(value = "회원정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-member")
	public ResponseEntity<String> selMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception{
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"customer_link_number","sns_key"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selMemberTest(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "기상 외부 데이터 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-outputData")
	public ResponseEntity<String> selOutputData(HttpServletRequest request, @ModelAttribute OutputDataVO vo) throws Exception {
		/*
		 * else if(vo.getCustomer_link_number() == null || vo.getDate() == null ||
		 * vo.getTime() == null) obj = main_dao.selOutputData(vo);
		 */
		
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"customer_link_number","date", "time"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selOutputData(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "IOT 제품 인증 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-iotProdtAuth")
	public ResponseEntity<String> selIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
		/*
		 * else if(vo.getProduct_serial_number() == null){ code = "11"; throw new
		 * NullPointerException(); }else { obj = main_dao.selIotProdtAuth(vo); }
		 */
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"product_serial_number"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selIotProdtAuth(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "한전API 제품 인증 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-kepProdtAuth")
	public ResponseEntity<String> selKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
		/*
		 * else if(vo.getKepco_api_key() == null){ code = "30"; throw new
		 * NullPointerException(); }else { obj = main_dao.selKepProdtAuth(vo); }
		 */
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"kepco_api_key"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selKepProdtAuth(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "메시지 정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-msgInfo")
	public ResponseEntity<String> selMsgInfo(HttpServletRequest request, @ModelAttribute MsgInfoVO vo) throws Exception {
		//obj = main_dao.selMsgInfo(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"msg_code"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selMsgInfo(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "시스템 정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-sysInfo")
	public ResponseEntity<String> selSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
		/*
		 * else if(vo.getCustomer_link_number() == null){ code = "11"; throw new
		 * NullPointerException(); }else { obj = main_dao.selSysInfo(vo); }
		 */
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"customer_link_number"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selSysInfo(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "IOT 내부 데이터 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-inputData")
	public ResponseEntity<String> selInputData(HttpServletRequest request, @ModelAttribute InputDataVO vo) throws Exception {
		/*
		 * else if(vo.getProduct_serial_number() == null || vo.getDate() == null ||
		 * vo.getTime() == null){ code = "11"; throw new NullPointerException(); }else {
		 * obj = main_dao.selInputData(vo);
		 */
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"product_serial_number","date", "time"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selInputData(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "기상 외부 통계 데이터 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-outputStatData")
	public ResponseEntity<String> selOutputStatData(HttpServletRequest request, @ModelAttribute OutputStatDataVO vo) throws Exception {
		/*
		 * else if(vo.getCustomer_link_number() == null || vo.getDate() == null ||
		 * vo.getTime() == null){ code = "11"; throw new NullPointerException(); }else {
		 * obj = main_dao.selOutputStatData(vo); }
		 */
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"customer_link_number","date", "time"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			Map<String, Object> retObj = main_dao.selOutputStatData(vo);
			
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
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "회원정보 등록", notes = "회원정보를 등록합니다.")
	@PostMapping(value = "/api/ins-member")
	public ResponseEntity<String> insMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
		//main_dao.insMember(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
						
			int retVal = main_dao.insMember(vo);
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 입력에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "시스템 정보 등록", notes = "시스템 정보를 등록합니다.")
	@PostMapping(value = "/api/ins-sysInfo")
	public ResponseEntity<String> insSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {		
		//main_dao.insSysInfo(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			int retVal = main_dao.insSysInfo(vo);
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 입력에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "약관 동의 등록", notes = "약관 동의를 등록합니다.")
	@PostMapping(value = "/api/ins-termsCond")
	public ResponseEntity<String> insTermsCond(HttpServletRequest request, @ModelAttribute TermsCondVO vo) throws Exception {
		//main_dao.insTermsCond(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
						
			int retVal = main_dao.insTermsCond(vo);
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 입력에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "한전API 제품 인증 수정", notes = "한전API 제품 인증을 등록합니다.")
	@PostMapping(value = "/api/ins-kepProdtAuth")
	public ResponseEntity<String> insKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
		//main_dao.insKepProdtAuth(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			int retVal = main_dao.insKepProdtAuth(vo);
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 입력에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "IOT 제품 인증 수정", notes = "IOT 제품 인증을 등록합니다.")
	@PostMapping(value = "/api/ins-iotProdtAuth")
	public ResponseEntity<String> insIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
		//main_dao.insIotProdtAuth(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			int retVal = main_dao.insIotProdtAuth(vo);
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 입력에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "회원정보 수정", notes = "customer_link_number를 이용하여 회원정보를 수정합니다.")
	@PutMapping(value = "/api/upd-member")
	public ResponseEntity<String> updMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
		//main_dao.updMember(vo);
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"customer_link_number","sns_key"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			int retVal = main_dao.updMember(vo);
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 수정에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "시스템 정보 수정", notes = "customer_link_number를 이용하여 시스템 정보를 수정합니다.")
	@PutMapping(value = "/api/upd-sysInfo")
	public ResponseEntity<String> updSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
		/*
		 * else if(vo.getCustomer_link_number() == null){ code = "11"; throw new
		 * NullPointerException(); }else { main_dao.updSysInfo(vo); }
		 */
		String ret = null;
		String reqUrl = request.getRequestURL().toString();;
		try {
			
			String headerParam = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			ret = this.isHeaderCheck(reqUrl, headerParam);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			JSONObject requestBody = new JSONObject(vo);
			String[] sKey = {"customer_link_number"};
			ret = this.isParamCheck(reqUrl, sKey, requestBody);
			if(ret != null) {return new ResponseEntity<String>(ret, HttpStatus.OK);}
			
			int retVal = main_dao.updSysInfo(vo);
			
			if(retVal < 1)	return new ResponseEntity<String>(SolarmyException.errorMessage("01", "어플리케이션 에러"), HttpStatus.OK);
			
			JSONObject Obj1 = new JSONObject();
			
			Obj1.put("code", "00");
			Obj1.put("success", "Y");
			Obj1.put("messageText", "데이터 수정에 성공하였습니다.");
			
			return new ResponseEntity<String>(Obj1.toString(),  HttpStatus.OK);
			
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}