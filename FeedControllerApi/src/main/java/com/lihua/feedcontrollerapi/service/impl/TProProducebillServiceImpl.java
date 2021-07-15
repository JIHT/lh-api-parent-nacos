package com.lihua.feedcontrollerapi.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lihua.feedcontrollerapi.service.TProProducebillentryService;
import com.lihua.feedcontrollerapi.vo.TmpBill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lihua.feedcontrollerapi.service.TProProducebillService;
import com.lihua.feedcontrollerapi.dao.TProProducebillDao;
import com.lihua.feedcontrollerapi.entity.TProProducebill;

/**
 * TProProducebill的服务接口的实现类
 *
 * @author
 */
@Service("TProProducebillService")
public class TProProducebillServiceImpl extends ServiceImpl<TProProducebillDao, TProProducebill> implements TProProducebillService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Autowired
    private TProProducebillentryService tProProducebillentryService;

    @Override
    public List<Map<String, Object>> listBillsByDate(String orgId, String dateStr) {
        List<Map<String, Object>> list = baseMapper.listBillsByDate(orgId, dateStr);
        for (Map<String, Object> map : list) {
            String id = map.get("billId").toString();
            List<Map<String, Object>> entries = tProProducebillentryService.getEntriesByBillId(id);
            map.put("entries", entries);
        }
        return list;
    }

    @Override
    public void overBillsByDate(TmpBill tmpBill) {
        TProProducebill tProProducebill = baseMapper.selectById(tmpBill.getBillIId());
        //状态改成3= 生产完成
        tProProducebill.setCfstatus("3");
        updateById(tProProducebill);
        tProProducebillentryService.over(tmpBill);
    }

    @Override
    public void startBillsByDate(String billId) {
        TProProducebill tProProducebill = baseMapper.selectById(billId);
        //状态改成2=生产中，不允许调整
        tProProducebill.setCfstatus("2");
        updateById(tProProducebill);
    }
}