package kr.hs.dgsw.webclass01.Domain;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubMenuMapper {
    List<SubMenu> findByMenuId(Long menuId);
    SubMenu findById(Long id);
}
