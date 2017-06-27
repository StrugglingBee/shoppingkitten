package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public interface RoleDao {
    //查询所有的角色
    ArrayList<Role> findAllRole();
    //根据账号ID查找拥有的所有角色
    ArrayList<Role> findRoleByManagerID(int mid);

    //查询所有的管理员有多少个
    int findRoleCount();
    //分页查询
    ArrayList<Role> findRoleByLimit(HashMap<String,Integer> map);

    //添加角色
    int addRole(Role role);
    //修改角色
    int updateRole(Role role);
    //批量删除角色
    int deleteRoles(ArrayList<Integer> rids);
    //根据名称搜索角色
    ArrayList<Role> findRoleByName(String name);
}
