package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Manager;
import com.shoppingkitten.entity.Privilege;
import com.shoppingkitten.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
}
