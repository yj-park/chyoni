package ajax.quiz;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	public MemberVO getMemberInfo(String id) {
		MemberVO member = sqlMapper.selectOne("ajax.quiz.dao.memberMapper.getPass", id);
		return member;
	}
	
}
