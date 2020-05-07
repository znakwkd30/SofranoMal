package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(String id);
    boolean add(User user);
    User update(User user);
    boolean delete(String id);
}
