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

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;
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
	private IUserService usrService;
	
	@Autowired
	private IDeptService dptService;
	
	@Autowired
	private IPositionsService poService;
	
	@Autowired
	private IRanksService ranService;
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 로그인
	 */
//	@Test
	public void userLogin() {
		map.put("user_id","USER_001");
		map.put("user_password","clip1234!");
		UserinfoVo userLogin = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.userLogin", map);
		System.out.println("##userLogin : " + userLogin);
		assertNotNull(userLogin);
	}
	
	/**
	 * 아이디찾기
	 */
//	@Test
	public void findUserId() {
		String email = "dongin7757@gmail.com";
		UserVo findUserId = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.findUserId", email);
		System.out.println("##findUserId : " + findUserId.getUser_id());
		assertNotNull(findUserId);
	}
	
	/**
	 * 비밀번호 재설정 이메일찾기
	 */
//	@Test
	public void findUserEmail() {
		String user_id = "USER_057";
		UserVo findUserEmail = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.findUserEmail", user_id);
		System.out.println("##findUserEmail : " + findUserEmail.getUser_email());
		assertNotNull(findUserEmail);
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
	public void duplicateCheckEmail() {
		map.put("user_email","dongin7777@gmail.com");
		int duplicateCheckEmail = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.duplicateCheckEmail", map);
		System.out.println("##duplicateCheckEmail : " + duplicateCheckEmail);
		assertNotNull(duplicateCheckEmail);
	}
	
	/**
	 * 사원목록 전체조회
	 */
	@Test
	public void selectUserinfoList(Map<String, Object> map) {
		int first = 1;
		int last = 5;
		List<UserinfoVo> lists = usrService.selectUserinfoList(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사원목록 검색
	 */
//	@Test
	public void searchUserinfoList() {
		map.put("user_name","김");
		map.put("ranks_name","대리");
		map.put("dept_name","설계");
		map.put("positions_name","팀장");
		map.put("start_regdate","2024-03-04");
		map.put("end_regdate","2024-03-25");
		List<UserinfoVo> lists = usrService.searchUserinfoList(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사원정보 상세조회
	 */
//	@Test
	public void selectUserinfoDetail() {
		String user_id = "USER_57";
		List<UserinfoVo> lists = usrService.selectUserinfoDetail(user_id);
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
	//@Test
	public void selectJejicDownload() {
		String user_id = "USER_1";
		List<UserinfoVo> lists = usrService.selectJejicDownload(user_id);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 *  부서 등록
	 */
	//@Test
	public void insertDept() {
		map.put("dept_name", "구디");
		int insertDept = sqlSession.insert("com.clip.gwr.model.mapper.DeptDaoImpl.insertDept",map);
		System.out.println("##insertDept : " + insertDept);
		assertNotNull(insertDept);
	}
	
	/**
	 * 부서명 수정 
	 */
	//@Test
	public void updateDept() {
		map.put("dept_name", "구디수정");
		map.put("dept_seq", "DEPT_017");
		int updateDept = sqlSession.update("com.clip.gwr.model.mapper.DeptDaoImpl.updateDept", map);
		System.out.println("##updateDept : " + updateDept);
		assertNotNull(updateDept);	
	}
	
	/**
	 * 부서 삭제 
	 */
	//@Test
	public void delDept() {
		map.put("dept_seq", "DEPT_017");
		int delDept = sqlSession.delete("com.clip.gwr.model.mapper.DeptDaoImpl.delDept",map);
		System.out.println("##delDept : " + delDept);
		assertNotNull(delDept);
	}
	/**
	 * 부서 검색 
	 */
	//@Test
	public void searchDept() {
		map.put("dept_name","설계");
		map.put("start_regdate","2024-03-03");
		map.put("end_regdate","2024-03-05");
		List<DeptVo> lists = dptService.searchDept(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	/**
	 * 부서명 중복검사 
	 */
	//@Test
	public void duplicateCheckDept() {
		map.put("dept_name", "설계");
		int duplicateCheckDept = sqlSession.selectOne("com.clip.gwr.model.mapper.DeptDaoImpl.duplicateCheckDept",map);
		System.out.println("##duplicateCheckDept : " + duplicateCheckDept);
		assertNotNull(duplicateCheckDept);
	}
	
	/**
	 *  직책 등록 
	 */
	//@Test
	public void insertPositions() {
		map.put("positions_name", "팀투");
		int insertPositions = sqlSession.insert("com.clip.gwr.model.mapper.PositionsDaoImpl.insertPositions",map);
		System.out.println("##insertPositions : " + insertPositions);
		assertNotNull(insertPositions);
	}
	
	/**
	 * 직책 수정 
	 */
	//@Test
	public void updatePositions() {
		map.put("positions_name", "팀삼");
		map.put("positions_seq", "POSITIONS_003");
		int updatePositions = sqlSession.update("com.clip.gwr.model.mapper.PositionsDaoImpl.updatePositions", map);
		System.out.println("##updatePositions : " + updatePositions);
		assertNotNull(updatePositions);	
	}
	/**
	 * 직책 삭제
	 */
	//@Test
	public void delPosition() {
		map.put("positions_seq", "POSITIONS_003");
		int delPosition = sqlSession.delete("com.clip.gwr.model.mapper.PositionsDaoImpl.delPosition",map);
		System.out.println("##delPosition : " + delPosition);
		assertNotNull(delPosition);
	}
	
	/**
	 * 직책 검색
	 */
	//@Test
	public void searchPosition() {
		map.put("positions_name","팀장");
		map.put("start_regdate","2024-03-03");
		map.put("end_regdate","2024-03-05");
		List<PositionsVo> lists = poService.searchPosition(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 직책명 중복 검사
	 */
	//@Test
	public void duplicatePosItion() {
		map.put("positions_name", "팀장");
		int duplicatePosItion = sqlSession.selectOne("com.clip.gwr.model.mapper.PositionsDaoImpl.duplicatePosItion",map);
		System.out.println("##duplicatePosItion : " + duplicatePosItion);
		assertNotNull(duplicatePosItion);
	}
	
	/**
	 * 직급 등록 
	 */
	//@Test
	public void insertRanks() {
		map.put("ranks_name", "부하");
		int insertRanks = sqlSession.insert("com.clip.gwr.model.mapper.RanksDaoImpl.insertRanks",map);
		System.out.println("##insertRanks : " + insertRanks);
		assertNotNull(insertRanks);
	}
	
	/**
	 * 직급 수정 
	 */
	//@Test
	public void updateRanks() {
		map.put("ranks_name", "쫄따구");
		map.put("ranks_seq", "RANKS_011");
		int updateRanks = sqlSession.update("com.clip.gwr.model.mapper.RanksDaoImpl.updateRanks", map);
		System.out.println("##updateRanks : " + updateRanks);
		assertNotNull(updateRanks);
	}
	
	/**
	 * 직급 삭제 
	 */
	//@Test
	public void delRanks() {
		map.put("ranks_seq", "RANKS_011");
		int delRanks = sqlSession.delete("com.clip.gwr.model.mapper.RanksDaoImpl.delRanks",map);
		System.out.println("##delRanks : " + delRanks);
		assertNotNull(delRanks);
	}
	/**
	 * 직급 검색
	 */
	//@Test
	public void searchRanks() {
		map.put("ranks_name","대리");
		map.put("start_regdate","2024-03-03");
		map.put("end_regdate","2024-03-05");
		List<RanksVo> lists = ranService.searchRanks(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 직급명 중복검색
	 */
//	@Test
	public void duplicateRanks() {
		map.put("ranks_name", "대리");
		int duplicateRanks = sqlSession.selectOne("com.clip.gwr.model.mapper.RanksDaoImpl.duplicateRanks",map);
		System.out.println("##duplicateRanks : " + duplicateRanks);
		assertNotNull(duplicateRanks);
	}
	
	/**
	 * 사용자 수 카운트
	 */
//	@Test
	public void selectUserInfoListCnt() {
		int selectUserInfoListCnt = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.selectUserInfoListCnt");
		System.out.println("##selectUserInfoListCnt : " + selectUserInfoListCnt);
		assertNotNull(selectUserInfoListCnt);
	}
	
	/**
	 * 사용자 검색 결과 수 카운트
	 */
//	@Test
	public void selectSearchUserInfoListCnt() {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("user_name","김");
//		map.put("ranks_name","대리");
//		map.put("dept_name","설계");
//		map.put("positions_name","팀원");
		map.put("user_status","Y");
//		map.put("start_regdate","2024-03-01");
//		map.put("end_regdate","2024-04-04");
		int selectSearchUserInfoListCnt = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.selectSearchUserInfoListCnt", map);
		System.out.println("##selectSearchUserInfoListCnt: " + selectSearchUserInfoListCnt);
		assertNotNull(selectSearchUserInfoListCnt);
	}
	
//	@Test
	public void selectSignImage() {
		String user_id = "USER_59";
		String selectSignImage = sqlSession.selectOne("com.clip.gwr.model.mapper.UserDaoImpl.selectSignImage", user_id);
		System.out.println("##selectSignImage: " + selectSignImage);
		assertNotNull(selectSignImage);
	}
}











