package com.shoppingkitten.dao;

import com.shoppingkitten.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

//创建用户
    @Repository
    public interface UserDao {

        int createUser(User user);
    //登录
    User login(User user);
    //更新登录次数
    int updateLogin(User user);
    //更新账号状态
    int updateStatus(User user);
    //根据管理员账号判断拥有的权限

    //分页查询
    ArrayList<User> findUserByPage(HashMap<String, Integer> map);
    //查询数据条数
    int findUserCounts();
    //保存页面新建的用户
    int saveUser(User user);
//    删除用户
    int removeUser(User user
    );
    //更新用户
    int updateUser(User user);
}
