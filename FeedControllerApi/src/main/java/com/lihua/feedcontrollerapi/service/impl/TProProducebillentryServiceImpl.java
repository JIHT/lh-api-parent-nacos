package com.lihua.feedcontrollerapi.service.impl;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lihua.feedcontrollerapi.vo.TmpBill;
import com.lihua.feedcontrollerapi.vo.TmpBillEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.lihua.feedcontrollerapi.service.TProProducebillentryService;
import com.lihua.feedcontrollerapi.dao.TProProducebillentryDao;
import com.lihua.feedcontrollerapi.entity.TProProducebillentry;
/**
 * TProProducebillentry的服务接口的实现类
 *
 * @author
 *
 */
@Service("TProProducebillentryService")
public class TProProducebillentryServiceImpl extends ServiceImpl<TProProducebillentryDao, TProProducebillentry> implements TProProducebillentryService {
	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Override
	public List<Map<String, Object>> getEntriesByBillId(String parentId) {
		return baseMapper.getEntriesByBillId(parentId);
	}

	@Override
	public void over(TmpBill tmpBill) {
		List<TmpBillEntry> list =tmpBill.getEntries();
		for(TmpBillEntry tmpBillEntry:list){
			TProProducebillentry tProProducebillentry = baseMapper.selectById(tmpBillEntry.getId());
			if(tProProducebillentry == null){
				continue;
			}
			BigDecimal finQty = tProProducebillentry.getFfinishqty()==null?new BigDecimal("0"):tProProducebillentry.getFfinishqty();
			BigDecimal bigQty = tmpBillEntry.getQty() == null ? new BigDecimal("0") : tmpBillEntry.getQty();
			tProProducebillentry.setFfinishqty(bigQty.add(finQty));
			baseMapper.updateById(tProProducebillentry);
		}
	}
}