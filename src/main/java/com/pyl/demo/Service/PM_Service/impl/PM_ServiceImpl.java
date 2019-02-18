package com.pyl.demo.Service.PM_Service.impl;


import com.pyl.demo.Service.PM_Service.PM_Service;
import com.pyl.demo.mapper.permission_infoMapper;
import com.pyl.demo.model.permission_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PM_Service")
public class PM_ServiceImpl implements PM_Service {


    @Autowired
    private permission_infoMapper permissionInfoMapper;

    public List<permission_info> getAllPemission(){
        return permissionInfoMapper.getAllPemission();
    }



}
