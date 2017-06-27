package com.shoppingkitten.service;

import com.shoppingkitten.dao.RoleDao;
import com.shoppingkitten.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class RoleService {
    @Resource
    private RoleDao rd;//注入资源
    //查询所有的角色
    public ArrayList<Role> findAllRole(){
        return rd.findAllRole();
    };

    //根据账号ID查找拥有的所有角色
    public ArrayList<Role> findRoleByManagerID(int mid){
       return rd.findRoleByManagerID(mid);
    };

    //查询所有的管理员有多少个
    public int findRoleCount(){
        return rd.findRoleCount();
    };
    //分页查询
    public ArrayList<Role> findRoleByLimit(HashMap<String,Integer> map){
        return rd.findRoleByLimit(map);
    };

    //添加角色
    public int addRole(Role role){
        return rd.addRole(role);
    };

    //修改角色
    public int updateRole(Role role){
        return rd.updateRole(role);
    };
    //批量删除角色
    public int deleteRoles(ArrayList<Integer> rids){
        return rd.deleteRoles(rids);
    };

    //根据名称搜索角色
    public ArrayList<Role> findRoleByName(String name){
        return rd.findRoleByName(name);
    };
}
