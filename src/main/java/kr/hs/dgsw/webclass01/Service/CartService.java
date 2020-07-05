package kr.hs.dgsw.webclass01.Service;

import kr.hs.dgsw.webclass01.Domain.Cart;

import java.util.List;

public interface CartService {
    Long add(Cart cart);
    int deleteById(Long id);
    int deleteByUserId(Long userId);
    Cart findById(Long userId, Long productId);
    List<Cart> findByUserId(Long userId);
    void modify(Cart cart);
}