package com.shoppingkitten.service;

import com.shoppingkitten.dao.ManagerDao;
import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class ManagerService {
    @Resource
    private ManagerDao md;

    //根据管理员查找权限
    public ArrayList<Privilege> findPrivilegeByManager(Manager manager){
        return md.findPrivilegeByManager(manager);
    }
    //查询所有管理员
    public ArrayList<Manager> findAllManager(){
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
}
