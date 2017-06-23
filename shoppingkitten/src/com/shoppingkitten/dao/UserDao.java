package com.shoppingkitten.dao;

import com.shoppingkitten.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //创建用户
    int createUser(User user);
    //登录
    User login(User user);
    //更新登录次数
    int updateLogin(User user);
    //更新账号状态
    int updateStatus(User user);
    //根据管理员账号判断拥有的权限

}
