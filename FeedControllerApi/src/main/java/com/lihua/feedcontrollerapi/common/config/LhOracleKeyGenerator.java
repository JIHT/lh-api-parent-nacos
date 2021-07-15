package com.lihua.feedcontrollerapi.common.config;

import com.baomidou.mybatisplus.incrementer.OracleKeyGenerator;

public class LhOracleKeyGenerator extends OracleKeyGenerator {
    public LhOracleKeyGenerator() {
    }

    @Override
    public String executeSql(String incrementerName) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(incrementerName);
        sql.append(" FROM DUAL");
        return sql.toString();
    }
}
