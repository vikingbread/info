package com.info.utils;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 *用户密码加密工具 
 *
 */
public class MD5Util {
	
    public static String getMD5(String str){
    
        String md5Str = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
		    md5Str=base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
       
        return md5Str;
    }


}
