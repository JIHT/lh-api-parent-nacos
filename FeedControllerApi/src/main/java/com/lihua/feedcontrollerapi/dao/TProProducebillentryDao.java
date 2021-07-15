package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.TProProducebillentry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * TProProducebillentry的Dao接口
 *
 * @author
 *
 */
 @Mapper
public interface TProProducebillentryDao extends BaseMapper<TProProducebillentry>{

    List<Map<String, Object>> getEntriesByBillId(@Param("parentId") String parentId);
}