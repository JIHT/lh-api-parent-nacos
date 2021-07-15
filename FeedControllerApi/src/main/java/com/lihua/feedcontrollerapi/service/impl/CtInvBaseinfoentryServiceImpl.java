package com.lihua.feedcontrollerapi.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lihua.feedcontrollerapi.dao.CtInvBaseinfoentryDao;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbillentry;
import com.lihua.feedcontrollerapi.service.CtInvBaseinfoentryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service("CtInvBaseinfoentryService")
public class CtInvBaseinfoentryServiceImpl extends ServiceImpl<CtInvBaseinfoentryDao,CtInvBaseinforecordbillentry> implements CtInvBaseinfoentryService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Override
    public void insertAll(CtInvBaseinforecordbillentry ctInvBaseinforecordbillentry) {
        baseMapper.insertAll(ctInvBaseinforecordbillentry);
    }
}
