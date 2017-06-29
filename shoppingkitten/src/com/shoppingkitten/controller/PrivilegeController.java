package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Privilege;
import com.shoppingkitten.service.PrivilegeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class PrivilegeController {
    @Resource
    private PrivilegeService ps;//注入资源


    //查找所有的权限数据
    @RequestMapping("findAllPrivilege.do")
    @ResponseBody
    public ArrayList<Privilege> findAllPrivilege(){
        return ps.findAllPrivilege();
    };

    //根据角色ID查找拥有的权限
    @RequestMapping("findPrivilegeByRoleID.do")
    @ResponseBody
    public ArrayList<Privilege> findPrivilegeByRoleID(int rid){
        ArrayList<Privilege> result=null;
        if (rid>0){
            result=ps.findPrivilegeByRoleID(rid);
        }
        return result;
    };
}
