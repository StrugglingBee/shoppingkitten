package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Product_type;
import com.shoppingkitten.service.PtypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class PtypeController {
    @Resource
    private PtypeService psc;//注入资源
    //查找所有分类
    @RequestMapping("findTypes.do")
    @ResponseBody
    public ArrayList<Product_type> findTypes(){
        return psc.findTypes();
    }
    @RequestMapping("deletePtype.do")
    @ResponseBody
    public int deletePtype(int id){
        return psc.deletePtype(id);
    }
    //添加分类
    @RequestMapping("addType.do")
    @ResponseBody
    public int addType(Product_type pt){
        return psc.addType(pt);
    }
    //修改分类
    @RequestMapping("editType.do")
    @ResponseBody
    public int editType(Product_type pt){
        return  psc.editType(pt);
    }
    //查找所有分类木有组建父子关系
    @RequestMapping("findTypes2.do")
    @ResponseBody
    public ArrayList<Product_type> findTypes2(){
        return psc.findTypes2();
    }
}
