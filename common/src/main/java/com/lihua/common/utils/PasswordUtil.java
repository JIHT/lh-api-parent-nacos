package com.lihua.common.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class PasswordUtil {
    /**
     * 根据UserId和Pass获取加密后的PassWord
     * @param userID
     * @param userPass
     * @return
     */
    public static String getPassStr(String userID,String userPass){
        String str = "";
        String strEncode = userID + userPass;
        byte[] btKey = new byte[strEncode.getBytes().length + 1];
        System.arraycopy(strEncode.getBytes(), 0, btKey, 0, strEncode.getBytes().length);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(btKey);
            byte[] btDigest = md.digest();
            BASE64Encoder encoder = new BASE64Encoder();
            str = encoder.encode(btDigest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
