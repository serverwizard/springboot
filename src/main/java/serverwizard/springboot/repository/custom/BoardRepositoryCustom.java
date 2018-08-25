package serverwizard.springboot.repository.custom;


import serverwizard.springboot.domain.board.Board;

// ## 2가지 정도의 메소드가 해당 인터페이스에 올수 있다
// 1. dynamic sql로 실행해야할 메소드
// 2. 복잡한 JPQL로 실행해야할 메소드???
public interface BoardRepositoryCustom {
    Board getBoardByDsl(Long id);

}
