package com.pyl.demo.Service.impl;


import com.pyl.demo.Service.UserService;
import com.pyl.demo.mapper.UserMapper;
import com.pyl.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {

        return userMapper.insertSelective(user);
    }


    @Override
    public List<User> findAllUser() {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        return userMapper.selectAllUser();
    }




}
