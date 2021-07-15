package com.lihua.feedcontrollerapi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lihua.feedcontrollerapi.entity.TPmUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * TPmUser的Dao接口
 * 
 * @author 
 *
 */
@Mapper
public interface TPmUserDao extends BaseMapper<TPmUser>{

    String getPmUserIdBySysUserId(@Param("userid") String userid);

    String getPersonIdBySysUserId(@Param("userid") String userid);

    String getPmUserIdByFlockId(@Param("flockId") String flockId);

    String getOaIdByPmUserId(@Param("userPmId") String userPmId);

    //根据消息接收人员设置编码获取人员
    public List<TPmUser> getMsgUser(@Param("billNum")String billNum, @Param("orgid")String orgid)throws Exception;

    List<Map<String, Object>> getOrgs(@Param("userPmId") String userPmId,@Param("name")String name);
}