package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User read(Long id);
    User update(Long id, User user);
    boolean delete(Long id);
    List<User> readAll();
}
