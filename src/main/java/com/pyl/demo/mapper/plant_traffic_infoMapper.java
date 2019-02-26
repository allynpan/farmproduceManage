package com.pyl.demo.mapper;

import com.pyl.demo.model.plant_traffic_info;

import java.util.List;

public interface plant_traffic_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(plant_traffic_info record);

    int insertSelective(plant_traffic_info record);

    plant_traffic_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(plant_traffic_info record);

    int updateByPrimaryKey(plant_traffic_info record);

    List<plant_traffic_info> selectAllTraf(String username);

    int getTrafficNum(String username);
}