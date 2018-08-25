package serverwizard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serverwizard.springboot.domain.board.BoardFile;

public interface BoardFileRepository extends JpaRepository<BoardFile, Long> {
}
