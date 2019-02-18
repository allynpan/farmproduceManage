package com.pyl.demo.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyl.demo.Service.UserService.UserService;
import com.pyl.demo.Service.UserService.impl.UserServiceimpl;
import com.pyl.demo.Util.MD5Util;
import com.pyl.demo.Util.RespBean;
import com.pyl.demo.Util.ResultUtil;
import com.pyl.demo.Util.USERutil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//ROLE_ANONYMOUS 匿名用户


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    UserServiceimpl userServiceimpl;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;
    @Autowired
    CustomMetadataSource metadataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userServiceimpl).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence){
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }


    @Override
    public void configure(WebSecurity web) throws Exception{
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/index.html","/static/**","/login_p","login**","/favicon.ico","/druid/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                            }
                    })
                .and()
                .formLogin()
                .loginPage("/login_p")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                            logger.info("--------请求失败处理--------");
                            logger.info(httpServletRequest.getQueryString());
                            resp.setContentType("application/json;charset=utf-8");
                            RespBean respBean = null;
                            if (e instanceof BadCredentialsException ||
                                    e instanceof UsernameNotFoundException) {
                                logger.info("账号或者密码输入错误！");
                                respBean = RespBean.error("账户名或者密码输入错误!");
                            } else if (e instanceof LockedException) {
                                respBean = RespBean.error("账户被锁定，请联系管理员!");
                            } else if (e instanceof CredentialsExpiredException) {
                                respBean = RespBean.error("密码过期，请联系管理员!");
                            } else if (e instanceof AccountExpiredException) {
                            respBean = RespBean.error("账户过期，请联系管理员!");
                        } else if (e instanceof DisabledException) {
                            respBean = RespBean.error("账户被禁用，请联系管理员!");
                        } else {
                            respBean = RespBean.error("登录失败!");
                        }
                        resp.setStatus(401);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                            httpServletResponse.setContentType("application/json;charset=utf-8");
                            PrintWriter out = httpServletResponse.getWriter();
                            ObjectMapper objectMapper = new ObjectMapper();
                            String s = "{\"status\":\"success\",\"msg\":" + objectMapper.writeValueAsString(USERutil.getCurrentUser()) + "}";
                            logger.info("-------请求成功--------");
                            logger.info(s);
                            out.write(s);
                            out.flush();
                            out.close();
                    }
                })
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
}
}
