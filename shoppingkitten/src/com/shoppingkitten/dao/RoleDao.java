package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoleDao {
    //查询所有的角色
    ArrayList<Role> findAllRole();
    //根据账号ID查找拥有的所有角色
    ArrayList<Role> findRoleByManagerID(int mid);
}
