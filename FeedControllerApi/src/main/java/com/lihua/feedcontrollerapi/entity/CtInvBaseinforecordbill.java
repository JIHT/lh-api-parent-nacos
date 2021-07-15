package com.lihua.feedcontrollerapi.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Jiht
 * @TableName CT_INV_BASEINFORECORDBILL
 */
@Data
@TableName("CT_INV_BASEINFORECORDBILL")
public class CtInvBaseinforecordbill implements Serializable {
    /**
     * 
     */
    private String fid;

    /**
     * 
     */
    private String fcreatorid;

    /**
     * 
     */
    private Date fcreatetime;

    /**
     * 
     */
    private String flastupdateuserid;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date flastupdatetime;

    /**
     * 
     */
    private String fcontrolunitid;

    /**
     * 
     */
    private String fnumber;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date fbizdate;

    /**
     * 
     */
    private String fhandlerid;

    /**
     * 
     */
    private String fdescription;

    /**
     * 
     */
    private Integer fhaseffected;

    /**
     * 
     */
    private String fauditorid;

    /**
     * 
     */
    private String fsourcebillid;

    /**
     * 
     */
    private String fsourcefunction;

    /**
     * 
     */
    private Integer ffivouchered;

    /**
     * 
     */
    private String cfproductionplanid;

    private static final long serialVersionUID = 1L;

}