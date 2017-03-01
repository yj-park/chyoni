package kr.co.easybook.repository.mapper;

import org.apache.ibatis.session.SqlSession;

import kr.co.easybook.common.db.MyAppSqlConfig;

public class MemberMapper {
	private static SqlSession sqlMapper;
	
	public MemberMapper() {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	
}
