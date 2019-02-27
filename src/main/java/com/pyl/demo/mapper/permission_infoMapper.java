package com.pyl.demo.mapper;

import com.pyl.demo.model.permission_info;

import java.util.List;

public interface permission_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(permission_info record);

    int insertSelective(permission_info record);

    permission_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(permission_info record);

    int updateByPrimaryKey(permission_info record);

    List<permission_info> getAllPemission();

    List<permission_info> getMenuByPerId(Long perId);

}