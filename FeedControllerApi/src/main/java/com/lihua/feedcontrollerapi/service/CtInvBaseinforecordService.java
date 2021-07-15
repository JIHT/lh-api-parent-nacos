package com.lihua.feedcontrollerapi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbill;

import java.text.ParseException;

/**
 * 2021-07-14
 * @Author JiHT
 * 新建中间表
 */
public interface CtInvBaseinforecordService extends IService<CtInvBaseinforecordbill> {
    /**
     * 新建表
     * @param id 计划单Id
     * @param dateStr 日期
     * @param period  班次
     * @param shChanLine 生产线
     */
    String insertBill(String id, String dateStr, String period, String shChanLine) throws ParseException;
}
