package com.shoppingkitten.controller;

import com.shoppingkitten.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("login.do")
    @ResponseBody
    public String login(User user){
        //获取安全验证主体
        Subject subject = SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken token=new UsernamePasswordToken(user.getAccount(),user.getPwd());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return "login";
        }

        return "success";
    }
}
