package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ManagerDao {
    //根据管理员查找权限
    ArrayList<Privilege> findPrivilegeByManager(Manager manager);
    //查询所有的管理员
    ArrayList<Manager> findAllManager();
    //添加管理员
    int addManager(Manager manager);
    //批量删除管理员
    int deleteManagers(ArrayList<Integer> mids);
    //修改管理员
    int updateManager(Manager manager);

}
