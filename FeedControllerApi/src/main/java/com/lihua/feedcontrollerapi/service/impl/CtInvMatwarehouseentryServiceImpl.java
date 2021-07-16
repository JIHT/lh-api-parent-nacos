package com.lihua.feedcontrollerapi.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lihua.common.utils.ToolUtils;
import com.lihua.feedcontrollerapi.dao.CtInvMatwarehouseentryDao;
import com.lihua.feedcontrollerapi.dao.TBdMaterialDao;
import com.lihua.feedcontrollerapi.entity.CtInvMatwarehouseentry;
import com.lihua.feedcontrollerapi.service.CtInvMatwarehouseService;
import com.lihua.feedcontrollerapi.service.CtInvMatwarehouseentryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CtInvMatwarehouseentryService")
public class CtInvMatwarehouseentryServiceImpl extends ServiceImpl<CtInvMatwarehouseentryDao, CtInvMatwarehouseentry> implements CtInvMatwarehouseentryService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Autowired
    private TBdMaterialDao tBdMaterialDao;

    @Autowired
    private CtInvMatwarehouseService ctInvMatwarehouseService;

    @Override
    public List<Map<String, Object>> selectByParam(String wareHouseId, String shChanLine, String materialId, String materialNum) {
        List<Map<String,Object>> list = baseMapper.selectByNumAndWare(wareHouseId, shChanLine);
        for (int i = 0; i < list.size(); i++){
            if ( i == 0){
                Map<String,Object> map = list.get(i);
                Integer customaryCount = 0;
                if (map.isEmpty()){
                    customaryCount = 0;
                    map.put("materialId",materialId);
                    String materialName = tBdMaterialDao.selectNameById(materialId);
                    map.put("materialName",materialName);
                }else{
                    String key = "AICOUNT";
                    customaryCount = Integer.valueOf(map.get(key).toString());
                }
                Integer wareCount = Integer.parseInt(materialNum) - customaryCount;
                map.put("materialNum",materialNum);
                map.put("wareCount",wareCount);
            }
        }
        return list;
    }

    @Override
    public Integer insertEntry(String wareHouseId, String shChanLine, String materialNum, String materialId, String wareCount) {
        String fid = ToolUtils.getUUID();
        //修改单据状态
        ctInvMatwarehouseService.updateStatus(wareHouseId,"1");
        return baseMapper.insertEntry(fid,wareHouseId,shChanLine,materialNum,materialId,wareCount);
    }
}
