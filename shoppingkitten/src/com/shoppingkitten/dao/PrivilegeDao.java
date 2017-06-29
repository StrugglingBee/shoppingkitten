package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Privilege;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PrivilegeDao {

    //查找所有的权限数据
    ArrayList<Privilege> findAllPrivilege();
    //根据角色ID查找拥有的权限
    ArrayList<Privilege> findPrivilegeByRoleID(int rid);

}
