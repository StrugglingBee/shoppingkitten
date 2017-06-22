package com.shoppingkitten.dao;

import com.shoppingkitten.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //创建用户
    int createUser(User user);
}
