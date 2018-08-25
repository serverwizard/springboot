package serverwizard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serverwizard.springboot.domain.board.BoardCategory;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {
}
