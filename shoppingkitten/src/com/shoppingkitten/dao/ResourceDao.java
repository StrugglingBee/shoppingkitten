package com.shoppingkitten.dao;

import com.shoppingkitten.entity.Resource2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ResourceDao {
    //根据权限ID查找资源
    ArrayList<Resource2> findResourceByprivilege(int pid);
    //根据父节点查找子节点资源
    ArrayList<Resource2> findResourceByPid(int parent_id);
    //查询所有的资源
    ArrayList<Resource2> findAllResource();
    //根据角色ID查找拥有的权限
    ArrayList<Resource2> findResourceByRoleID(int rid);
}
