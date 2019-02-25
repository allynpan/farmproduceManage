package com.pyl.demo.mapper;

import com.pyl.demo.model.plant_place_info;

import java.util.List;

public interface plant_place_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(plant_place_info record);

    int insertSelective(plant_place_info record);

    plant_place_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(plant_place_info record);

    int updateByPrimaryKey(plant_place_info record);

    List<plant_place_info> selectChoosePlant(int user_id);

    int selectNumByUserId(int user_id);

}