package com.lihua.feedcontrollerapi.controller;


import com.lihua.common.utils.R;
import com.lihua.feedcontrollerapi.entity.TProProducebill;
import com.lihua.feedcontrollerapi.service.TOrgStorageService;
import com.lihua.feedcontrollerapi.service.TProProducebillService;
import com.lihua.feedcontrollerapi.vo.TmpBill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/feedCtrlApi")
@Api(tags = "饲料中控接口")
public class FeedApiController {

    @Autowired
    private TOrgStorageService tOrgStorageService;

    @Autowired
    private TProProducebillService mTProProducebillService;

    @GetMapping(value = "/listOrg")
    @ApiOperation("获取饲料部")
    public R listOrg(@RequestParam String orgName) {
        List<Map<String, Object>> list = tOrgStorageService.listDeps(orgName);
        return R.ok().put("data", list);
    }


    @PostMapping(value = "listBillsByDate")
    @ApiOperation("获取指定日期生产单")
    public R listBillsByDate(String orgId,String dateStr){
        List<Map<String,Object>> list = mTProProducebillService.listBillsByDate(orgId,dateStr);
        return R.ok().put("data", list);
    }


    @PostMapping(value = "startBillsByDate")
    @ApiOperation("开始生产")
    public R startBillsByDate(String billId){
        mTProProducebillService.startBillsByDate(billId);
        return R.ok("success");
    }


    @PostMapping(value = "overBillsByDate")
    @ApiOperation("完成生产")
    public R overBillsByDate(@RequestBody TmpBill tmpBill){
       mTProProducebillService.overBillsByDate(tmpBill);
        return R.ok("success");
    }

}
