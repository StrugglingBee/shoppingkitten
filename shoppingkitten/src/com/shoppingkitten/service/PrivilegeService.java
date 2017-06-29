package com.shoppingkitten.service;


import com.shoppingkitten.dao.PrivilegeDao;
import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class PrivilegeService {
    @Resource
    private PrivilegeDao pd;//注入资源

    //查找所有的权限数据
    public ArrayList<Privilege> findAllPrivilege(){
        return pd.findAllPrivilege();
    };

    //根据角色ID查找拥有的权限
    public ArrayList<Privilege> findPrivilegeByRoleID(int rid){
        return  pd.findPrivilegeByRoleID(rid);
    };
}
