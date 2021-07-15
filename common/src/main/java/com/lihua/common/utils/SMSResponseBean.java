package com.lihua.common.utils;

public class SMSResponseBean {

    /**
     * msg : ok
     * code : 200
     * data : {"result":200,"requestId":"7bgsdg2sdhfwi34hkhui"}
     */
    private String msg;
    private int code;
    private Object data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
