package com.pyl.demo.mapper;

import com.pyl.demo.model.disease_record_info;
import com.pyl.demo.model.preserve_record_info;

import java.util.List;

public interface preserve_record_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(preserve_record_info record);

    int insertSelective(preserve_record_info record);

    preserve_record_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(preserve_record_info record);

    int updateByPrimaryKey(preserve_record_info record);

    List<preserve_record_info> selectAllByUser(int user_id);

    int selectPreserveNum(int user_id);

}