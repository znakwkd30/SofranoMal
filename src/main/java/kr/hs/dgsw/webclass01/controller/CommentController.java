package kr.hs.dgsw.webclass01.controller;

import kr.hs.dgsw.webclass01.entity.Comment;
import kr.hs.dgsw.webclass01.protocol.CommentUsernameProtocol;
import kr.hs.dgsw.webclass01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    public CommentUsernameProtocol add(@RequestBody Comment comment) {
        return commentService.add(comment);
    }

    @PutMapping("/comment/update/{id}")
    public CommentUsernameProtocol update(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("/comment/remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return commentService.remove(id);
    }

    @GetMapping("/comment/view/{id}")
    public CommentUsernameProtocol view(@PathVariable Long id) {
        return commentService.view(id);
    }

    @GetMapping("/comment/list")
    public List<CommentUsernameProtocol> listAllComments() {
        return commentService.listAllComments();
    }
}
