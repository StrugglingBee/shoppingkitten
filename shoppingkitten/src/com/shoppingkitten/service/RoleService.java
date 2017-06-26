package com.shoppingkitten.service;

import com.shoppingkitten.dao.RoleDao;
import com.shoppingkitten.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class RoleService {
    @Resource
    private RoleDao rd;//注入资源
    //查询所有的角色
    public ArrayList<Role> findAllRole(){
        return rd.findAllRole();
    };

}
