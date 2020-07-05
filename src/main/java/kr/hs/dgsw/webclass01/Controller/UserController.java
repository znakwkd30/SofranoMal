package kr.hs.dgsw.webclass01.Controller;

import kr.hs.dgsw.webclass01.Domain.User;
import kr.hs.dgsw.webclass01.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/user/id")
    public User findById(@Param("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/api/user/account/{account}")
    public User findByAccount(@PathVariable("account") String account) {
        return userService.findByAccount(account);
    }

    @GetMapping("/api/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/api/user")
    public Long add(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping("/api/user")
    public int modify(@RequestBody User user) {
        return userService.modify(user);
    }

    @DeleteMapping("/api/user/id")
    public int deleteById(@Param("id") Long id) {
        return userService.deleteById(id);
    }

    @PostMapping("/api/user/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }
}