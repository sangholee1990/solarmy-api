package solarmy.front.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import solarmy.front.vo.InputDataVO;
import solarmy.front.vo.IotPrdctAuthVO;
import solarmy.front.vo.KepcoApiAuthVO;
import solarmy.front.vo.MemberVO;
import solarmy.front.vo.MsgInfoVO;
import solarmy.front.vo.OutputDataVO;
import solarmy.front.vo.OutputStatDataVO;
import solarmy.front.vo.SysInfoVO;
import solarmy.front.vo.TermsCondVO;

@Component
public class MainDAO {

	private final SqlSession sqlSession;
	private Map<String, Object> data;

	public MainDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public Map<String, Object> selMember(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selMember", param);
		return data;
	}
	
	public Map<String, Object> selIotProdtAuth(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selIotProdtAuth", param);
		return data;
	}
	
	public Map<String, Object> selKepProdtAuth(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selKepProdtAuth", param);
		return data;
	}
	
	public Map<String, Object> selMsgInfo(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selMsgInfo", param);
		return data;
	}
	
	public int insTermsCond(Map<String, Object> param) { 
		return sqlSession.insert("insTermsCond", param);
	}
	
	public Map<String, Object> selSysInfo(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selSysInfo", param);
		return data;
	}
	
	public Map<String, Object> selInputData(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selInputData", param);
		return data;
	}
	
	public Map<String, Object> selOutputData(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selOutputData", param);
		return data;
	}
	
	public Map<String, Object> selOutputStatData(Map<String, Object> param) {
		Map<String, Object> data = sqlSession.selectOne("selOutputStatData", param);
		return data;
	}
	
	public int insIotProdtAuth(Map<String, Object> param) {
		return sqlSession.insert("insIotProdtAuth", param);
	}
	
	public int insMember(Map<String, Object> param) {
		return sqlSession.insert("insMember", param);
	}
	
	public int insKepProdtAuth(Map<String, Object> param) {
		return sqlSession.insert("insKepProdtAuth", param);
	}
	
	public int insSysInfo(Map<String, Object> param) {
		return sqlSession.insert("insSysInfo", param);
	}
	
	public int updSysInfo(Map<String, Object> param) {
		return sqlSession.update("updSysInfo", param);
	}
	
	public int updMember(Map<String, Object> param) {
		return sqlSession.insert("updMember", param);
	}
	
	public void add(String key, Object value) {
		this.data.put(key, value);
	}
}