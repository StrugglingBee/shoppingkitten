package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Resource2;
import com.shoppingkitten.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ResourceController {
    @Resource
    private ResourceService rs;//注入资源
    //根据权限ID查找根节点资源

    @RequestMapping("findResourceByPrivilege.do")
    @ResponseBody
    public List<Resource2> findResourceByprivilege(int pid){
        ArrayList<Resource2> resources = rs.findResourceByprivilege(pid);
        return resources;
    }
    //根据父节点ID查找子节点资源
    @RequestMapping("findResourceByPid.do")
    @ResponseBody
    public ArrayList<Resource2> findResourceByPid(int parent_id){
        return rs.findResourceByPid(parent_id);
    }
}
