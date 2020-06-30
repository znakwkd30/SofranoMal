package kr.hs.dgsw.webclass01.Domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    Long add(Product product);
    int modify(Product product);
    int deleteById(@Param("id") Long id);
    Product findById(@Param("id") Long id);
    List<Product> findByMenuId(@Param("menuid") Long menuid);
    List<Product> findBySubMenuId(@Param("submenuid") Long submenuid);
    List<Product> findAll();
}