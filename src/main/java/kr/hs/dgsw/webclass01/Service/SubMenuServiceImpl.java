package kr.hs.dgsw.webclass01.Service;

import java.util.List;

import kr.hs.dgsw.webclass01.Domain.SubMenu;
import kr.hs.dgsw.webclass01.Domain.SubMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubMenuServiceImpl implements SubMenuService {
    @Autowired
    SubMenuMapper subMenuMapper;

    @Override
    public List<SubMenu> findByMenuId(Long menuId) {
        return subMenuMapper.findByMenuId(menuId);
    }

    @Override
    public SubMenu findById(Long id) {
        return subMenuMapper.findById(id);
    }


}