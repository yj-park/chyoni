package kr.co.mlec.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.member.vo.MemberVO;
import kr.co.mlec.member.vo.SearchVO;

public class MemberMapper {

	private static SqlSession sqlMapper;
	
	public MemberMapper() throws Exception {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
		System.out.println(sqlMapper);
//		test01(); // 결과값이 하나인 행이 반환, selectOne 
//		test02(); // 결과값이 여러개인 행이 반환 ,selectList 전체조회
//		insertMember(); // 
//		updateMember();
//		deleteMember();
//		selectForeach();
		dynamicSelect();
	}
	
	public void test01() throws Exception {
		// object타입 반환. 하나의 값만 조회
		// selectList
		// sql은 xml에 저장하므로 xml 파일에 접근하는 법
		// sqlMapper.selectOne(xml파일 접근, 실행 시 필요한 값);
		// (어떤 xml에서 어떤 sql을 실행할지, parametertype과 같은 데이터타입)
		/*
		MemberVO member = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo1", "member-1");
		// id가 중복될 경우를 대비해 namespace(mapper명 사용)와 함께 고유한 id로 만듦
		 
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAddr());
		
		
		MemberVO param = new MemberVO();
		param.setName("sbc");
		param.setEmail("sbc@yahoo.co.kr");
		
		MemberVO member = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo2", param);
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		System.out.println(member.getAddr());
		
		
		String id = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo3", "jsp"); 
		System.out.println("회원 아이디 : " + id);
		// "jsp"니까 parameterType은 string이고 resultType도 string이니까 id 하나만 select할 수 있음 
		//  여러 값을 가져오려면 resultType이 string[]이거나 아무튼 여러 개를 받아올 수 있는 것을 써야돼
		
		
		int count = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo4"); 
		System.out.println("전체 회원 수 : " + count);
		*/
	}

	private void test02() throws Exception {
		List<MemberVO> list = sqlMapper.selectList(
		//"kr.co.mlec.member.dao.MemberMapper.getMemberList1");
		  "kr.co.mlec.member.dao.MemberMapper.getMemberList2");
		for (MemberVO member : list) {
			System.out.println(
					member.getId() + ", " + 
				    member.getName() + ", " + 
				    member.getEmail() + ", " + 
				    member.getAddr() + ", " +
				    member.getJoinDate()
			);
		}
	}

	private void insertMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("member-5");
		member.setName("me");
		member.setAddr("Seoul");
		member.setEmail("me@yahoo.co.kr");
		sqlMapper.insert(
				"kr.co.mlec.member.dao.MemberMapper.insertMember", member);
		sqlMapper.commit();
		// commit이 되어야 실제 DB에 적용됨
		System.out.println("행이 추가되었습니다.");
		// 입력된 내용 확인(전체 내용 확인)
		test02();
	}
	
	private void updateMember() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("member-5");
		member.setName("me");
		member.setAddr("pusan");
		member.setEmail("me@yahoo.co.kr");
		sqlMapper.update(
				"kr.co.mlec.member.dao.MemberMapper.updateMember", member);
		sqlMapper.commit();
		System.out.println("행이 변경되었습니다.");
	}
	
	private void deleteMember() throws Exception {
		sqlMapper.delete("kr.co.mlec.member.dao.MemberMapper.deleteMember", "member-5");
		sqlMapper.commit();
		System.out.println("행이 삭제되었습니다.");
	}
	
	private void selectForeach() throws Exception {
		MemberVO param = new MemberVO();
		param.setName("sbc");
		param.setAddrs(new String[] {"seoul", "pusan"});
		List<MemberVO> list = sqlMapper.selectList(
			"kr.co.mlec.member.dao.MemberMapper.getMemberIteratorList", param	
		);
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		// 문자 배열이나 리스트 객체의 경우 여러 개의 값을 담을 수 있음
	}
	
	private void dynamicSelect( ) throws Exception {
		// 검색을 위한 용도
		SearchVO param = new SearchVO();
		param.setSearchType("addr");
		param.setSearchWord("e");
		
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.getMemberDynamicList2", param	
		);
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		
		
		/*
		MemberVO param = new MemberVO();
		param.setId("mem");
		param.setName("sbc");
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.getMemberDynamicList1", param		
		);
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		
		MemberVO param = new MemberVO();
		param.setName("s");
		param.setEmail("yahoo");
		// s가 들어가는 사용자 중 메일 주소에 yahoo가 들어가는 사람 검색
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.getMemberIncludeList", param		
		);
		
		int count = sqlMapper.selectOne(
				"kr.co.mlec.member.dao.MemberMapper.getMemberIncludeListCount", param		
				);
		System.out.println("전체 : " + count + "명");
		for (MemberVO member : list) {
			System.out.println("id : " + member.getId());
		}
		*/
	}
	public static void main(String[] args) {
		try {
			new MemberMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
