package com.pyl.demo.Service.TSservice.impl;

import com.pyl.demo.Service.TSservice.TSservice;
import com.pyl.demo.mapper.TECHB_infoMapper;
import com.pyl.demo.model.TECHB_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("TSservice")
public class TSserviceImpl implements TSservice {


    @Autowired
    private TECHB_infoMapper techserv_before_infoMapper;

    public List<TECHB_info> selectAll(){
        return techserv_before_infoMapper.selectAll();
    }


    public int getIDbyname(String plantName){
        Integer result=techserv_before_infoMapper.selectIDByname(plantName);
        return techserv_before_infoMapper.selectIDByname(plantName);
    }

    public TECHB_info selectByPrimaryKey(int id){
        return techserv_before_infoMapper.selectByPrimaryKey(id);
    }

}
