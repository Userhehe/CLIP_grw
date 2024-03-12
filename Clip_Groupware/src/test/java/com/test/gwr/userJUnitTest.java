package com.test.gwr;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class userJUnitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IUserService service;
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 로그인
	 */
//	@Test
	public void userLogin() {
		map.put("user_id","USER_001");
		map.put("user_password","clip1234!");
		UserVo userLogin = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.userLogin", map);
		System.out.println("##userLogin : " + userLogin);
		assertNotNull(userLogin);
	}
	
	/**
	 * 아이디찾기
	 */
//	@Test
	public void findUserId() {
		map.put("user_email", "dongin7777@gmail.com");
		UserVo findUserId = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.findUserId", map);
		System.out.println("##findUserId : " + findUserId.getUser_id());
		assertNotNull(findUserId);
	}
	
	/**
	 * 비밀번호 재설정
	 */
//	@Test
	public void updateUserPassword() {
		map.put("user_password", "clip12345!");
		map.put("user_email", "dongin7777@gmail.com");
		int updateUserPassword = sqlSession.update("com.clip.gwr.model.mapper.UserDaoImpl.updateUserPassword", map);
		System.out.println("##updateUserPassword : " + updateUserPassword);
		assertNotNull(updateUserPassword);
	}
	
	/**
	 * 인증번호 저장
	 */
//	@Test
	public void updateUserCertnum() {
		Random random = new Random();
		int ranNum = random.nextInt(900000) + 100000;
		System.out.println("##ranNum : " + ranNum);
		
		map.put("user_certnum", ranNum);
		map.put("user_email", "dongin7777@gmail.com");
		int updateUserCertnum = sqlSession.update("com.clip.gwr.model.mapper.UserDaoImpl.updateUserCertnum", map);
		System.out.println("##updateUserCertnum : " + updateUserCertnum);
		assertNotNull(updateUserCertnum);
	}
	
	/**
	 * 인증번호 확인
	 */
//	@Test
	public void comparisonCertNum() {
		map.put("user_certnum", 576179);
		map.put("user_email", "dongin7777@gmail.com");
		int comparisonCertNum = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.comparisonCertNum", map);
		System.out.println("##comparisonCertNum : " + comparisonCertNum);
		assertNotNull(comparisonCertNum);
	}
	
	
	/**
	 * 사원정보 등록
	 */
//	@Test
	public void insertUserinfo() {
		map.put("user_name", "서종우");
		map.put("user_registnum", "950423-1049382");
		map.put("user_phonenum", "010-1122-4455");
		map.put("user_email", "jongu@naver.com");
		map.put("user_birthday", "19950423");
		map.put("user_address", "서울특별시 금천구 가산동");
		map.put("ranks_name", "대리");
		map.put("dept_name", "영업");
		map.put("positions_name", "팀장");
		int insertUserinfo = sqlSession.insert("com.clip.gwr.model.mapper.UserDaoImpl.insertUserinfo",map);
		System.out.println("##insertUserinfo : " + insertUserinfo);
		assertNotNull(insertUserinfo);
	}
	
	/**
	 * 이메일&연락처 중복체크
	 */
//	@Test
	public void duplicateCheckUserinfo() {
		map.put("user_email","dongin7777@gmail.com");
		map.put("user_phonenum","010-1234-5678");
		int duplicateCheckUserinfo = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.duplicateCheckUserinfo", map);
		System.out.println("##duplicateCheckUserinfo : " + duplicateCheckUserinfo);
		assertNotNull(duplicateCheckUserinfo);
	}
	
	/**
	 * 사원목록 전체조회
	 */
//	@Test
	public void selectUserinfoList() {
		List<UserinfoVo> lists = service.selectUserinfoList();
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사원목록 검색
	 */
//	@Test
	public void searchUserinfoList() {
		map.put("user_id","USER_0");
		map.put("user_name","김");
		map.put("ranks_name","대리");
		map.put("dept_name","설계");
		map.put("positions_name","팀장");
		map.put("start_regdate","2024-03-04");
		map.put("end_regdate","2024-03-04");
		List<UserinfoVo> lists = service.searchUserinfoList(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사원정보 상세조회
	 */
//	@Test
	public void selectUserinfoDetail() {
		map.put("user_id","USER_001");
		List<UserinfoVo> lists = service.selectUserinfoDetail(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사원정보 수정
	 */
//	@Test
	public void updateUserinfo() {
		map.put("user_name","홍길동");
		map.put("user_registnum","980101-1049233");
		map.put("user_phonenum","010-1112-2224");
		map.put("user_email","gildong7777@gmail.com");
		map.put("user_birthday","1998-01-01");
		map.put("user_address","서울특별시 구로구 구로동");
		map.put("ranks_name","사원");
		map.put("dept_name","인사");
		map.put("positions_name","팀원");
		map.put("user_auth","A");
		map.put("user_status","Y");
		map.put("user_id","USER_012");
		int updateUserinfo = sqlSession.update("com.clip.gwr.model.mapper.UserDaoImpl.updateUserinfo",map);
		System.out.println("##updateUser : " + updateUserinfo);
		assertNotNull(updateUserinfo);
	}
	
	/**
	 * 재직증명서 다운로드
	 */
	@Test
	public void selectJejicDownload() {
		map.put("user_id","USER_001");
		List<UserinfoVo> lists = service.selectJejicDownload(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
}
