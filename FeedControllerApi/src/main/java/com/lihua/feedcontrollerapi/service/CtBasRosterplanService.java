package com.lihua.feedcontrollerapi.service;

import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.CtBasRosterplan;

import java.util.List;
import java.util.Map;

/**
 * 2021-07-14
 * @Author JiHT
 * 排班计划服务接口
 */
public interface CtBasRosterplanService extends IService<CtBasRosterplan> {
    /**
     * 根据组织单元和日期获得排班计划
     * @param companyId 公司ID
     * @param dateStr 日期
     * @return list
     */
    List<Map<String,Object>> listByDateAndOrgId(String companyId, String dateStr);

    /**
     * 根据Id查找
     * @param id id
     * @return CtBasRosterplan
     */
    CtBasRosterplan selectById(String id);
}
