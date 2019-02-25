package com.pyl.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pyl.demo.config.AuthenticationAccessDeniedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class USER_info implements UserDetails {

    private final static Logger logger = LoggerFactory.getLogger(USER_info.class);

    private Integer id;

    private String username;

    private String pwd;

    private String email;

    private String nickname;

    private String address;

    private String phone;

    private String img_path;

    private List<role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword(){
        return pwd;
    }

    //账户是否过期,过期无法验证
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    //指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    //指示是否已过期的用户的凭据(密码),过期的凭据防止认证
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    //是否被禁用,禁用的用户不能身份验证
    @Override
    public boolean isEnabled(){
        return true;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        logger.info("------调用user model中的调用证书------");
        logger.info("此次获得的证书:"+authorities.toString());
        return authorities;
    }

    public List<role> getRoles() {
        return roles;
    }

    public void setRoles(List<role> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

}