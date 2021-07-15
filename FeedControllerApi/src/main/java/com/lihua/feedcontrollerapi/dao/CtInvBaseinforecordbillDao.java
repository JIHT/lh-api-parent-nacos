package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.CtInvBaseinforecordbill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CtInvBaseinforecordbillDao extends BaseMapper<CtInvBaseinforecordbill> {
    public void insertAll(CtInvBaseinforecordbill ctInvBaseinforecordbill);
}
