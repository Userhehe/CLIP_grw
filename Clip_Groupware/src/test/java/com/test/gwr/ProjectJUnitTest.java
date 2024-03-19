package com.test.gwr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class ProjectJUnitTest {


    @Autowired
    private ProjectBoardMapper projectBoardMapper;

    private ProjectBoard testProjectBoard;

    @BeforeEach
    public void setUp() {
        // 테스트용 프로젝트 게시글 객체 생성
        testProjectBoard = new ProjectBoard();
        testProjectBoard.setTitle("Test Title");
        testProjectBoard.setContent("Test Content");
        testProjectBoard.setUserId("USER_004");
    }

    @AfterEach
    public void tearDown() {
        // 테스트 이후에 데이터 정리
        projectBoardMapper.deleteProjectBoard(testProjectBoard.getSeq());
    }

    @Test
    public void testInsertProjectBoard() {
        // 새로운 프로젝트 게시글 추가
        projectBoardMapper.insertProjectBoard(testProjectBoard);

        // 추가된 게시글 조회
        ProjectBoard retrievedProjectBoard = projectBoardMapper.getProjectBoardById(testProjectBoard.getSeq());

        // 추가된 게시글의 제목과 내용이 기대한 대로인지 확인
        assertEquals(testProjectBoard.getTitle(), retrievedProjectBoard.getTitle());
        assertEquals(testProjectBoard.getContent(), retrievedProjectBoard.getContent());
    }

    @Test
    public void testUpdateProjectBoardContent() {
        // 새로운 프로젝트 게시글 추가
        projectBoardMapper.insertProjectBoard(testProjectBoard);

        // 수정할 내용 설정
        String updatedContent = "Updated Test Content";
        testProjectBoard.setContent(updatedContent);

        // 게시글 내용 업데이트
        projectBoardMapper.updateProjectBoardContent(testProjectBoard);

        // 수정된 게시글 조회
        ProjectBoard retrievedProjectBoard = projectBoardMapper.getProjectBoardById(testProjectBoard.getSeq());

        // 수정된 내용이 기대한 대로인지 확인
        assertEquals(updatedContent, retrievedProjectBoard.getContent());
    }

    @Test
    public void testDeleteProjectBoard() {
        // 새로운 프로젝트 게시글 추가
        projectBoardMapper.insertProjectBoard(testProjectBoard);

        // 게시글 삭제
        projectBoardMapper.deleteProjectBoard(testProjectBoard.getSeq());

        // 삭제된 게시글 조회
        ProjectBoard deletedProjectBoard = projectBoardMapper.getProjectBoardById(testProjectBoard.getSeq());

        // 삭제된 게시글이 null인지 확인
        assertEquals(null, deletedProjectBoard);
    }

    @Test
    public void testGetAllProjectBoards() {
        // 테스트를 위해 추가할 더미 프로젝트 게시글
        ProjectBoard dummyProjectBoard = new ProjectBoard();
        dummyProjectBoard.setTitle("Dummy Title");
        dummyProjectBoard.setContent("Dummy Content");
        dummyProjectBoard.setUserId("USER_005");
        projectBoardMapper.insertProjectBoard(dummyProjectBoard);

        // 모든 프로젝트 게시글 조회
        List<ProjectBoard> projectBoards = projectBoardMapper.getAllProjectBoards();

        // 추가된 더미 게시글이 포함되어 있는지 확인
        assertEquals(1, projectBoards.size());
    }
}