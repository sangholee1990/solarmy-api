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
	
	public Map<String, Object> selMemberTest(MemberVO vo) throws JSONException {
		Map<String, Object> data = sqlSession.selectOne("selMember", vo);
		return data;
	}
	
	public Map<String, Object> selMember(MemberVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selMember", vo);
		return data;
	}
	
	public Map<String, Object> selIotProdtAuth(IotPrdctAuthVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selIotProdtAuth", vo);
		return data;
	}
	
	public Map<String, Object> selKepProdtAuth(KepcoApiAuthVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selKepProdtAuth", vo);
		return data;
	}
	
	public Map<String, Object> selMsgInfo(MsgInfoVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selMsgInfo", vo);
		return data;
	}
	
	public int insTermsCond(TermsCondVO vo) { 
		return sqlSession.insert("insTermsCond", vo);
	}
	
	public Map<String, Object> selSysInfo(SysInfoVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selSysInfo", vo);
		return data;
	}
	
	public Map<String, Object> selInputData(InputDataVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selInputData", vo);
		return data;
	}
	
	public Map<String, Object> selOutputData(OutputDataVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selOutputData", vo);
		return data;
	}
	
	public Map<String, Object> selOutputStatData(OutputStatDataVO vo) {
		Map<String, Object> data = sqlSession.selectOne("selOutputStatData", vo);
		return data;
	}
	
	public int insIotProdtAuth(IotPrdctAuthVO vo) {
		return sqlSession.insert("insIotProdtAuth", vo);
	}
	
	public int insMember(MemberVO vo) {
		return sqlSession.insert("insMember", vo);
	}
	
	public int insKepProdtAuth(KepcoApiAuthVO vo) {
		return sqlSession.insert("insKepProdtAuth", vo);
	}
	
	public int insSysInfo(SysInfoVO vo) {
		return sqlSession.insert("insSysInfo", vo);
	}
	
	public int updSysInfo(SysInfoVO vo) {
		return sqlSession.update("updSysInfo", vo);
	}
	
	public int updMember(MemberVO vo) {
		return sqlSession.insert("updMember", vo);
	}
	
	public void add(String key, Object value) {
		this.data.put(key, value);
	}
}