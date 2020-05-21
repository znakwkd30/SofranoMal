package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.Comment;
import kr.hs.dgsw.webclass01.protocol.CommentUsernameProtocol;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    CommentUsernameProtocol add(Comment comment);
    CommentUsernameProtocol update(Long id, Comment comment);
    boolean remove(Long id);
    CommentUsernameProtocol view(Long id);
    List<CommentUsernameProtocol> listAllComments();
}
