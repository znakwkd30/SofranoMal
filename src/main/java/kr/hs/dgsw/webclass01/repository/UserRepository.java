package kr.hs.dgsw.webclass01.repository;

import kr.hs.dgsw.webclass01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
