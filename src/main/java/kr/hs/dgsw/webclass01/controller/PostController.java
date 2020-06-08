package kr.hs.dgsw.webclass01.controller;

import kr.hs.dgsw.webclass01.entity.Post;
import kr.hs.dgsw.webclass01.protocol.ResponseFormat;
import kr.hs.dgsw.webclass01.protocol.ResponseType;
import kr.hs.dgsw.webclass01.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // json형식의 데이터 반환
public class PostController {
    @Autowired // bean객체 자동 주입
    private PostService postService;

    // method type: post
    // 포스트 생성후 return
    @PostMapping("/post/create")
    public ResponseFormat create(@RequestBody Post post) {
        Post newPost = postService.create(post);
        if(newPost != null){
            return new ResponseFormat(
                    ResponseType.POST_ADD,
                    newPost,
                    newPost.getId()
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: put
    // 포스트 데이터 업데이트
    @PutMapping("/post/update/{id}")
    public ResponseFormat update(@PathVariable Long id, @RequestBody Post post) {
        if(postService.update(id, post) != null) {
            return new ResponseFormat(
                    ResponseType.POST_UPDATE,
                    postService.update(id, post),
                    post.getId()
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: delete
    // id에 해당하는 포스트 삭제
    @DeleteMapping("/post/delete/{id}")
    public ResponseFormat delete(@PathVariable Long id) {
        if(postService.delete(id)) {
            return new ResponseFormat(
                    ResponseType.POST_DELETE,
                    postService.delete(id),
                    id
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: get
    // 포스트 1개 읽어오기
    @GetMapping("/post/read/{id}")
    public ResponseFormat read(@PathVariable Long id) {
        if(postService.read(id) != null) {
            return new ResponseFormat(
                    ResponseType.POST_GET,
                    postService.read(id),
                    id
            );

        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: get
    // 유저에 해당하는 포스트 읽어오기
    @GetMapping("/post/read/user/{userId}")
    public ResponseFormat readByUserId(@PathVariable Long userId) {
        if(postService.readByUserId(userId) != null) {
            return new ResponseFormat(
                    ResponseType.POST_GET_BY_USER,
                    postService.readByUserId(userId),
                    userId
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: get
    // 전체 포스트 읽어오기
    @GetMapping("/post/read")
    public ResponseFormat readAll() {
        if(postService.readAll() != null) {
            return new ResponseFormat(
                    ResponseType.POST_GET_ALL,
                    postService.readAll()
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }
}
