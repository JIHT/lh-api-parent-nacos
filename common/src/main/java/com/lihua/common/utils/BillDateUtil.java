package com.lihua.common.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 单据中日期工具
 */
public class BillDateUtil {

    /**
     * 获取单据日期（默认今天）
     * @return
     */
    public static Date getBizDate(){
           return DateUtils.stringToDate(DateUtil.now().substring(0, 10), "yyyy-MM-dd");
    }
}
