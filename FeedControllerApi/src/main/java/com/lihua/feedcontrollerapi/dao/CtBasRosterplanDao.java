package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.CtBasRosterplan;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CtBasRosterplanDao extends BaseMapper<CtBasRosterplan> {
    @MapKey("id")
    List<Map<String, Object>> listByDateAndOrgId(@Param("companyId") String companyId, @Param("dateStr") String dateStr);

    @MapKey("id")
    CtBasRosterplan selectById(@Param("id") String id);
}
