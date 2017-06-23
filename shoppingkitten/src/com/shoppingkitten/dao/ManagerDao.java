package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ManagerDao {
    //根据管理员查找权限
    ArrayList<Privilege> findPrivilegeByManager(Manager manager);
}
