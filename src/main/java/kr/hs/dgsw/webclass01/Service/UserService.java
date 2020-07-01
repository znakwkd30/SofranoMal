package kr.hs.dgsw.webclass01.Service;

import kr.hs.dgsw.webclass01.Domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByAccount(String account);
    int deleteById(Long id);
    Long add(User user);
    int modify(User user);
    User login(User user);
}