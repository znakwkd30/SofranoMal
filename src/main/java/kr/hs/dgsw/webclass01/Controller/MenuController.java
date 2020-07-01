package kr.hs.dgsw.webclass01.Controller;

import kr.hs.dgsw.webclass01.Domain.Menu;
import kr.hs.dgsw.webclass01.Service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping(value = "/api/menu")
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @GetMapping(value = "/api/menu/id")
    public Menu findById(@Param("id") Long id) {
        return menuService.findById(id);
    }
}
