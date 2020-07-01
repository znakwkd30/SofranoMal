package kr.hs.dgsw.webclass01.Service;

import kr.hs.dgsw.webclass01.Domain.SubMenu;

import java.util.List;

public interface SubMenuService {
    List<SubMenu> findByMenuId(Long menuId);
    SubMenu findById(Long id);
}