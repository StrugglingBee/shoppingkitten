package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public interface ManagerDao {
    //根据管理员查找权限
    ArrayList<Privilege> findPrivilegeByManager(Manager manager);
    //查询所有的管理员有多少个
    int findAllManager();
    //分页查询
    ArrayList<Manager> findManagerByLimit(HashMap<String,Integer> map);


    //添加管理员
    int addManager(Manager manager);
    //批量删除管理员
    int deleteManagers(ArrayList<Integer> mids);
    //修改管理员
    int updateManager(Manager manager);
    //根据账号ID删除拥有的所有角色
    int delectRoleByManagerID(int mid);
    //分配角色，批量存入数据
    int insertRoleByManagerID(ArrayList<HashMap<String, Integer>> list);
    //根据账号搜索
    ArrayList<Manager> findManagerByAccount(String account);
    //根据昵称搜索
    ArrayList<Manager> findManagerByNick_name(String nick_name);
    //根据电话搜索
    ArrayList<Manager> findManagerByPhone(String phone);
    //根据身份证号搜索
    ArrayList<Manager> findManagerById_code(String id_code);
}
