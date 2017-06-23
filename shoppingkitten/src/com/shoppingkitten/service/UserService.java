package com.shoppingkitten.service;


import com.shoppingkitten.dao.UserDao;
import com.shoppingkitten.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserService {
    @Resource
    private UserDao ud;//注入资源

    //注册用户
    public int createUser(User user){
        return ud.createUser(user);
    }
    //登录
    public User login(User user){
        return ud.login(user);
    }
    //更新账号状态
    public int updateStatus(User user){
        return ud.updateStatus(user);
    }
    //更新登录次数
    public int updateLogin(User user){
        return ud.updateLogin(user);
    }


}
