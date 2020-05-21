package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    User login(String email, String password);
    User update(Long id, User user);
    boolean delete(Long id);
    User view(Long id);
    List<User> list();
}
