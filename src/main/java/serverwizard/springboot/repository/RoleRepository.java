package serverwizard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serverwizard.springboot.domain.user.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
