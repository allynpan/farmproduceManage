package com.pyl.demo.mapper;

import com.pyl.demo.model.plant_info;

import java.util.List;

public interface plant_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(plant_info record);

    int insertSelective(plant_info record);

    plant_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(plant_info record);

    int updateByPrimaryKey(plant_info record);

    //使用username获得只属于该得username的农产品信息
    List<plant_info> selectUserPlant(String username);



}