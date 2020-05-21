package kr.hs.dgsw.webclass01.protocol;

import kr.hs.dgsw.webclass01.entity.Comment;

public class CommentUsernameProtocol extends Comment {
    private String userName;
    public CommentUsernameProtocol(Comment c, String userName) {
        super(c);
        this.userName = userName;
    }
}
