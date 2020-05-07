package kr.hs.dgsw.webclass01.controller;

import kr.hs.dgsw.webclass01.entity.User;
import kr.hs.dgsw.webclass01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // 존재하는 Bean 자동 주입
    @Autowired
    // UserService 객체 생성
    private UserService userService;

    // HTTP Request 매핑
    @GetMapping("/user")
    // Http Response Body 사용
    @ResponseBody
    // 유저리스트 반환하는 함수
    public List<User> list() { return userService.list(); }

    // HTTP Request 매핑
    @GetMapping("/user/{id}")
    // Http Response Body 사용
    @ResponseBody
    // 유저 아이디를 받아서 해당 유저를 리턴
    public User view(@PathVariable String id) {
        return userService.view(id);
    }

    // HTTP Request 매핑
    @PostMapping("/user")
    // Http Response Body 사용
    @ResponseBody
    // 유저 추가
    public boolean add(@RequestBody User user) {
        return userService.add(user);
    }

    // HTTP Request 매핑
    @PutMapping("/user")
    // Http Response Body 사용
    @ResponseBody
    // 유저 데이터 업데이트
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    // HTTP Request 매핑
    @DeleteMapping("/user/{id}")
    // Http Response Body 사용
    @ResponseBody
    // 유저 삭제
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
