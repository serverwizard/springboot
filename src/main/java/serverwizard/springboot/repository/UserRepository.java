package serverwizard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serverwizard.springboot.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
