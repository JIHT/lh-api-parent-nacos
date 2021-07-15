package com.lihua.feedcontrollerapi.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lihua.common.utils.ToolUtils;
import com.lihua.feedcontrollerapi.dao.CtInvMatwarehouseDao;
import com.lihua.feedcontrollerapi.entity.CtBasRosterplan;
import com.lihua.feedcontrollerapi.entity.CtInvMatwarehouse;
import com.lihua.feedcontrollerapi.service.CtBasRosterplanService;
import com.lihua.feedcontrollerapi.service.CtInvMatwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("CtInvMatwarehouseService")
public class CtInvMatwarehouseServiceImpl extends ServiceImpl<CtInvMatwarehouseDao, CtInvMatwarehouse> implements CtInvMatwarehouseService {
    @Autowired
    private CtBasRosterplanService ctBasRosterplanService;

    @Override
    public String insertAll(String id, String dateStr,String materialId) throws ParseException {
        CtInvMatwarehouse ctInvMatwarehouse = new CtInvMatwarehouse();
        String fid = ToolUtils.getUUID();
        ctInvMatwarehouse.setFid(fid);
        CtBasRosterplan ctBasRosterplan = ctBasRosterplanService.selectById(id);
        String orgId = ctBasRosterplan.getCforgid();
        ctInvMatwarehouse.setCforgunitid(orgId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date bizDate = simpleDateFormat.parse(dateStr);
        ctInvMatwarehouse.setFbizdate(bizDate);
        ctInvMatwarehouse.setCfmaterialid(materialId);
        ctInvMatwarehouse.setCfplansheet(id);
        ctInvMatwarehouse.setCfplanqty(ctBasRosterplan.getCfquantity());
        ctInvMatwarehouse.setCfspecification(ctBasRosterplan.getCfweight());
        ctInvMatwarehouse.setCfwarestatus("0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String batch = sdf.format(bizDate);
        ctInvMatwarehouse.setCfbatch(batch);
        baseMapper.insert(ctInvMatwarehouse);
        return fid;
    }
}
