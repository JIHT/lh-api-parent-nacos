package com.lihua.feedcontrollerapi.service;


import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.TPmUser;

import java.util.List;
import java.util.Map;

/**
 * TPmUser的服务接口
 * 
 * @author 
 *
 */
public interface TPmUserService extends IService<TPmUser>{

    /**
     * 根据SystemUserId 转化TPMuserId
     * @param userid
     * @return
     */
    String getPmUserIdBySysUserId(String userid);

    String getPersonIdBySysUserId(String userid);

    /**
     * 根据鸡群ID查询对应片管Id
     * @param flockId
     * @return
     */
    String getPmUserIdByFlockId(String flockId);

    /**
     * 根据PMid获取OaId
     * @param userPmId
     * @return
     */
    String getOaIdByPmUserId(String userPmId);

    /**
     * 根据编码和组织ID查询推送用户EASID
     * @param billNum
     * @param orgid
     * @return
     * @throws Exception
     */
    public List<TPmUser> getMsgUser(String billNum,String orgid) throws  Exception;

    /**
     * 根据用户名密码查找用户/判断用户名密码是否错误
     * @param name
     * @param password
     * @return
     */
    TPmUser getUserByNameAndPassword(String name, String password);

    TPmUser getUserByName(String userName);

    List<Map<String, Object>> getOrgs(String id,String name);
}
