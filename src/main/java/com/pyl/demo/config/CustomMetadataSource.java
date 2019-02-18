package com.pyl.demo.config;


import com.pyl.demo.Controller.UserController;
import com.pyl.demo.Service.PM_Service.PM_Service;
import com.pyl.demo.model.permission_info;
import com.pyl.demo.model.role;
import org.apache.ibatis.javassist.bytecode.Descriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final static Logger logger = LoggerFactory.getLogger(CustomMetadataSource.class);

    @Autowired
    PM_Service pm_service;

    AntPathMatcher antPathMatcher = new AntPathMatcher();


    /**
     * 这个类的方法只是为了对应url的属性，这个类没有问题
     * @param o
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {
        logger.info("---------进入CustomMetadataSource----------");
            String requestUrl = ((FilterInvocation) o).getRequestUrl();
            logger.info("请求的url："+requestUrl);
            List<permission_info> allPermiss = pm_service.getAllPemission();

        for(permission_info pemiss:allPermiss){
                logger.warn("角色数目:"+pemiss.getRoles().size());
                logger.info("数据库中的url："+pemiss.getUrl());
                if(antPathMatcher.match(pemiss.getUrl(),requestUrl)&&pemiss.getRoles().size()>0){
                    List<role> roles = pemiss.getRoles();
                    int size = roles.size();
                    String[] values = new String[size];
                    for(int i=0;i<size;i++){
                        values[i] = roles.get(i).getName();
                        logger.info("对应的准许访问该url的角色："+values[i]);
                }

                return SecurityConfig.createList(values);
            }
        }
        logger.info("该权限的角色是：ROLE_LOGIN");
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
