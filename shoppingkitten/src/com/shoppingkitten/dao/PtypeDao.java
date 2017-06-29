package com.shoppingkitten.dao;


import com.shoppingkitten.entity.Product_type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PtypeDao {
    //查找所有的商品分类
    ArrayList<Product_type> findTypes();
   //根据id删除分类
    int deletePtype(int id);
   //添加分类
    int addType(Product_type pt);
    //修改分类
    int editType(Product_type pt);
    //查找所有的商品分类2
    ArrayList<Product_type> findTypes2();
}
