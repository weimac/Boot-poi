package com.wk.mapper;

import com.wk.po.Weiuser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WeiuserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Weiuser record);

    int insertSelective(Weiuser record);

    Weiuser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Weiuser record);

    int updateByPrimaryKey(Weiuser record);

    @Select("select * from weiuser")
    List<Weiuser> selectAll();
}