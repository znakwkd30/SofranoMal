package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    // userlist 객체 생성
    List<User> userList;

    // default 유저 추가
    public UserServiceImpl() {
        // ArrayList 할당
        userList = new ArrayList<>();
        // 유저추가
        userList.add(new User("user1", "ㄱ", "ㄱ@dgsw.hs.kr"));
        // 유저추가
        userList.add(new User("user2", "ㄴ", "ㄴ@dgsw.hs.kr"));
        // 유저추가
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
        // userList에서 인자값으로 받아온 id를 찾고 없으면 null return 찾으면 해당 유저 return
        User user = userList.stream()
                            .filter(found -> found.getId().equals(id))
                            .findAny()
                            .orElse(null);
        return user;
    }

    // 유저 추가
    @Override
    public boolean add(User user) {
        // 유저아이디로 해당 유저 데이터 가져오기
        User found = view(user.getId());
        // found가 널이면 return false, 아니면 return true
        if (found == null)
            return userList.add(user);
        return false;
    }

    // 유저 업데이트
    @Override
    public User update(User user) {
        // 유저아이디로 해당 유저 데이터 가져오기
        User found = view(user.getId());
        // found가 null이면 그냥 return, null이 아니면 받아온 값을 기존 값과 바꾸고 return
        if(found != null) {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    // 유저 삭제
    @Override
    public boolean delete(String id) {
        // 유저 아이디로 해당 유저 데이터 가져오기
        User found = view(id);
        // userList에서 found 유저를 찾아 삭제후 return
        return userList.remove(found);
    }
}
