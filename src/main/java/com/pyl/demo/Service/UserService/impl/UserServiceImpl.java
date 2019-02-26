package com.pyl.demo.Service.UserService.impl;

import com.pyl.demo.mapper.USER_infoMapper;
import com.pyl.demo.model.USER_info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserDetailsService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private USER_infoMapper USER_INFO_MAPPER;

    //select对应的用户名和密码,用户登录
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        USER_info user_info = USER_INFO_MAPPER.loadUserByUsername(username);
        logger.info("取出的username:"+user_info.getUsername()+"取出的password:"+user_info.getPassword());
        if(user_info==null){
            throw new UsernameNotFoundException("用户名不对");
        }
        return user_info;
    }

    //根据用户名搜索对应，判断该用户是否注册

    public boolean findUsers(String username){
        if(USER_INFO_MAPPER.loadUserByUsername(username)==null){
            return false;
        }else{
            return true;
        }
    }

    //更新数据
    public String update(String username,String nickname,String address,String email,String phone){
        USER_info user_info = (USER_info) this.loadUserByUsername(username);
        int i = USER_INFO_MAPPER.updateByPrimaryKey(user_info);
        if(i>0){
            return "ok";
        }else{
            return "fail";
        }
    }

    public int getID(String username){
        return USER_INFO_MAPPER.selectIDByUsername(username);
    }

}
