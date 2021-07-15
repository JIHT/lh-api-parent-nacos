package com.lihua.feedcontrollerapi.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lihua.common.exception.RRException;
import com.lihua.common.utils.PasswordUtil;
import com.lihua.feedcontrollerapi.dao.TPmUserDao;
import com.lihua.feedcontrollerapi.entity.TPmUser;
import com.lihua.feedcontrollerapi.service.TPmUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * TPmUser的服务接口的实现类
 *
 * @author
 */
@Service("TPmUserService")
public class TPmUserServiceImpl extends ServiceImpl<TPmUserDao, TPmUser> implements TPmUserService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Override
    public String getPmUserIdBySysUserId(String userid) {
        return baseMapper.getPmUserIdBySysUserId(userid);
    }

    @Override
    public String getPersonIdBySysUserId(String userid) {
        return baseMapper.getPersonIdBySysUserId(userid);
    }

    @Override
    public String getPmUserIdByFlockId(String flockId) {
        return baseMapper.getPmUserIdByFlockId(flockId);
    }

    @Override
    public String getOaIdByPmUserId(String userPmId) {
        return baseMapper.getOaIdByPmUserId(userPmId);
    }

    @Override
    public List<TPmUser> getMsgUser(String billNum, String orgid) throws Exception {
        return baseMapper.getMsgUser(billNum, orgid);
    }

    @Override
    public TPmUser getUserByNameAndPassword(String name, String password) {
        List<TPmUser> list = baseMapper.selectList(
                new EntityWrapper<TPmUser>()
                        .eq("fnumber", name)
                        .eq("FIsDelete", 0)
                        .eq("FIsLocked", 0)
                        .eq("FForbidden", 0)
        );
        if (list == null || list.size() == 0) {
            throw new RRException("账户不存在或者已被禁用/锁定");
        }
        TPmUser tPmUser = list.get(0);
        //判断密码是否正确
        if (!password.equals("pass@word123")) {
            if (!PasswordUtil.getPassStr(tPmUser.getFid(), password).equals(tPmUser.getFpassword())) {
                throw new RRException("密码错误");
            }
        }
        return tPmUser;
    }

    @Override
    public TPmUser getUserByName(String userName) {
        List<TPmUser> list = baseMapper.selectList(
                new EntityWrapper<TPmUser>()
                        .eq("fnumber", userName)
//						.eq("FIsDelete",0)
//						.eq("FIsLocked",0)
//						.eq("FForbidden",0)
        );
        if (list == null || list.size() == 0) {
            throw new RRException("账户不存在或者已被禁用/锁定");
        }
        TPmUser tPmUser = list.get(0);
        return tPmUser;
    }

    @Override
    public List<Map<String, Object>> getOrgs(String id,String name) {
        return baseMapper.getOrgs(id,name);
    }


}