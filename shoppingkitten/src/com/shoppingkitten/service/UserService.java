package com.shoppingkitten.service;


import com.shoppingkitten.dao.UserDao;
import com.shoppingkitten.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserService {
    @Resource
    private UserDao ud;
    public int createUser(User user){
        int rs = ud.createUser(user);
        return rs;
    }
}
