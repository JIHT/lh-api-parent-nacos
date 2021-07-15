package com.lihua.feedcontrollerapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * JiHT
 * @TableName CT_INV_MATWAREHOUSE
 */
@Data
@TableName("CT_INV_MATWAREHOUSE")
public class CtInvMatwarehouse implements Serializable {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    private String cforgunitid;

    /**
     * 
     */
    private String cfmaterialid;

    /**
     * 
     */
    private String cfplansheet;

    /**
     * 
     */
    private BigDecimal cfplanqty;

    /**
     * 
     */
    private String cfbatch;

    /**
     * 
     */
    private String cfspecification;

    /**
     * 
     */
    private String cfwarestatus;

    private static final long serialVersionUID = 1L;
}