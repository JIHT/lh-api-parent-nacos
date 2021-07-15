package com.lihua.feedcontrollerapi.controller;

import com.lihua.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/testapi")
@Api(tags = "测试")
public class Controller {


    @Value("${test.abc}")
    private String testValue;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ApiOperation("这是测试接口")
    public R home(@RequestParam String name) {

        return R.ok("这是测试接口："+testValue);
    }
}
