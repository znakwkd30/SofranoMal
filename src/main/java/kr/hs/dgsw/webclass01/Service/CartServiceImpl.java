package kr.hs.dgsw.webclass01.Service;

import java.util.List;

import kr.hs.dgsw.webclass01.Domain.Cart;
import kr.hs.dgsw.webclass01.Domain.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public Long add(Cart cart) {
        return cartMapper.add(cart);
    }

    @Override
    public int deleteById(Long id) {
        return cartMapper.deleteById(id);
    }

    @Override
    public int deleteByUserId(Long userId) {
        return cartMapper.deleteByUserId(userId);
    }

    @Override
    public Cart findById(Long id) {
        return cartMapper.findById(id);
    }

    @Override
    public List<Cart> findByUserId(Long userId) {
      return cartMapper.findByUserId(userId);
    }

    @Override
    public void modify(Cart cart) {
        cartMapper.modify(cart);
    }
}