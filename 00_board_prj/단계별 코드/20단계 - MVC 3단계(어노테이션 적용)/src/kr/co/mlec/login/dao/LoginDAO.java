package kr.co.mlec.login.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.MemberVO;
import kr.co.mlec.common.db.MyAppSqlConfig;

public class LoginDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	public MemberVO getMemberInfo(String id, String password) {
		//회원
		MemberVO member = sqlMapper.selectOne(
				"kr.co.mlec.login.dao.LoginMapper.getPass", id);

		return member;
	}

}
