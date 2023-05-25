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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import solarmy.front.common.MandatoryParamCheck;
import solarmy.front.common.SolarmyException;
import solarmy.front.model.MainDAO;
import solarmy.front.vo.DataVO;
import solarmy.front.vo.ErrorVO;
import solarmy.front.vo.InputDataVO;
import solarmy.front.vo.IotPrdctAuthVO;
import solarmy.front.vo.KepcoApiAuthVO;
import solarmy.front.vo.MemberVO;
import solarmy.front.vo.MsgInfoVO;
import solarmy.front.vo.OutputDataVO;
import solarmy.front.vo.OutputStatDataVO;
import solarmy.front.vo.ReqVO;
import solarmy.front.vo.SampleResponse;
import solarmy.front.vo.SysInfoVO;
import solarmy.front.vo.TermsCondVO;

@RestController
public class MainController extends MandatoryParamCheck {
	
	@Autowired
	MainDAO main_dao;
	
	private final String REQHEADER = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2FjY291bnQiOjI0fQ.pXluG0rOyeoO8xSvAFYCOrkIaYofUkUR3dIijJOT6xg";
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	 
	@ApiOperation(value = "회원정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-member")
	//public ResponseEntity<?> selMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception{
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
			
			ret = main_dao.selMember(vo);
			return new ResponseEntity<String>(ret,  HttpStatus.OK);
			
			/*
			SampleResponse response = new SampleResponse();
			
			
			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getCustomer_link_number() == null || vo.getSns_key() == null){
				code = "11";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selMember(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			//return ResponseEntity.ok(response);
			 
			 
			return new ResponseEntity<>(response,  HttpStatus.OK);
			*/
		}catch (MyBatisSystemException e) {
			return new ResponseEntity<String>(SolarmyException.systemError(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "기상 외부 데이터 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-outputData")
	public ResponseEntity<?> selOutputData(HttpServletRequest request, @ModelAttribute OutputDataVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getCustomer_link_number() == null || vo.getDate() == null || vo.getTime() == null){
				code = "11";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selOutputData(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "IOT 제품 인증 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-iotProdtAuth")
	public ResponseEntity<?> selIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getProduct_serial_number() == null){
				code = "11";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selIotProdtAuth(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "한전API 제품 인증 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-kepProdtAuth")
	public ResponseEntity<?> selKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getKepco_api_key() == null){
				code = "30";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selKepProdtAuth(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "메시지 정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-msgInfo")
	public ResponseEntity<?> selMsgInfo(HttpServletRequest request, @ModelAttribute MsgInfoVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else {
				obj = main_dao.selMsgInfo(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "시스템 정보 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-sysInfo")
	public ResponseEntity<?> selSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getCustomer_link_number() == null){
				code = "11";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selSysInfo(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "IOT 내부 데이터 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-inputData")
	public ResponseEntity<?> selInputData(HttpServletRequest request, @ModelAttribute InputDataVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getProduct_serial_number() == null || vo.getDate() == null || vo.getTime() == null){
				code = "11";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selInputData(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "기상 외부 통계 데이터 조회", notes = "특정 조건에 맞는 정보를 조회합니다.")
	@GetMapping(value = "/api/sel-outputStatData")
	public ResponseEntity<?> selOutputStatData(HttpServletRequest request, @ModelAttribute OutputStatDataVO vo) throws Exception {
		List<Map> obj = null;
		String code = "00";
		String reqUrl = request.getRequestURL().toString();;
		try {
			SampleResponse response = new SampleResponse();
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");

			if(!header.equals(REQHEADER)) {
				code = "30";
				throw new NullPointerException();
			}else if(vo.getCustomer_link_number() == null || vo.getDate() == null || vo.getTime() == null){
				code = "11";
				throw new NullPointerException(); 
			}else {
				obj = main_dao.selOutputStatData(vo);
			}
			
			DataVO data = new DataVO();
			int cnt = obj == null ? 0 : obj.size();
			data.setCnt(cnt);
			data.setList(obj);
			
			ReqVO req = new ReqVO();
			req.setSrv(reqUrl);
			req.setVar(vo);
			
			response.setCode(code);
			response.setData(data);
			response.setReq(req);
			
			return ResponseEntity.ok(response);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			ErrorVO err = new ErrorVO();
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "회원정보 등록", notes = "회원정보를 등록합니다.")
	@PostMapping(value = "/api/ins-member")
	public ResponseEntity<?> insMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else {
				main_dao.insMember(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "시스템 정보 등록", notes = "시스템 정보를 등록합니다.")
	@PostMapping(value = "/api/ins-sysInfo")
	public ResponseEntity<?> insSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {		
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else {
				main_dao.insSysInfo(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}

	@ApiOperation(value = "약관 동의 등록", notes = "약관 동의를 등록합니다.")
	@PostMapping(value = "/api/ins-termsCond")
	public ResponseEntity<?> insTermsCond(HttpServletRequest request, @ModelAttribute TermsCondVO vo) throws Exception {
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else {
				main_dao.insTermsCond(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "한전API 제품 인증 수정", notes = "한전API 제품 인증을 등록합니다.")
	@PostMapping(value = "/api/ins-kepProdtAuth")
	public ResponseEntity<?> insKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else {
				main_dao.insKepProdtAuth(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "IOT 제품 인증 수정", notes = "IOT 제품 인증을 등록합니다.")
	@PostMapping(value = "/api/ins-iotProdtAuth")
	public ResponseEntity<?> insIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else {
				main_dao.insIotProdtAuth(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "회원정보 수정", notes = "customer_link_number를 이용하여 회원정보를 수정합니다.")
	@PutMapping(value = "/api/upd-member")
	public ResponseEntity<?> updMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else if(vo.getCustomer_link_number() == null || vo.getSns_key() == null){
				code = "11"; 
				throw new NullPointerException();
			}else {
				main_dao.updMember(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
	}
	
	@ApiOperation(value = "시스템 정보 수정", notes = "customer_link_number를 이용하여 시스템 정보를 수정합니다.")
	@PutMapping(value = "/api/upd-sysInfo")
	public ResponseEntity<?> updSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
		String code = "00";
		ErrorVO err = new ErrorVO();
		String reqUrl = request.getRequestURL().toString();;
		try {
			String header = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
			
			if(!header.equals(REQHEADER)) {
				code = "01";
				throw new NullPointerException();
			}else if(vo.getCustomer_link_number() == null){
				code = "11"; 
				throw new NullPointerException();
			}else {
				main_dao.updSysInfo(vo);
			}
			
			err.setMessage("SUCCESS");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch(NullPointerException  e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode(code);
			return ResponseEntity.ok(err);
		}catch (MyBatisSystemException e) {
			log.info("[{}] {}", reqUrl, vo.toString());
			err.setMessage("ERROR");
			err.setCode("02");
			return ResponseEntity.ok(err);
		}
		
	}
}