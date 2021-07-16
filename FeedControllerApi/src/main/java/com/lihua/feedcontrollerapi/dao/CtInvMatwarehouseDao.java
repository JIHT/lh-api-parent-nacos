package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.CtInvMatwarehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CtInvMatwarehouseDao extends BaseMapper<CtInvMatwarehouse> {
    void updateWarestatusById(@Param("id") String id,@Param("status") String status);
}
