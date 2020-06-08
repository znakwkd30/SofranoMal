package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.User;
import kr.hs.dgsw.webclass01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // spring web service
public class UserServiceImpl implements UserService{
    @Autowired // bean 자동 주입
    private UserRepository userRepository;

    // 유저 생성
    @Override
    public User create(User user) {
        Optional<User> found = userRepository.findByAccount(user.getAccount());
        if(found.isPresent()) return null;
        return userRepository.save(user);
    }


    // 유저 업데이트
    // optional 체크후 null이면 이전 값 넣음.
    @Override
    public User update(Long id, User user) {
        return userRepository.findById(id)
                .map(found -> {
                    found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                    found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
                    return userRepository.save(found);
                })
                .orElse(null);
    }

    // 유저 삭제
    @Override
    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 유저 전체 읽기
    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    // id에 해당하는 유저 읽기
    @Override
    public User read(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }
}
