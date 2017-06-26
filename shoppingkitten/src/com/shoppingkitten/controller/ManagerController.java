package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import com.shoppingkitten.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ManagerController {
    @Resource
    private ManagerService ms;
    //管理员登录验证
    @RequestMapping("mangerlogin.do")
    @ResponseBody
    public String managerLogin(Manager m, HttpServletRequest req){
        HttpSession session = req.getSession();
        String rs="error";
        if(m!=null&&m.getAccount()!=""&&m.getPwd()!=""){
            //获取安全验证主体
            Subject subject = SecurityUtils.getSubject();
            //获取令牌
            UsernamePasswordToken token=new UsernamePasswordToken(m.getAccount(),m.getPwd());
            try {
                //登录验证
                subject.login(token);
                //获取管理员拥有的所有的权限
                ArrayList<Privilege> privileges = ms.findPrivilegeByManager(m);

                //把权限数组存入session中
                session.setAttribute("privileges",privileges);
                rs="success";
            } catch (AuthenticationException e) {
                rs="error";
            }
        }
        return rs;
    }

    //查询所有的管理员
    @RequestMapping("manager.do")
    @ResponseBody
    public ArrayList<Manager> findAllManager(int page,int size){
        ArrayList<Manager> managers=null;
        if (page>0&&size>0){
            int start=(page-1)*size;
            int max=size;
            //封装成map
            HashMap<String, Integer> map = new HashMap<>();
            map.put("start",start);
            map.put("max",size);
            //分页查询
            managers=ms.findAllManager(map);
        }
        return managers;
    };

    //添加管理员
    @RequestMapping("saveOrUpdateManager.do")
    @ResponseBody
    public int addManager(Manager manager){
        int rs=0;
        int mid = manager.getMid();
        if (mid==0){
            rs= ms.addManager(manager);
        }else {
            rs=ms.updateManager(manager);
        }
        return rs;
    };

    //删除管理员
    @RequestMapping("removemanager.do")
    @ResponseBody
    public int removeUsers(@RequestBody List<Integer> mid){
        int rs=0;
        if(mid!=null){
            //转化成ArrayList
            ArrayList<Integer> mids= (ArrayList<Integer>) mid;
            rs=ms.deleteManagers(mids);
        }
        return rs;
    }

    //分配角色
    @RequestMapping("insertRoleByManagerID.do")
    @ResponseBody
    public int insertRoleByManagerID(@RequestBody ArrayList<HashMap<String, Integer>> maps){
        int rs=0;
        if(maps!=null){
            rs=ms.insertRoleByManagerID(maps);
        }
        return rs;
    }
}
