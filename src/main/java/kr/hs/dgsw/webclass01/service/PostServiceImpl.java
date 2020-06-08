package kr.hs.dgsw.webclass01.service;

import kr.hs.dgsw.webclass01.entity.Post;
import kr.hs.dgsw.webclass01.entity.User;
import kr.hs.dgsw.webclass01.repository.PostRepository;
import kr.hs.dgsw.webclass01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service // spring web service
public class PostServiceImpl implements PostService {
    @Autowired // bean 자동 주입
    private PostRepository postRepository;
    @Autowired // bean 자동 주입
    private UserRepository userRepository;

    // 포스트 생성
    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    // 포스트 1개 읽기
    @Override
    public Post read(Long id) {
        return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
    }

    // 유저 포스트 읽기
    @Override
    public Post readByUserId(Long userId) {
        return postRepository
                .findTopByUserIdOrderByIdDesc(userId)
                .orElse(null);
    }

    // 포스트 업데이트
    @Override
    public Post update(Long id, Post post) {
        return postRepository.findById(id)
                .map(found -> {
                    found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
                    found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
                    found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
                    return postRepository.save(found);
                })
                .orElse(null);
    }


    // 포스트 삭제
    @Override
    public boolean delete(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    // 전체 포스트 읽기
    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }
}
