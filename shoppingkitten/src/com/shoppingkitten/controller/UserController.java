package com.shoppingkitten.controller;

import com.shoppingkitten.entity.User;
import com.shoppingkitten.service.UserService;
import com.shoppingkitten.utils.Encryption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
public class UserController {
    @Resource
    private UserService us;//注入资源

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
        System.out.println(user.getAccount());
        String result = "error";
        //判断接收的数据是否为空
        if (user.getAccount() != "" && user.getPwd() != "" && user.getPhone() != "" && user.getPwd2() != "" && user.getPwd().equals(user.getPwd2())) {
            //对接收到用户的密码进行加密
            String pwd = Encryption.encryptionByMD5(user.getPwd());
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

    //登录
    @RequestMapping("login.do")
    @ResponseBody
    public String login(User u, HttpServletRequest req) {
        String rs = "error";
        if (u != null && u.getAccount() != "" && u.getPwd() != "") {
            //密码加密处理
            u.setPwd(Encryption.encryptionByMD5(u.getPwd()));
            //登录验证
            User user = us.login(u);
            if (user != null) {
                //如果状态正常
                if (user.getStatus().equals("online")) {
                    //登录次数加一
                    user.setLogin_count(user.getLogin_count() + 1);
                    user.setLogin_error(0);
                    //更新登录次数
                    us.updateLogin(user);
                    //如果登录成功就把用户信息存入session中
                    req.getSession().setAttribute("user", user);
                    rs = "success";
                }
//                else if (user.getStatus().equals("lock")){//判断账号是否被冻结
//                    //查询冻结时间
//                    int lock_time = user.getLock_time();
//                    rs=lock_time+"";
//                }else {
//                    if (user.getLogin_error()<3){//如果登录次数小于3次
//                        user.setLogin_error(user.getLogin_error()+1);//设置登录错误次数
//                        us.updateLogin(user);
//                    }else {//如果错误次数超过3次
//                        user.setLogin_error(0);
//                        user.setStatus("lock");
//                        user.setLock_time(24);
//                        us.updateStatus(user);
//                    }
//                }
            }
        }
        return rs;
    }

    //手机验证码方法
    @RequestMapping("createphonecode.do")
    @ResponseBody
    public void createphonecode() {

    }

    //把用户表在后台管理页面显示
    @RequestMapping("findUserByPage.do")
    @ResponseBody
    public ArrayList<User> findUserByPage(int page,int size) {

        ArrayList<User> data=null;
        if (page>0&&size>0) {
            int start = (page - 1) * size;
            int end= size;
//            封装成map
            HashMap<String, Integer> map = new HashMap<>();
            map.put("start", start);
            map.put("end", size);
             data = us.findUserByPage(map);
            //查询数据条数
            int counts = us.findUserCounts();
            data.get(0).setCounts(counts);
//            System.out.println(data.get(0).getCounts());
            return data;

        }
        return data;
    }

    //把页面新添加的用户加入数据库
    @RequestMapping("saveUser.do")
    @ResponseBody
   public int saveUser(User user) {
       System.out.println(user.toString());
       if (user.getId()==0) {
           int rs = us.saveUser(user);
           return rs;
       }else {
           int rs=us.updateUser(user) ;
           return rs;
       }
   }
   //删除用户
    @RequestMapping("removeUser.do")
    @ResponseBody
    public int removeUser(User user){

        us.removeUser(user);
        System.out.println(user.toString());
        return 1;
    }
    @RequestMapping("searchUserByAccount.do")
    @ResponseBody
    public ArrayList<User> searchUserByAccount(@RequestBody String account){
        account=account.replace("=","");
        System.out.println(account);
        return us.searchUserByAccount(account);
    }
 }

