package kr.hs.dgsw.webclass01.Service;

import kr.hs.dgsw.webclass01.Domain.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findAll();
    Menu findById(Long id);
}