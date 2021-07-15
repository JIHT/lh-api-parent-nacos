package com.lihua.feedcontrollerapi.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;



/**
 * T_ORG_STORAGE实体类
 *
 * @author
 *
 */
@Data
@TableName("T_ORG_STORAGE")
public class TOrgStorage  implements Serializable{

	private static final long serialVersionUID = 1L;

		/***/
		@TableId(type = IdType.INPUT)
		private String fid;
		/***/
		private String fnameL1;
		/***/
		private String fnameL2;
		/***/
		private String fnameL3;
		/***/
		private String fnumber;
		/***/
		private String fdescriptionL1;
		/***/
		private String fdescriptionL2;
		/***/
		private String fdescriptionL3;
		/***/
		private String fsimplename;
		/***/
		private Integer fisgrouping;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date feffectdate;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date finvaliddate;
		/***/
		private Integer fisfreeze;
		/***/
		private Integer fiscompanyorgunit;
		/***/
		private Integer fisadminorgunit;
		/***/
		private Integer fissaleorgunit;
		/***/
		private Integer fispurchaseorgunit;
		/***/
		private Integer fisstorageorgunit;
		/***/
		private Integer fisprofitorgunit;
		/***/
		private Integer fiscostorgunit;
		/***/
		private Integer fiscu;
		/***/
		private Integer fisunion;
		/***/
		private Integer fishrorgunit;
		/***/
		private String fcreatorid;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date fcreatetime;
		/***/
		private String flastupdateuserid;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date flastupdatetime;
		/***/
		private String fcontrolunitid;
		/***/
		private Integer fisleaf;
		/***/
		private Integer flevel;
		/***/
		private String flongnumber;
		/***/
		private String fparentid;
		/***/
		private String fleader;
		/***/
		private String faddressid;
		/***/
		private Integer fissealup;
		/***/
		private Integer fisbizunit;
		/***/
		private Integer ftype;
		/***/
		private Integer fstatus;
		/***/
		private Integer fisstart;
		/***/
		private Integer fisousealup;
		/***/
		private String fdisplaynameL1;
		/***/
		private String fdisplaynameL2;
		/***/
		private String fdisplaynameL3;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date fpropertysealupdate;
		/***/
		private String flocation;
		/***/
		private String fversionnumber;
		/***/
		private String fcode;
		/***/
		private Integer fistransportorgunit;
		/***/
		private Integer fisqualityorgunit;
		/***/
		private String forgtypestr;
		/***/
		private String jing;
		/***/
		private String wei;
		/***/
		private String jingweiuser;

}
