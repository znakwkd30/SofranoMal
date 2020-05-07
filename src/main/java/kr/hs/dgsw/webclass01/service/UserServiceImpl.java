package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    List<User> userList;

    // default 유저 추가
    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("user1", "ㄱ", "ㄱ@dgsw.hs.kr"));
        userList.add(new User("user2", "ㄴ", "ㄴ@dgsw.hs.kr"));
        userList.add(new User("user3", "ㄷ", "ㄷ@dgsw.hs.kr"));
    }

    // 유저리스트 반환
    @Override
    public List<User> list() {
        return userList;
    }

    // 유저 아이디에 해당하는 유저 리턴
    @Override
    public User view(String id) {
        User user = userList.stream()
                            .filter(found -> found.getId().equals(id))
                            .findAny()
                            .orElse(null);
        return user;
    }

    // 유저 추가
    @Override
    public boolean add(User user) {
        User found = view(user.getId());
        if (found == null)
            return userList.add(user);
        return false;
    }

    // 유저 업데이트
    @Override
    public User update(User user) {
        User found = view(user.getId());
        if(found != null) {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    // 유저 삭제
    @Override
    public boolean delete(String id) {
        User found = view(id);
        return userList.remove(found);
    }
}
