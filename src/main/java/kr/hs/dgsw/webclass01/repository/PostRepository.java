package kr.hs.dgsw.webclass01.repository;

import kr.hs.dgsw.webclass01.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // jpa repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // 유저아이디 1개 서칭해오는 함수
    Optional<Post> findTopByUserIdOrderByIdDesc(Long userId);
}
