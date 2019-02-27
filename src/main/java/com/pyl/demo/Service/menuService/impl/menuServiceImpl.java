package com.pyl.demo.Service.menuService.impl;

import com.pyl.demo.Service.menuService.menuService;
import com.pyl.demo.Util.USERutil;
import com.pyl.demo.mapper.permission_infoMapper;
import com.pyl.demo.model.permission_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class menuServiceImpl implements menuService {

    @Autowired
    private permission_infoMapper permission_infoMapper;

    public List<permission_info> getMenuByPerId(){
        return permission_infoMapper.getMenuByPerId(USERutil.getCurrentUser().getId().longValue());
    }
}
