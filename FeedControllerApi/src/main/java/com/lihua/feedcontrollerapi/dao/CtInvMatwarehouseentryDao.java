package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.CtInvMatwarehouseentry;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CtInvMatwarehouseentryDao extends BaseMapper<CtInvMatwarehouseentry> {
    @MapKey("aiCount")
    List<Map<String, Object>> selectByNumAndWare(@Param("wareHouseId") String wareHouseId,
                                                 @Param("shChanLine") String shChanLine);

    Integer insertEntry(@Param("fid") String fid,
                        @Param("wareHouseId") String wareHouseId,
                        @Param("shChanLine") String shChanLine,
                        @Param("aiCount") String aiCount,
                        @Param("materialId") String materialId,
                        @Param("actualQty") String actualQty);
}
