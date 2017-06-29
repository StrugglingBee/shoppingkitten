package com.shoppingkitten.service;

import com.shoppingkitten.dao.ProductDao;
import com.shoppingkitten.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class ProductService {
    @Resource
    private ProductDao pd;
    //根据商品的类别tid查询该类别的所有商品
    public ArrayList<Product> findProduct(int tid){
        return pd.findProduct(tid);
    }
    //添加商品
    public int addProduct(Product product){
        return pd.addProduct(product);
    }
   //根据商品id查找商品信息
    public Product findSingleProduct(int id){
        return pd.findSingleProduct(id);
    }
    //根据商品id删除商品信息
    public int deleteproduct(int id){
        return pd.deleteproduct(id);
    }
}
