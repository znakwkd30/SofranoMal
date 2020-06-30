package kr.hs.dgsw.webclass01.Service;

import java.util.List;

import kr.hs.dgsw.webclass01.Domain.Menu;
import kr.hs.dgsw.webclass01.Domain.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuMapper.findById(id);
    }
    
}