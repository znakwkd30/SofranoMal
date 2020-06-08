package kr.hs.dgsw.webclass01.controller;

import kr.hs.dgsw.webclass01.entity.User;
import kr.hs.dgsw.webclass01.protocol.ResponseFormat;
import kr.hs.dgsw.webclass01.protocol.ResponseType;
import kr.hs.dgsw.webclass01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // json형식의 데이터 반환
public class UserController {
    @Autowired // bean객체 자동 주입
    private UserService userService;

    // method type: post
    // 유저 생성
    @PostMapping("/user/create")
    public ResponseFormat create(@RequestBody User user){
        User newUser = userService.create(user);
        if(newUser != null){
            return new ResponseFormat(
                    ResponseType.USER_ADD,
                    newUser,
                    newUser.getId()
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: put
    // 유저 데이터 업데이트
    @PutMapping("/user/update/{id}")
    public ResponseFormat update(@PathVariable Long id, @RequestBody User user){
        if(userService.update(id, user) != null){
            return new ResponseFormat(
                    ResponseType.USER_UPDATE,
                    userService.update(id, user),
                    user.getId()
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }

    // method type: delete
    // id에 해당하는 유저 삭제
    @DeleteMapping("/user/delete/{id}")
    public ResponseFormat delete(@PathVariable Long id) {
        if(userService.delete(id)){
            return new ResponseFormat(
                    ResponseType.USER_DELETE,
                    userService.delete(id),
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
    // id에 해당하는 유저 읽어오기
    @GetMapping("/user/read/{id}")
    public ResponseFormat read(@PathVariable Long id){
        if(userService.read(id) != null){
            return new ResponseFormat(
                    ResponseType.USER_GET,
                    userService.read(id),
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
    // 유저 전체 읽어오기
    @GetMapping("/user/read")
    public ResponseFormat readAll(){
        if(userService.readAll() != null){
            return new ResponseFormat(
                    ResponseType.USER_GET_ALL,
                    userService.readAll()
            );
        } else {
            return new ResponseFormat(
                    ResponseType.FAIL,
                    null
            );
        }
    }
}
