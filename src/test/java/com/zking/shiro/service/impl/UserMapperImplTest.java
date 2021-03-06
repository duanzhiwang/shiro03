package com.zking.shiro.service.impl;

import com.zking.shiro.model.User;
import com.zking.shiro.service.IUserService;
import com.zking.shiro.utils.PasswordHelper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserMapperImplTest extends BaseTestCase{
   private User user;
   @Autowired
   private IUserService userService;
    @Before
    public void setUp() throws Exception {
        user=new User();
    }

    @Test
    public void register() {
        user.setUsername("lisi");
//        创建盐
        String salt = PasswordHelper.createSalt();
//        保存盐
        user.setSalt(salt);
//        创建密码
        String pwd = PasswordHelper.createCredentials("123", salt);
        user.setPassword(pwd);
        userService.register(user);
    }

    @Test
    public void login() {
        user.setUsername("admin");
        user.setPassword("123");
        User login = userService.login(user);
        String salt = login.getSalt();
        boolean b = PasswordHelper.checkCredentials(user.getPassword(), salt, login.getPassword());
        if(b){
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }
    }
}