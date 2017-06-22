package com.shoppingkitten.controller;

import com.shoppingkitten.entity.User;
import com.shoppingkitten.service.UserService;
import com.shoppingkitten.utils.Encryption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class UserController {
    @Resource
    private UserService us;//注入服务资源

    //产生简单的验证码
    @RequestMapping("createCheckCode.do")
    @ResponseBody
    public String checkCode(HttpServletRequest req) {
        System.out.println("请求能送到");
        //产生随机数对象
        Random ran = new Random();
        //变量因子
        int x = ran.nextInt(9);//产生1-9的随机数
        int y = ran.nextInt(9);
        //产生验证码公式
        String checkCode = x + "+" + y + "=?";
        //获取session对象
        HttpSession session = req.getSession();
        //把验证码的值存入session中
        session.setAttribute("checkCode", x + y);
        //返回验证码公式
        return checkCode;
    }

    //注册账号
    @RequestMapping("createUser.do")
    @ResponseBody
    public String createUser(User user, HttpServletRequest req) {
        String result = "error";
        //判断接收的数据是否为空
        if (user.getAccount() != ""&&user.getPwd()!=""&&user.getPhone()!="") {
            //对接收到用户的密码进行加密
            String pwd= Encryption.encryptionByMD5(user.getPwd());
            user.setPwd(pwd);
            //获取注册这的IP地址
            String ip = req.getRemoteAddr();
            //获取时间
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date1 = format.format(date);
            //设置创建时间
            user.setCreate_time(date1);
            //设置注册的者的ip
            user.setCreate_ip(ip);
            //存储数据
            int rs = us.createUser(user);
            //判断是否存入成功！
            if (rs > 0) {
                result = "success";
            }
        }
        return result;
    }
}
