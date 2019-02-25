package com.pyl.demo.mapper;

import com.pyl.demo.model.plantation_info;

import java.util.List;

public interface plantation_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(plantation_info record);

    int insertSelective(plantation_info record);

    plantation_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(plantation_info record);

    int updateByPrimaryKey(plantation_info record);

    //下面是没有写mapper的接口
    //获得所有的果园信息
    List<plantation_info> selectAllplantByUser(String username);

}