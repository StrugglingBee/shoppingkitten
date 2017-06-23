package com.shoppingkitten.service;

import com.shoppingkitten.dao.ResourceDao;
import com.shoppingkitten.entity.Resource2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class ResourceService {
    @Resource
    private ResourceDao rd;//注入资源

    //根据权限ID查找根节点资源
    public ArrayList<Resource2> findResourceByprivilege(int pid){
        return rd.findResourceByprivilege(pid);
    }
    //根据父节点查找子节点资源
    public ArrayList<Resource2> findResourceByPid(int parent_id){
        return rd.findResourceByPid(parent_id);
    }
}
