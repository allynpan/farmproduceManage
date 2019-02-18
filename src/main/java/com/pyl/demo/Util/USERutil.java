package com.pyl.demo.Util;

import com.pyl.demo.model.USER_info;
import org.springframework.security.core.context.SecurityContextHolder;

public class USERutil {
    public static USER_info getCurrentUser(){
        //获取当前用户
        return  (USER_info)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
