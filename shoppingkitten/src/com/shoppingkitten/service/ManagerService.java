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
}
