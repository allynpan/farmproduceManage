package com.pyl.demo.mapper;

import com.pyl.demo.model.plant_divide_info;

import java.util.List;

public interface plant_divide_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(plant_divide_info record);

    int insertSelective(plant_divide_info record);

    plant_divide_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(plant_divide_info record);

    int updateByPrimaryKey(plant_divide_info record);

    List<plant_divide_info> selectAllDividePack(String username);

    int getDividePackNum(String username);
}