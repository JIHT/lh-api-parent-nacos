package com.lihua.feedcontrollerapi.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * JiHT
 * @TableName CT_BAS_ROSTERPLAN 排班计划实体类
 */
@Data
@TableName("CT_BAS_ROSTERPLAN")
public class CtBasRosterplan {
    /**
     *
     */
    private String fid;

    /**
     *
     */
    private String fnumber;

    /**
     *
     */
    private String fsimplename;

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
    private String cfshiftleaderid;

    /**
     *
     */
    private String cffeedid;

    /**
     *
     */
    private String cfweight;

    /**
     *
     */
    private String cfformulaid;

    /**
     *
     */
    private String cfyhlformulaid;

    /**
     *
     */
    private BigDecimal cfquantity;

    /**
     *
     */
    private Integer cfisduty;

    /**
     *
     */
    private String cforgid;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cfplandate;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cfplantime;

    /**
     *
     */
    private String fnameL1;

    /**
     *
     */
    private String fnameL2;

    /**
     *
     */
    private String fnameL3;

    /**
     *
     */
    private String fdescriptionL1;

    /**
     *
     */
    private String fdescriptionL2;

    /**
     *
     */
    private String fdescriptionL3;

    /**
     *
     */
    private String cffinishstorageid;

    /**
     *
     */
    private String cfperiod;

    /**
     *
     */
    private String cfoutstorageid;

    /**
     *
     */
    private Integer cfdisable;

    /**
     *
     */
    private String cfstatus;

    /**
     *
     */
    private Integer cfisinvalid;

    /**
     *
     */
    private String cfcompanyid;

    private static final long serialVersionUID = 1L;
}
