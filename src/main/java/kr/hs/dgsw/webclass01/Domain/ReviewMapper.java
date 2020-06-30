package kr.hs.dgsw.webclass01.Domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    Long add(Review review);
    int modify(Review review);
    int deleteById(@Param("id") Long id);
    List<Review> findByProductId(@Param("productId") Long productId);
}