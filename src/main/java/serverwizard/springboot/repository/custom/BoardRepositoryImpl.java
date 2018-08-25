package serverwizard.springboot.repository.custom;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import serverwizard.springboot.domain.board.Board;
import serverwizard.springboot.domain.board.QBoard;

public class BoardRepositoryImpl extends QuerydslRepositorySupport // 내부적으로 entityManager를 가지고 있음
        implements BoardRepositoryCustom {

    public BoardRepositoryImpl() {

        super(Board.class); // 부모에게 사용할 Entity 클래스를 알려줘야한다
    }

    @Override
    public Board getBoardByDsl(Long id) {
        QBoard qBoard = QBoard.board;
        return from(qBoard).where(qBoard.id.eq(id)).fetchOne();
    }
}
