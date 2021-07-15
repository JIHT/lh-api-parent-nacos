package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.TProProducebill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * TProProducebill的Dao接口
 *
 * @author
 *
 */
 @Mapper
public interface TProProducebillDao extends BaseMapper<TProProducebill>{

    List<Map<String, Object>> listBillsByDate(@Param("orgId") String orgId, @Param("dateStr") String dateStr);
}