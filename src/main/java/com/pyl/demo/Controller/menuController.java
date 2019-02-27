package com.pyl.demo.Controller;

import com.pyl.demo.Service.menuService.menuService;
import com.pyl.demo.Util.RespBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class menuController {

    private final static Logger logger = LoggerFactory.getLogger(menuController.class);

    @Autowired
    private menuService menuService;

    @ResponseBody
    @RequestMapping(value = "/getMenuByPerId", produces = {"application/json;charset=UTF-8"})
    public RespBean getMenuByPerId(){
        logger.info("menuService:"+menuService.getMenuByPerId());
        return RespBean.ok("获取成功",menuService.getMenuByPerId());
    }

}
