package solarmy.front.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import solarmy.front.common.JsonUtil;
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
	private String NS;
	private Map<String, Object> data;

	public MainDAO(SqlSession sqlSession) {
		NS = this.getClass().getSimpleName() + ".";
		this.sqlSession = sqlSession;
	}
	
	//public List<Map> selMember(MemberVO vo) {
	public String selMember(MemberVO vo) throws JSONException {
		List<Map<String, Object>> data = sqlSession.selectList("selMember", vo);
		return JsonUtil.convertListToJson(data);
	}
	
	public int insMember(MemberVO vo) {
		return sqlSession.insert("insMember", vo);
	}
	
	public int updMember(MemberVO vo) {
		return sqlSession.insert("updMember", vo);
	}
	
	public List<Map> selIotProdtAuth(IotPrdctAuthVO vo) {
		List<Map> data = sqlSession.selectList("selIotProdtAuth", vo);
		return data;
	}
	
	public int insIotProdtAuth(IotPrdctAuthVO vo) {
		return sqlSession.insert("insIotProdtAuth", vo);
	}
	
	public List<Map> selKepProdtAuth(KepcoApiAuthVO vo) {
		List<Map> data = sqlSession.selectList("selKepProdtAuth", vo);
		return data;
	}
	
	public int insKepProdtAuth(KepcoApiAuthVO vo) {
		return sqlSession.insert("insKepProdtAuth", vo);
	}
	
	public List<Map> selMsgInfo(MsgInfoVO vo) {
		List<Map> data = sqlSession.selectList("selMsgInfo", vo);
		return data;
	}
	
	public int insTermsCond(TermsCondVO vo) { 
		return sqlSession.insert("insTermsCond", vo);
	}
	
	public List<Map> selSysInfo(SysInfoVO vo) {
		List<Map> data = sqlSession.selectList("selSysInfo", vo);
		return data;
	}
	
	public int updSysInfo(SysInfoVO vo) {
		return sqlSession.update("updSysInfo", vo);
	}
	
	public int insSysInfo(SysInfoVO vo) {
		return sqlSession.insert("insSysInfo", vo);
	}
	
	public List<Map> selInputData(InputDataVO vo) {
		List<Map> data = sqlSession.selectList("selInputData", vo);
		return data;
	}
	
	public List<Map> selOutputData(OutputDataVO vo) {
		List<Map> data = sqlSession.selectList("selOutputData", vo);
		return data;
	}
	
	public List<Map> selOutputStatData(OutputStatDataVO vo) {
		List<Map> data = sqlSession.selectList("selOutputStatData", vo);
		return data;
	}
	
	public void add(String key, Object value) {
		this.data.put(key, value);
	}

}