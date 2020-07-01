package kr.hs.dgsw.webclass01.Controller;

import kr.hs.dgsw.webclass01.Domain.Product;
import kr.hs.dgsw.webclass01.Service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value="/api/product")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value="/api/product/id")
    public Product findById(@Param("id") Long id) {
        return productService.findById(id);
    }

    @GetMapping(value="/api/product/menuId")
    public List<Product> findByMenuId(@Param("menuId") Long menuId) {
        return productService.findByMenuId(menuId);
    }
}
