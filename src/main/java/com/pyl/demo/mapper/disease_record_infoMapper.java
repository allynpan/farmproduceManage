package com.pyl.demo.mapper;

import com.pyl.demo.model.disease_record_info;

import java.util.List;

public interface disease_record_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(disease_record_info record);

    int insertSelective(disease_record_info record);

    disease_record_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(disease_record_info record);

    int updateByPrimaryKey(disease_record_info record);

    List<disease_record_info> selectAllByUser(int user_id);

    int selectDiseaseNum(int user_id);

    int selectIDByName(String name);


}