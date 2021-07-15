package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.TOrgStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * TOrgStorage的Dao接口
 *
 * @author
 *
 */
 @Mapper
public interface TOrgStorageDao extends BaseMapper<TOrgStorage>{

 List<Map<String, Object>> listDeps(@Param("name") String name);
}