package com.lihua.feedcontrollerapi.controller;

import com.lihua.common.utils.R;
import com.lihua.feedcontrollerapi.service.CtBasRosterplanService;
import com.lihua.feedcontrollerapi.service.CtInvBaseinforecordService;
import com.lihua.feedcontrollerapi.service.CtInvMatwarehouseService;
import com.lihua.feedcontrollerapi.service.CtInvMatwarehouseentryService;
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

    @Autowired
    private CtInvMatwarehouseentryService ctInvMatwarehouseentryService;

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

    @GetMapping(value = "/selectInfoByParam")
    @ApiOperation("获取期间入库确认信息")
    public R selectByParam(@RequestParam(value = "wareHouseId") String wareHouseId,
                           @RequestParam(value = "shChanLine")  String shChanLine,
                           @RequestParam(value = "materialId")  String materialId,
                           @RequestParam(value = "materialNum") String materialNum){
        List<Map<String,Object>> list = ctInvMatwarehouseentryService.selectByParam(wareHouseId, shChanLine, materialId, materialNum);
        return R.ok("success").put("data",list);
    }

    @PostMapping(value = "/insertWareEntry")
    @ApiOperation("期间入库")
    public R insertEntry(@RequestParam(value = "wareHouseId") String wareHouseId,
                         @RequestParam(value = "shChanLine") String shChanLine,
                         @RequestParam(value = "materialNum") String materialNum,
                         @RequestParam(value = "materialId") String materialId,
                         @RequestParam(value = "actualQty") String actualQty){
        Integer bool = ctInvMatwarehouseentryService.insertEntry(wareHouseId, shChanLine, materialNum, materialId, actualQty);
        return R.ok().put("data",bool);
    }
}
