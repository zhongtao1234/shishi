package com.accp.dao;

import com.accp.domain.Customaddress;
import com.accp.domain.CustomaddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomaddressMapper {
    int countByExample(CustomaddressExample example);

    int deleteByExample(CustomaddressExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(Customaddress record);

    int insertSelective(Customaddress record);

    List<Customaddress> selectByExample(CustomaddressExample example);

    Customaddress selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") Customaddress record, @Param("example") CustomaddressExample example);

    int updateByExample(@Param("record") Customaddress record, @Param("example") CustomaddressExample example);

    int updateByPrimaryKeySelective(Customaddress record);

    int updateByPrimaryKey(Customaddress record);
}