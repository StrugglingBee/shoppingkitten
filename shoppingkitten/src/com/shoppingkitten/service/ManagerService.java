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
    //分页查询管理员
    public ArrayList<Manager> findManagerByLimit(HashMap<String,Integer> map){
        return md.findManagerByLimit(map);
    };
    //查询所有的管理员有多少个
    public int findAllManager(){
        return md.findAllManager();
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
        //删除该账号存在的所有的角色
        int rs = md.delectRoleByManagerID(list.get(0).get("mid"));
        //添加新角色
        return md.insertRoleByManagerID(list);
    };

    //根据账号搜索
    public ArrayList<Manager> findManagerByAccount(String account){
       return md.findManagerByAccount(account);
    };
    //根据昵称搜索
    public ArrayList<Manager> findManagerByNick_name(String nick_name){
        return md.findManagerByNick_name(nick_name);
    };
    //根据电话搜索
    public ArrayList<Manager> findManagerByPhone(String phone){
        return md.findManagerByPhone(phone);
    };
    //根据身份证号搜索
    public ArrayList<Manager> findManagerById_code(String id_code){
        return md.findManagerById_code(id_code);
    };
}
