package com.lihua.feedcontrollerapi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.CtInvMatwarehouseentry;

import java.util.List;
import java.util.Map;

/**
 * JiHT 2021-07-16
 * 成品料入库记录
 */
public interface CtInvMatwarehouseentryService extends IService<CtInvMatwarehouseentry> {

    //确认信息
    List<Map<String,Object>> selectByParam(String wareHouseId, String shChanLine, String materialId, String materialNum);

    //入库
    Integer insertEntry(String wareHouseId, String shChanLine, String aiCount, String materialId, String actualQty);
}
