package com.lihua.feedcontrollerapi.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lihua.feedcontrollerapi.dao.CtBasRosterplanDao;
import com.lihua.feedcontrollerapi.entity.CtBasRosterplan;
import com.lihua.feedcontrollerapi.service.CtBasRosterplanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CtBasRosterplanService")
public class CtBasRosterplanServiceImpl extends ServiceImpl<CtBasRosterplanDao, CtBasRosterplan> implements CtBasRosterplanService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Override
    public List<Map<String, Object>> listByDateAndOrgId(String companyId, String dateStr) {
        return baseMapper.listByDateAndOrgId(companyId,dateStr);
    }

    @Override
    public CtBasRosterplan selectById(String id) {
        return baseMapper.selectById(id);
    }

}

