package com.lihua.feedcontrollerapi.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.models.auth.In;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * T_PRO_PRODUCEBILL实体类
 *
 * @author
 *
 */
@Data
@TableName("CT_INV_DesignFeedBill")
public class TProProducebill  implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	@TableId(type = IdType.INPUT)
	private String fid;

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
	private String fcompanyid;

	/**
	 *
	 */
	private String fcontrolunitid;

	/**
	 *
	 */
	private Integer ffivouchered;

	/**
	 *
	 */
	private String ffeednumberid;

	/**
	 *
	 */
	private String funitid;

	/**
	 *
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fstartdate;

	/**
	 *
	 */
	private BigDecimal fschqty;

	/**
	 *
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date ffinishdate;

	/**
	 *
	 */
	private String ffeedbomid;

	/**
	 *
	 */
	private String forgunitwensid;

	/**
	 *
	 */
	private Integer fisdel;

	/**
	 *
	 */
	private String fperiod;

	/**
	 *
	 */
	private String fbatch;

	/**
	 *
	 */
	private Date cfstime;

	/**
	 *
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cfetime;

	/**
	 *
	 */
	private String cfstatus;

	/**
	 *
	 */
	private String cfproductiondesignid;

	@TableField(exist = false)
	private List<TProProducebillentry> entries;
}
