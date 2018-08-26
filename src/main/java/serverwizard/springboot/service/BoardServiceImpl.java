package serverwizard.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import serverwizard.springboot.domain.board.Board;
import serverwizard.springboot.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    // 생성자를 통한 의존성 주입 (스프링을 안써도 사용할 수 있다(직접 주입), 호환성 측면에서 좋다)
    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public Page<Board> getBoards(int page) {
        Pageable pageable = PageRequest.of(page -1, 2);
        return boardRepository.findBoards(pageable);
    }
}