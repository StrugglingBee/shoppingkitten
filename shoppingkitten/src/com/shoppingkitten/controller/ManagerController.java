package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Manager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManagerController {

    //管理员登录验证
    @RequestMapping("mangerlogin.do")
    @ResponseBody
    public String managerLogin(Manager m){
        String rs="error";
        if(m!=null&&m.getAccount()!=""&&m.getPwd()!=""){
            //获取安全验证主体
            Subject subject = SecurityUtils.getSubject();
            //获取令牌
            UsernamePasswordToken token=new UsernamePasswordToken(m.getAccount(),m.getPwd());
            try {
                //登录验证
                subject.login(token);
                rs="success";
            } catch (AuthenticationException e) {
                rs="error";
            }
        }
        return rs;
    }
}
