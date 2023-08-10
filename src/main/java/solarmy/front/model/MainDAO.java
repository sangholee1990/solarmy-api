package solarmy.front.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import solarmy.front.vo.*;

@Component
public class MainDAO {

    private final SqlSession sqlSession;
    private Map<String, Object> data;

    public MainDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

//    public Map<String, Object> selMemberSocket(Map<String, Object> param) throws JSONException {
//        Map<String, Object> data = sqlSession.selectOne("selMember", param);
//        return data;
//    }
//
//    public int insMemberSocket(Map<String, Object> param) throws JSONException {
//        return sqlSession.insert("insMember", param);
//    }
//
//    public int updMemberSocket(Map<String, Object> param) throws JSONException {
//        return sqlSession.update("updMember", param);
//    }

    /*************************************************************/
    public void add(String key, Object value) {
        this.data.put(key, value);
    }

    public List<Map> selCommCode(CommCodeVO vo) {
        return sqlSession.selectList("selCommCode", vo);
    }

    public List<Map> selMember(MemberVO vo) {
        return sqlSession.selectList("selMember", vo);
    }

    public List<Map> selIotProdtAuth(IotPrdctAuthVO vo) {
        return sqlSession.selectList("selIotProdtAuth", vo);
    }

    public List<Map> selKepProdtAuth(KepcoApiAuthVO vo) {
        return sqlSession.selectList("selKepProdtAuth", vo);
    }

    public List<Map> selMsgInfo(MsgInfoVO vo) {
        return sqlSession.selectList("selMsgInfo", vo);
    }

    public int insTermsCond(TermsCondVO vo) {
        return sqlSession.insert("insTermsCond", vo);
    }

    public List<Map> selSysInfo(SysInfoVO vo) {
        return sqlSession.selectList("selSysInfo", vo);
    }

    public List<Map> selInputData(InputDataVO vo) {
        return sqlSession.selectList("selInputData", vo);
    }

    public List<Map> selOutputData(OutputDataVO vo) {
        return sqlSession.selectList("selOutputData", vo);
    }

    public List<Map> selOutputStatData(OutputStatDataVO vo) {
        return sqlSession.selectList("selOutputStatData", vo);
    }

    @Transactional
    public int insIotProdtAuth(IotPrdctAuthVO vo) {
        return sqlSession.insert("insIotProdtAuth", vo);
    }

    @Transactional
    public int insMember(MemberVO vo) {
        return sqlSession.insert("insMember", vo);
    }

    @Transactional
    public int insKepProdtAuth(KepcoApiAuthVO vo) {
        return sqlSession.insert("insKepProdtAuth", vo);
    }

    @Transactional
    public int insSysInfo(SysInfoVO vo) {
        return sqlSession.insert("insSysInfo", vo);
    }

    @Transactional
    public int updSysInfo(SysInfoVO vo) {
        return sqlSession.update("updSysInfo", vo);
    }

    @Transactional
    public int updMember(MemberVO vo) {
        return sqlSession.insert("updMember", vo);
    }

    @Transactional
    public int updTermsCond(TermsCondVO vo) {
        return sqlSession.insert("updTermsCond", vo);
    }

    @Transactional
    public Integer updKepProdtAuth(KepcoApiAuthVO vo) {
        return sqlSession.insert("updKepProdtAuth", vo);
    }

    @Transactional
    public Integer updIotProdtAuth(IotPrdctAuthVO vo) {
        return sqlSession.insert("updIotProdtAuth", vo);
    }
}