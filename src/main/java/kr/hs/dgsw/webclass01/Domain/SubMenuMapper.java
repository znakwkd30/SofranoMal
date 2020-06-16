package kr.hs.dgsw.webclass01.Domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubMenuMapper {
    List<SubMenu> findByMenuId(Long menuId);
    SubMenu findById(Long id);
}
