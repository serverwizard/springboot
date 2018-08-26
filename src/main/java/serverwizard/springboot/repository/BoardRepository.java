package serverwizard.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import serverwizard.springboot.domain.board.Board;
import serverwizard.springboot.repository.custom.BoardRepositoryCustom;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    Board findBoardById(Long id); // 쿼리메소드

    @Query("SELECT b FROM Board b WHERE b.id = :id") // JPQL, (단점 : 동적인 JPQL에 대해 대응하지못함)
    Board findBoard(@Param("id") Long id); // 코드 가독성을 위해 @Param 사용, 사용하지않으면 ?표시

    @Query(value = "SELECT distinct b FROM Board b join fetch b.user order by b.id desc",
            countQuery = "SELECT count(b) FROM Board b")
    Page<Board> findBoards(Pageable page);
}



