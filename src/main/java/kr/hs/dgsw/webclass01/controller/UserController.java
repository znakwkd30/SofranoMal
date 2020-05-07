package kr.hs.dgsw.webclass01.controller;

import kr.hs.dgsw.webclass01.entity.User;
import kr.hs.dgsw.webclass01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // 유저리스트 반환
    @GetMapping("/user")
    @ResponseBody
    public List<User> list() { return userService.list(); }

    // 유저 아이디를 받아서 해당 유저를 리턴
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) {
        return userService.view(id);
    }

    // 유저 추가
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) {
        return userService.add(user);
    }

    // 유저 데이터 업데이트
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.update(user);
    }


    // 유저 삭제
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
