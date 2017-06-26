package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Role;
import com.shoppingkitten.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class RoleController {
    @Resource
    private RoleService rs;//注入资源

    //查找所有的角色
    @RequestMapping("findAllRole.do")
    @ResponseBody
    public ArrayList<Role> findAllRole(){
        return rs.findAllRole();
    };

    //根据账号ID查找拥有的所有角色
    @RequestMapping("findRoleByManagerID.do")
    @ResponseBody
    public ArrayList<Role> findRoleByManagerID(int mid){
        return rs.findRoleByManagerID(mid);
    };
}
