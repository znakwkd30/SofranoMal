package kr.hs.dgsw.webclass01.Domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> findall();
    Menu findById(Long id);
}
