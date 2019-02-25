package com.pyl.demo.mapper;

import com.pyl.demo.model.TECHB_info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TECHB_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TECHB_info record);

    int insertSelective(TECHB_info record);

    TECHB_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TECHB_info record);

    int updateByPrimaryKey(TECHB_info record);

    List<TECHB_info> selectAll();

    Integer selectIDByname(@Param("plantName") String plantName);

}