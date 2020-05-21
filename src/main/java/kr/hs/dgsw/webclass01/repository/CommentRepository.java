package kr.hs.dgsw.webclass01.repository;

import kr.hs.dgsw.webclass01.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
