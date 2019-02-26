package com.pyl.demo.Controller;

import com.pyl.demo.Service.UserService.impl.UserServiceImpl;
import com.pyl.demo.Util.RespBean;
import com.pyl.demo.Util.Result;
import com.pyl.demo.Util.ResultUtil;
import com.pyl.demo.model.USER_info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("User/")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/register",produces = {"application/json;charset=UTF-8"})
    public Result register(String username,String password,String email,String nickname,String address,
        String phone){
        return ResultUtil.success();
    }

    @ResponseBody
    @RequestMapping(value = "/getPer_info", produces = {"application/json;charset=UTF-8"})
    //返回对应的用户信息
    public RespBean getPer_info(String username){
        USER_info user_info = (USER_info) userService.loadUserByUsername(username);
        return RespBean.ok("个人用户信息加载成功！",user_info);
    }

    @ResponseBody
    @RequestMapping(value = "/updatePer_info",produces = {"application/json;charset=UTF-8"})
    //修改用户个人信息
    public RespBean modifiedPer_info(String username,String nickname,String address,String email,String phone){
        return RespBean.ok(userService.update(username,nickname,address,email,phone));
    }



}
