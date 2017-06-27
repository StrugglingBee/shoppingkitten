package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Role;
import com.shoppingkitten.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    //分页查询管理员
    @RequestMapping("role.do")
    @ResponseBody
    public ArrayList<Role> findAllManager(int page, int size){
        ArrayList<Role> roles=null;
        if (page>0&&size>0){
            int start=(page-1)*size;
            int max=size;
            //封装成map
            HashMap<String, Integer> map = new HashMap<>();
            map.put("start",start);
            map.put("max",size);
            //查询数据条数
            int total = rs.findRoleCount();
            //分页查询
            roles=rs.findRoleByLimit(map);
            //把总条数给封装进对象
            roles.get(0).setTotal(total);

        }
        return roles;
    };

    //添加角色
    @RequestMapping("saveOrUpdateRole.do")
    @ResponseBody
    public int addManager(Role role){
        int result=0;
        if (role!=null){
            int rid =role.getRid();
            if (rid==0){
                result= rs.addRole(role);
            }else {
                result=rs.updateRole(role);
            }
        }

        return result;
    };
    //删除管理员
    @RequestMapping("removerole.do")
    @ResponseBody
    public int removeRoles(@RequestBody List<Integer> rid){
        int result=0;
        if(rid!=null){
            //转化成ArrayList
            ArrayList<Integer> rids= (ArrayList<Integer>) rid;
            result=rs.deleteRoles(rids);
        }
        return result;
    }

    //搜索方法
    @RequestMapping("searchRole.do")
    @ResponseBody
    public ArrayList<Role> searchManager(String type, String value){
        ArrayList<Role> result=null;
        if (value!=null&&type!=null){
            //判断按什么字段查找
            switch (type){
                case "name"://按照名称搜索
                    value="%"+value+"%";
                    result=rs.findRoleByName(value);
                    break;
            }
        }
        return result;
    };
}
