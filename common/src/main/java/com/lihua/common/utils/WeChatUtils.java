package com.lihua.common.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class WeChatUtils {

    public static Log log;
    public static JSONObject getSessionKeyOrOpenId(String code,String appid,String secret){
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        HashMap<String,Object> requestUrlParam = new HashMap<>();
        requestUrlParam.put( "appid",appid );//小程序appId
        requestUrlParam.put( "secret",secret);
        requestUrlParam.put( "js_code",wxCode );//小程序端返回的code
        requestUrlParam.put( "grant_type","authorization_code" );//默认参数
        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpUtil.post(requestUrl,requestUrlParam));
        return jsonObject;
    }
}
