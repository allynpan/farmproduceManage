package com.pyl.demo.mapper;

import com.pyl.demo.model.place_record_info;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

public interface place_record_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(place_record_info record);

    int insertSelective(place_record_info record);

    place_record_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(place_record_info record);

    int updateByPrimaryKey(place_record_info record);

    List<place_record_info> selectAllPlaceRecord(int user_id);

    int selectNumByUser(int user_id);

}