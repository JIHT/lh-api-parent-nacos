package com.lihua.feedcontrollerapi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lihua.common.utils.ToolUtils;
import com.lihua.feedcontrollerapi.dao.CtInvBaseinforecordbillDao;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbill;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbillentry;
import com.lihua.feedcontrollerapi.service.CtInvBaseinfoentryService;
import com.lihua.feedcontrollerapi.service.CtInvBaseinforecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("CtInvBaseinforecordService")
public class CtInvBaseinforecordServiceImpl extends ServiceImpl<CtInvBaseinforecordbillDao, CtInvBaseinforecordbill> implements CtInvBaseinforecordService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Autowired
    private CtInvBaseinfoentryService ctInvBaseinfoentryService;

    @Override
    public String insertBill(String id, String dateStr, String period, String shChanLine) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date bizDate = simpleDateFormat.parse(dateStr);
        String fid = ToolUtils.getUUID();
        CtInvBaseinforecordbill ctInvBaseinforecordbill = new CtInvBaseinforecordbill();
        ctInvBaseinforecordbill.setCfproductionplanid(id);
        ctInvBaseinforecordbill.setFbizdate(bizDate);
        ctInvBaseinforecordbill.setFid(fid);
        baseMapper.insertAll(ctInvBaseinforecordbill);
        CtInvBaseinforecordbillentry ctInvBaseinforecordbillentry = new CtInvBaseinforecordbillentry();
        ctInvBaseinforecordbillentry.setFparentid(fid);
        ctInvBaseinforecordbillentry.setFid(ToolUtils.getUUID());
        ctInvBaseinforecordbillentry.setCfperiod(period);
        ctInvBaseinforecordbillentry.setCfshchanline(shChanLine);
        ctInvBaseinforecordbillentry.setCfstatus(0);
        ctInvBaseinfoentryService.insertAll(ctInvBaseinforecordbillentry);
        return fid;
    }
}
