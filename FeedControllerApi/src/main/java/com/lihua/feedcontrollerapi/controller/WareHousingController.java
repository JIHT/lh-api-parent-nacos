package com.lihua.feedcontrollerapi.controller;

import com.lihua.common.utils.R;
import com.lihua.feedcontrollerapi.service.CtBasRosterplanService;
import com.lihua.feedcontrollerapi.service.CtInvBaseinforecordService;
import com.lihua.feedcontrollerapi.service.CtInvMatwarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/wareHousingApi")
@Api(tags = "饲料入库接口")
public class WareHousingController {
    @Autowired
    private CtBasRosterplanService ctBasRosterplanService;

    @Autowired
    private CtInvBaseinforecordService ctInvBaseinforecordService;

    @Autowired
    private CtInvMatwarehouseService ctInvMatwarehouseService;

    @GetMapping(value = "/listByDateAndOrgId")
    @ApiOperation("根据日期和组织获取排班计划")
    public R listByDateAndOrgId(@RequestParam(value = "companyId") String companyId,
                                @RequestParam(value = "date") String dateStr){
        List<Map<String, Object>> list = ctBasRosterplanService.listByDateAndOrgId(companyId, dateStr);
        return R.ok().put("data",list);
    }

    @PostMapping(value = "/genetrateBill")
    @ApiOperation("开始计数")
    public R genetrateByDesignId(@RequestParam(value = "id") String id,
                                 @RequestParam(value = "date")String dateStr,
                                 @RequestParam(value = "period")String period,
                                 @RequestParam(value = "shChanLine")String shChanLine,
                                 @RequestParam(value = "materialId")String materialId) throws ParseException {
        String baseId = ctInvBaseinforecordService.insertBill(id,dateStr,period,shChanLine);
        String wareHouseId = ctInvMatwarehouseService.insertAll(id, dateStr, materialId);
        Map<String,Object> map = new HashMap<>();
        map.put("baseId",baseId);
        map.put("wareHouseId",wareHouseId);
        return R.ok("success").put("data",map);
    }
}
