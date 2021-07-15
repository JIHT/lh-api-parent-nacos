package com.lihua.common.utils;

public class ToolUtils {
    /**
     * 生产UUID
     */
    public static String getUUID() {
        // 32位的,去掉中划线
        String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
