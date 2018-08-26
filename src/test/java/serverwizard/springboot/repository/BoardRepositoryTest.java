package serverwizard.springboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import serverwizard.springboot.domain.board.Board;
import serverwizard.springboot.domain.board.BoardFile;

import java.util.List;


/**
 * Controller 테스트 (의존관계인 서비스객체가 안만들어져있는 상태에도 테스트가능)
 * - Mock객체를 만들어서 테스트 가능 (의존관계맺힌 Service를 Mock, Spy으로 만듦)
 *   (mockito프레임워크)
 *  - mock이용할때 해당 서비스 인터페이스는 있어야한다. (선언을위해) 하지 구현체는 없어도 된다.
 *
 *  정적테스트 : (요구사항, 분석, 설계)동료검토, 리뷰
 *  동적테스트 : 구현하고나서 테스트하는것
 *
 *
 *  V-model
 * 단위테스트(컨트롤러만 테스트) -> 통합테스트 (컨트롤러와 서비스 합쳐서 테스트) -> 시스템테스트-> 인수테스트
 *
 * 배움의 목적은 스스로 연습할수 있을정도로만 배우면된다
 * 나머지는 혼자서 연습을 부단히해야한다
 *
 */

@RunWith(SpringRunner.class) // junit에서 spring과 관련된 기능을 사용할수있음
@DataJpaTest // jpa관련된것만 테스트하겠다는 의미
//@SpringBootTest : 모든설정, 모든라이브러리를 다읽어들인다음 테스트하겠다
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    // JPA에서 제공
    @Test
    public void test_get_board_by_id() {
        System.out.println("----------------------------------");
        Board board = boardRepository.getOne(1L);
        System.out.println(board.getClass().getName()); // Entity객체는 Entity객체를 상속받는 프락시 객체가 자동으로 생성됨
        System.out.println(board.getId() + ", " + board.getTitle());
        System.out.println(board.getUser());
        System.out.println(board.getUser().getName());
        System.out.println("----------------------------------");
    }

    // 쿼리 메소드
    @Test
    public void test_get_board_by_id_2() {
        System.out.println("----------------------------------");
        Board board = boardRepository.findBoardById(1L);
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + ", " + board.getTitle());
        System.out.println(board.getUser());
        System.out.println(board.getUser().getName());
        System.out.println("----------------------------------");
    }

    // JPQL
    @Test
    public void test_get_board_by_id_3() {
        System.out.println("----------------------------------");
        Board board = boardRepository.findBoard(1L);
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + ", " + board.getTitle());
        System.out.println(board.getUser());
        System.out.println(board.getUser().getName());
        System.out.println("----------------------------------");
    }

    // DSL
    @Test
    public void test_get_board_by_id_4() {
        System.out.println("----------------------------------");
        Board board = boardRepository.getBoardByDsl(1L);
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + ", " + board.getTitle());
        System.out.println(board.getUser());
        System.out.println(board.getUser().getName());
        System.out.println("----------------------------------");
    }

    @Test
    public void testGetBoardList1() throws Exception {
        System.out.println("----------------------------------");
        List<Board> list = boardRepository.findAll();
        for(Board board : list) {
            System.out.println(board.getId() + ", " + board.getTitle());
            System.out.println("***********************************");
            List<BoardFile> boardFiles = board.getBoardFiles(); // List가 프록시 객체
            for (BoardFile boardFile : boardFiles) {
                System.out.println(boardFile.getName());
            }
            System.out.println("***********************************");
        }
        System.out.println("----------------------------------");
    }
}