package com.lihua.feedcontrollerapi.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * T_PRO_PRODUCEBILLENTRY实体类
 *
 * @author
 *
 */
@Data
@TableName("CT_INV_DESIGNFEEDBILLENTRY")
public class TProProducebillentry  implements Serializable{

	private static final long serialVersionUID = 1L;

		/***/
		private Integer fseq;
		/***/
		@TableId(type = IdType.INPUT)
		private String fid;
		/***/
		private String fparentid;
		/***/
		private String fstuffnumberid;
		/***/
		private String fentrysunitid;
		/***/
		private BigDecimal ffinishqty;
		/***/
		private Integer fschqty;
		/***/
		private Integer fdiff;
		/***/
		private String fremark;
		/***/
		private Integer ffinishthqty;
		/***/
		private Integer funitactcost;
		/***/
		private Integer factcost;
		/***/
		private String fstorageid;
		/***/
		private String fdataresource;
		/***/
		private String cfdiffpercent;
		/***/
		private String cflot;
}
