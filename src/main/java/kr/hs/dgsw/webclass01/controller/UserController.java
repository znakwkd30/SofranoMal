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

    @PostMapping("/user/add")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @PutMapping("/user/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/user/view/{id}")
    public User view(@PathVariable Long id) {
        return userService.view(id);
    }

    @GetMapping("/user/list")
    public List<User> list() {
        return userService.list();
    }
}
