package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbillentry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CtInvBaseinfoentryDao extends BaseMapper<CtInvBaseinforecordbillentry> {
    void insertAll(CtInvBaseinforecordbillentry ctInvBaseinforecordbillentry);
}
