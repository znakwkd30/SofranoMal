package kr.hs.dgsw.webclass01.Service;

import kr.hs.dgsw.webclass01.Domain.Review;

import java.util.List;

public interface ReviewService {
    Long add(Review review);
    int deleteById(Long id);
    int modify(Review review);
    List<Review> findByProductId(Long productId);
}