package com.lihua.feedcontrollerapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * JiHT
 * @TableName CT_INV_BASEINFORECORDBILLENTRY
 */
@Data
public class CtInvBaseinforecordbillentry implements Serializable {
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
    private String cfperiod;

    /**
     * 
     */
    private String cfshchanline;

    /**
     * 
     */
    private Integer cfstatus;

    private static final long serialVersionUID = 1L;
}