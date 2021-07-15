package com.lihua.feedcontrollerapi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbillentry;

/**
 * JiHT
 * 2021-07-15
 * 分录操作
 */
public interface CtInvBaseinfoentryService extends IService<CtInvBaseinforecordbillentry> {
    /**
     * 插入分录
     * @param ctInvBaseinforecordbillentry 分录
     * @return 1/0
     */
    void insertAll(CtInvBaseinforecordbillentry ctInvBaseinforecordbillentry);
}
