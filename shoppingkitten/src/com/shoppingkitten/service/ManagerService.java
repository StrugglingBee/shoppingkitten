package com.shoppingkitten.service;

import com.shoppingkitten.dao.ManagerDao;
import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ManagerService {
    @Resource
    private ManagerDao md;

    //根据管理员查找权限
    public ArrayList<Privilege> findPrivilegeByManager(Manager manager){
        return md.findPrivilegeByManager(manager);
    }
    //查询所有管理员
    public ArrayList<Manager> findAllManager(HashMap<String,Integer> map){
        return md.findAllManager(map);
    };
    //添加管理员
    public int addManager(Manager manager){
        return md.addManager(manager);
    };

    //批量删除管理员
    public int deleteManagers(ArrayList<Integer> mids){
        return md.deleteManagers(mids);
    };
    //修改管理员
    public int updateManager(Manager manager){
        return md.updateManager(manager);
    };

    //根据账号ID删除拥有的所有角色
    public int delectRoleByManagerID(int mid){
        return md.delectRoleByManagerID(mid);
    };
    //分配角色，批量存入数据
    public int insertRoleByManagerID(ArrayList<HashMap<String, Integer>> list){
        int rs = md.delectRoleByManagerID(list.get(0).get("mid"));
        return md.insertRoleByManagerID(list);
    };
}
