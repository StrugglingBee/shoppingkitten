package com.shoppingkitten.service;


import com.shoppingkitten.dao.UserDao;
import com.shoppingkitten.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

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

    //分页查询
    public ArrayList<User> findUserByPage(HashMap<String, Integer> map){

        return  ud.findUserByPage(map);
    }
    //查询所有数据条数
    public int findUserCounts(){

        return  ud.findUserCounts();
    }
    //把新加入的用户加入数据库
    public int  saveUser(User user){
        System.out.println(user.toString()+2);
       int rs= ud.saveUser(user);
       return rs;
    }
//    删除用户
    public int removeUser(User user){

        ud.removeUser(user);
        System.out.println(user.toString());
        return 1;
    }
    //更新用户
    public int updateUser(User user){
       int rs= ud.updateUser(user);
       return rs;
    }
}
