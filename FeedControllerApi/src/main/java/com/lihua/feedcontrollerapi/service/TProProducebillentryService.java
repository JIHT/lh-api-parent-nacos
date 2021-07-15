package com.lihua.feedcontrollerapi.service;


import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.TProProducebillentry;
import com.lihua.feedcontrollerapi.vo.TmpBill;

import java.util.List;
import java.util.Map;

/**
 * TProProducebillentry的服务接口
 *
 * @author
 *
 */
public interface TProProducebillentryService extends IService<TProProducebillentry>{

    List<Map<String, Object>> getEntriesByBillId(String parentId);

    void over(TmpBill tmpBill);
}
