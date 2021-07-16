package com.lihua.feedcontrollerapi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.CtInvMatwarehouse;

import java.text.ParseException;

/**
 * JiHT 2021-07-15
 * 成品料入库单
 */
public interface CtInvMatwarehouseService extends IService<CtInvMatwarehouse> {
    /**
     * 新建成品料表头
     * @param id 排班计划id
     * @param dateStr 日期
     * @param materialId 物料Id
     * @return 结果
     */
    String insertAll(String id, String dateStr, String materialId) throws ParseException;

    /**
     * 修改单据状态
     * @param status 状态
     */
    void updateStatus(String id, String status);
}
