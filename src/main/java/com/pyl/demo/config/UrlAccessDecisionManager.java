package com.pyl.demo.config;

import com.pyl.demo.Controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

    private final static Logger logger = LoggerFactory.getLogger(UrlAccessDecisionManager.class);

    /**
     * 通过传递的参数来决定用户是否有访问对应受保护对象的权限
     *
     * @param authentication 当前正在请求受包含对象的Authentication
     * @param object 受保护对象，其可以是一个MethodInvocation、JoinPoint或FilterInvocation。
     * @param configAttributes 与正在请求的受保护对象相关联的配置属性
     *
     */
    @Override
    public void decide(Authentication auth, Object o, Collection<ConfigAttribute> cas) throws AccessDeniedException{

        logger.info("--------------进入权限验证函数--------------");
        Iterator<ConfigAttribute> iterator = cas.iterator();
        while(iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            String needRole = ca.getAttribute();
            logger.info("该次url需要的角色：" + needRole);
            //特别处理没有任何权限的情况
            if ("ROLE_LOGIN".equals(needRole)) {
                if (auth instanceof AnonymousAuthenticationToken) {
                    logger.warn("该账号未曾登录！");
                    throw new BadCredentialsException("未登录");
                } else
                    return;
            }
            SecurityContext securityContext = SecurityContextHolder.getContext();
            logger.info("输出证书："+securityContext.getAuthentication().getAuthorities());
            logger.info(SecurityContextHolder.getContext().getAuthentication().toString());
            //检测当前用户具有的权限
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            logger.info("获取对应的证书：" + authorities.toString());
            for (GrantedAuthority authority : authorities) {
                //判断是否有当前的权限，有权限则返回
                logger.info("auth name:"+auth.getName());
                logger.info("auth principal:"+auth.getPrincipal());
                logger.info("auth datails:"+auth.getDetails());
                logger.info("auth credentials:"+auth.getCredentials());
                logger.info("auth authorities:"+auth.getAuthorities());
                logger.info("当前需要的权限是：" + authority.getAuthority() + "     url需要的角色是：" + needRole);
                if (authority.getAuthority().equals(needRole)||needRole.trim().equals("ROLE_ANONYMOUS")) {
                    logger.info("拥有权限，准许使用该功能！");
                    return;
                }
            }

        }
        logger.info("权限不足！");
        throw new AccessDeniedException("权限不足!");
    }

    /**
     * 表示当前AccessDecisionManager是否支持对应的ConfigAttribute
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * 表示当前AccessDecisionManager是否支持对应的受保护对象类型
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


}
