package com.lihua.common.utils;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/3/11.
 * 极光推送
 */
public class JPushUtil {
    public static void pushMsgByTag(String userid, String title, String msg) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("channelId", userid);
        paramMap.put("title", title==null?"立华牧业":title);
        paramMap.put("globalRemark", msg==null?"您有一条新消息":msg);
        paramMap.put("dvtype", 0);
        paramMap.put("extrasparam", "");
        String result = HttpUtil.post("http://192.168.0.109:8880/xxl-job-admin/jobJpush/pushMessageToPhone", paramMap);

        paramMap.put("dvtype", 1);
        String resultIos = HttpUtil.post("http://192.168.0.109:8880/xxl-job-admin/jobJpush/pushMessageToPhone", paramMap);
    }
}
