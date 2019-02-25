package com.pyl.demo.mapper;

import com.pyl.demo.model.shave_record_info;

import java.util.List;

public interface shave_record_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(shave_record_info record);

    int insertSelective(shave_record_info record);

    shave_record_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(shave_record_info record);

    int updateByPrimaryKey(shave_record_info record);

    List<shave_record_info> selectAllByUser(int user_id);

    int selectShaveRecordNum(int user_id);
}