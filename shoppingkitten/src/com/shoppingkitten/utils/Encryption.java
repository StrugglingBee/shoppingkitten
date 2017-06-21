package com.shoppingkitten.utils;

import java.security.MessageDigest;

public class Encryption {
    public static String encryptionByMD5(String msg) {
        //创建可变字符串
        StringBuilder sb = new StringBuilder();
        try {
            //获取md5算法对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //更新数据
            md5.update(msg.getBytes());
            //加密
            byte[] bytes = md5.digest();
            for (int i = 0; i < bytes.length; i++) {
                int x = (int) bytes[i] & 0xff;
                int y = x + 5;//干预--加盐
                if (y<16){
                    sb.append("0");
                }
                sb.append(Integer.toHexString(y));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static String encryptionBySHA1(String msg){
        StringBuilder sb = new StringBuilder();
        try {
            //获取md5算法对象
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            //更新数据
            sha1.update(msg.getBytes());
            //加密
            byte[] bytes = sha1.digest();
            for (int i = 0; i < bytes.length; i++) {
                int x = (int) bytes[i] & 0xff;
                int y = x + 5;//干预--加盐
                if (y<16){
                    sb.append("0");
                }
                sb.append(Integer.toHexString(y));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
