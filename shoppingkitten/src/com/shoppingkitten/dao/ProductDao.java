package com.shoppingkitten.dao;


import com.shoppingkitten.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductDao {
   //根据商品的类别tid查询该类别的所有商品
    ArrayList<Product> findProduct(int tid);
   //添加商品
    int addProduct(Product product);
   //根据商品id查找商品信息
    Product findSingleProduct(int id);
    //根据商品id删除商品信息
    int deleteproduct(int id);
}
