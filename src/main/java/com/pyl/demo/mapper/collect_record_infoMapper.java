package com.pyl.demo.mapper;

import com.pyl.demo.model.collect_record_info;

import java.util.List;

public interface collect_record_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(collect_record_info record);

    int insertSelective(collect_record_info record);

    collect_record_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(collect_record_info record);

    int updateByPrimaryKey(collect_record_info record);

    List<collect_record_info> selectAllCollectRecord(String username);

    int getCollectRecordNum(String username);
}