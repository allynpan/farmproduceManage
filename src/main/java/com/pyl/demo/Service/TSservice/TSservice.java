package com.pyl.demo.Service.TSservice;

import com.pyl.demo.model.TECHB_info;

import java.util.List;

public interface TSservice {

    //返回所有的信息
    public List<TECHB_info> selectAll();

    //get id by its personnal name
    public int getIDbyname(String plantName);

    //get info by its personnal id
    public TECHB_info selectByPrimaryKey(int id);

}
