package com.shoppingkitten.service;

import com.shoppingkitten.dao.PtypeDao;
import com.shoppingkitten.entity.Product_type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class PtypeService {
   @Resource
    private PtypeDao pd;//注入资源
    //查找所有的商品分类,组装父子关系
    public ArrayList<Product_type> findTypes(){
        ArrayList<Product_type> ts=pd.findTypes();
        ArrayList<Product_type> data=new ArrayList<>();
        for (Product_type a: ts){
            if (a.getPid()==0){
                data.add(a);
            }
            for (Product_type b: ts){
                if (a.getId()==b.getPid()){
                    a.getChildren().add(b);
                }
            }
        }
        return  data;
    }
    //删除分类
    public int deletePtype(int id){
        return  pd.deletePtype(id);
    }
    //添加分类
    public int addType(Product_type pt){
        return  pd.addType(pt);
    }
    //修改
    public int editType(Product_type pt){
        return  pd.editType(pt);
    }
    //找所有的商品分类
    public ArrayList<Product_type> findTypes2(){
        System.out.println("hah");
         return pd.findTypes2();
    }
}
