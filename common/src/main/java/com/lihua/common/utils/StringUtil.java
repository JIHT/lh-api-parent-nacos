package com.lihua.common.utils;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {
    /*
     * 方法三：最简单的方法就是利用Set集合无序不可重复的特性进行元素过滤。
     */
    public static Object[] stringsFilter(Object[] arr){
        //实例化一个set集合
        Set set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        //返回Set集合的数组形式
        return set.toArray();
    }
}
