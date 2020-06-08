package kr.hs.dgsw.webclass01.repository;

import kr.hs.dgsw.webclass01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // jpa repository
public interface UserRepository extends JpaRepository<User, Long> {
    // accout로 유저 찾기
    Optional<User> findByAccount(String accout);
}
