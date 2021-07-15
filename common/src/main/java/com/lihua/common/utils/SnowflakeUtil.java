package com.lihua.common.utils;

import cn.hutool.core.lang.Snowflake;

/**
 * @author IGisvity
 */
public class SnowflakeUtil {
    private static final Snowflake snowFlake = new Snowflake(1L,1L,true);
    private SnowflakeUtil(){}
    public static Snowflake getInstance(){
        return snowFlake;
    }
}
