package serverwizard.springboot.service;

import org.springframework.data.domain.Page;
import serverwizard.springboot.domain.board.Board;

public interface BoardService {
    Page<Board> getBoards(int page);
}