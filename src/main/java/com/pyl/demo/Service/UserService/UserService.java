package com.pyl.demo.Service.UserService;

import com.pyl.demo.mapper.USER_infoMapper;
import com.pyl.demo.model.USER_info;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    //select对应的用户名和密码
    public String selectUsernameAndPassword(String username,String pwd);

    //根据用户名搜索对应，判断该用户是否注册
    public boolean findUsers(String username);

    public int getID(String username);


}
