package com.lihua.feedcontrollerapi.controller;


import com.lihua.feedcontrollerapi.common.config.JwtToken;
import com.lihua.common.utils.R;
import com.lihua.feedcontrollerapi.common.annotation.EASLogin;
import com.lihua.feedcontrollerapi.entity.TPmUser;
import com.lihua.feedcontrollerapi.service.TPmUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/base")
@Api(tags="TKdBroilersell测试接口")
public class EasBaseController {

    @Autowired
    private TPmUserService pmUserService;

    @Autowired
    private JwtToken jwtToken;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("Eas登陆")
    public R login(String userName, String passWord, HttpServletResponse response){
        TPmUser tPmUser = pmUserService.getUserByNameAndPassword(userName,passWord);
        String token =jwtToken.generateRedisToken(tPmUser.getFid());
        response.addHeader("token",token);
        return R.ok().put("token",token);
    }

    @RequestMapping(value = "/developLogin",method = RequestMethod.POST)
    @ApiOperation("Eas开发登陆")
    public R developLogin(String userName,String passWord, HttpServletResponse response){
        TPmUser tPmUser = pmUserService.getUserByName(userName);
        String token =jwtToken.generateRedisToken(tPmUser.getFid());
        response.addHeader("token",token);
        return R.ok().put("token",token);
    }

    @EASLogin
    @RequestMapping(value = "/testLogin",method = RequestMethod.GET)
    @ApiOperation("测试EAS身份认证")
    public R testLogin(@RequestAttribute String id){
        TPmUser tPmUser= pmUserService.selectById(id);
        return R.ok().put("userInfo",tPmUser);
    }

    @EASLogin
    @RequestMapping(value = "/getOrgs",method = RequestMethod.GET)
    @ApiOperation("获取用户组织")
    public R getOrgs(@RequestAttribute String id,String name){
        return R.ok().put("data",pmUserService.getOrgs(id,name));
    }

}
