package com.shoppingkitten.service;

import com.shoppingkitten.dao.ResourceDao;
import com.shoppingkitten.entity.Resource2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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


    // 查询所有的节点，并进行组合封装
    public List<Resource2> findResourceByRoleID(int rid) {
        //获取用户拥有的所有资源
        List<Resource2> role_resources = rd.findResourceByRoleID(rid);
        //获取所有的资源
        List<Resource2> resources = rd.findAllResource();
        //定义返回结果
        List<Resource2> data = new ArrayList<Resource2>();

        for (Resource2 a : resources) {
            for (Resource2 b : role_resources) {
                //如果是用户拥有的资源，改变checked属性为true
                if(b.getResource_id()==a.getResource_id()){
                    a.setChecked(true);
                    a.setBiaoji(1);
                    break;
                }
            }
            //如果是跟节点，添加到新集合中
            if (a.getParent_id() == 0) {
                data.add(a);
            }
            //封装子节点
            for (Resource2 c : resources) {
                if (a.getResource_id() == c.getParent_id()) {
                    a.getChildren().add(c);
                }
            }

        }
        return data;
    }
}
