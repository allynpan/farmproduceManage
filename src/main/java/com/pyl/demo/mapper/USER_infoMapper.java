package com.pyl.demo.mapper;

import com.pyl.demo.model.USER_info;
import com.pyl.demo.model.role;

import java.util.List;

public interface USER_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(USER_info record);

    int insertSelective(USER_info record);

    USER_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(USER_info record);

    int updateByPrimaryKey(USER_info record);

    USER_info selectByUserNameAndPassword(String username,String pwd);

    List<role> getRolesByUSERId(Long id);

    USER_info loadUserByUsername(String username);

    int selectIDByUsername(String username);

}