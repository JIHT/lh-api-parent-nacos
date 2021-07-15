package com.lihua.feedcontrollerapi.service;


import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.TProProducebill;
import com.lihua.feedcontrollerapi.vo.TmpBill;

import java.util.List;
import java.util.Map;

/**
 * TProProducebill的服务接口
 *
 * @author
 *
 */
public interface TProProducebillService extends IService<TProProducebill>{

    /**
     * 获取指定日期生产单
     * @param orgId
     * @param dateStr
     * @return
     */
    List<Map<String,Object>> listBillsByDate(String orgId, String dateStr);

    void overBillsByDate(TmpBill tmpBill);

    void startBillsByDate(String billId);
}
