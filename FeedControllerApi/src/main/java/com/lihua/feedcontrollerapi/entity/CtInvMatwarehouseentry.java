package com.lihua.feedcontrollerapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * JiHT
 * @TableName CT_INV_MATWAREHOUSEENTRY
 */
@Data
@TableName("CT_INV_MATWAREHOUSEENTRY")
public class CtInvMatwarehouseentry implements Serializable {
    /**
     * 
     */
    private String fid;

    /**
     * 
     */
    private Integer fseq;

    /**
     * 
     */
    private String fparentid;

    /**
     * 
     */
    private BigDecimal cfaicount;

    /**
     * 
     */
    private BigDecimal cfbrokenqty;

    /**
     * 
     */
    private BigDecimal cfunqualifiedqty;

    /**
     * 
     */
    private BigDecimal cfreturnqty;

    /**
     * 
     */
    private BigDecimal cfreviseqty;

    /**
     * 
     */
    private BigDecimal cfactualqty;

    /**
     * 
     */
    private Integer cfyfmakelist;

    /**
     * 
     */
    private String cfaimaterialid;

    /**
     * 
     */
    private String cfshchanline;

    private static final long serialVersionUID = 1L;
}