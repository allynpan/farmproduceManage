package com.pyl.demo.Controller;


import com.pyl.demo.Service.TSservice.TSservice;
import com.pyl.demo.Util.RespBean;
import com.pyl.demo.model.TECHB_info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("TSB")

//产前技术服务响应
public class TSBController {

    private final static Logger logger = LoggerFactory.getLogger(TSBController.class);

    @Autowired
    private TSservice tSservice;

    @ResponseBody
    @RequestMapping(value = "/getAllplants",produces = {"application/json;charset=UTF-8"})
    //返回数据库中存在的农产品名
    public RespBean getAllplants(){
        List<TECHB_info> Allname = tSservice.selectAll();
        Iterator<TECHB_info> it = Allname.iterator();
        List<String> array = new ArrayList<>();
        while (it.hasNext()){
            array.add(it.next().getPlantName());
        }
        return RespBean.ok("ok",array);
    }

    @ResponseBody
    @RequestMapping(value = "/getTSB_info",produces = {"application/json;charset=UTF-8"})
    //返回所有的产前技术服务信息,通过对应的农产品名
    public RespBean getTSB_info(String plantName){
        logger.info("plantName:"+plantName);
        int id = tSservice.getIDbyname(plantName);
        TECHB_info techserv_before_info = tSservice.selectByPrimaryKey(id);
        logger.info(techserv_before_info.toString());
        return RespBean.ok("ok",techserv_before_info);
    }




}
