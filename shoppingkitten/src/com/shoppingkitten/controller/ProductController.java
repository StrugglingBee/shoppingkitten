package com.shoppingkitten.controller;

import com.shoppingkitten.entity.Product;
import com.shoppingkitten.service.ProductService;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class ProductController {
    @Resource
    private ProductService ps;
    //点击分类根据tid查找商品
    @RequestMapping("findProduct.do")
    @ResponseBody
    public ArrayList<Product> findProduct(int tid){
        return ps.findProduct(tid);

    }
    //添加商品
    @RequestMapping("addProduct.do")
    @ResponseBody
    public int addProduct(HttpServletRequest request,Product product) throws Exception {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        ServletContext servletContext = request.getServletContext();
        String imgPath= request.getRealPath("/upload");
        Map<String, String> temp = new HashMap<>();
        product=new Product();
        try {
       List<FileItem> datas=upload.parseRequest(request);
            for (FileItem item : datas) {
                //判断得到内容的类型
                if(item.isFormField()){
                    //获得输入框的name
                    String key = item.getFieldName();
                    //获得输入框的内容
                    String value1 = item.getString();
                    //转换成utf-8编码
                    String value2 = new String(value1.getBytes("iso-8859-1"), "utf-8");
                    //System.out.println(key+"----"+value2);
                    //输入框名-输入框内容形成键值对,存入map集合
                    temp.put(key, value2);
                }else {
                    //获取输入框name
                    String key = item.getFieldName();
                    //获得上传的图片名称
                    String name = item.getName();
                    //获得图片的完整路径
                    String newpath = imgPath+"/"+name;
                    //存入map
                    temp.put(key, name);
                    item.write(new File(newpath));
//                    System.out.println("file-----" + newpath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setName(temp.get("product_name"));
        product.setSale_price( Float.parseFloat(temp.get("productsale_price")));
        product.setPrice(Float.parseFloat(temp.get("product_price")));
        product.setStock(Integer.parseInt(temp.get("product_stock")));
        product.setTid(Integer.parseInt(temp.get("producted_type")));
        product.setDescripe(temp.get("product_descripe"));
        product.setFace_image(temp.get("product_face"));
        return  ps.addProduct(product);
    }
    //根据商品id查找商品信息
    @RequestMapping("findSingleProduct.do")
    @ResponseBody
    public Product findSingleProduct(int id){
        return ps.findSingleProduct(id);
    }
    //根据商品id删除商品信息
    @RequestMapping("deleteproduct.do")
    @ResponseBody
    public int deleteproduct(int id){
    return ps.deleteproduct(id);
    }
}
