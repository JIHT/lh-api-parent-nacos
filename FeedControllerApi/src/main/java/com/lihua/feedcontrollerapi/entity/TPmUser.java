package com.lihua.feedcontrollerapi.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * T_PM_USER实体类
 * 
 * @author 
 *
 */
@TableName("T_PM_USER")
@Data
public class TPmUser implements Serializable{

	private static final long serialVersionUID = 1L;

		/***/
		@TableId(type = IdType.INPUT)
		private String fid;
		/***/
		private String fnumber;
		/***/
		private String fnameL1;
		/***/
		private String fnameL2;
		/***/
		private String fnameL3;
		/***/
		private Integer ftype;
		/***/
		private String fdescriptionL1;
		/***/
		private String fdescriptionL2;
		/***/
		private String fdescriptionL3;
		/***/
		private String fpassword;
		/***/
		private Integer fisdelete;
		/***/
		private Integer fislocked;
		/***/
		private Integer fforbidden;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date feffectivedate;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date finvalidationdate;
		/***/
		private String fdefaultlocale;
		/***/
		private Integer fisregister;
		/***/
		private Integer ferrcount;
		/***/
		private String fgroupid;
		/***/
		private String fpersonid;
		/***/
		private String fsecurityid;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date fpweffectivedate;
		/***/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date flockedtime;
		/***/
		private Integer fisbizadmin;
		/***/
		private Integer fischangedpw;
		/***/
		private String fdeforgunitid;
		/***/
		private String fcontrolunitid;
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
		private String fcustomerid;
		/***/
		private String fsupplierid;
		/***/
		private String fmainroleid;
		/***/
		private Integer fagentuser;
		/***/
		private Integer floginauthorway;
		/***/
		private String fpwdhisstr;
		/***/
		private String freferid;
		/***/
		private String fcell;
		/***/
		private String fbackupemail;
		/***/
		private String fhomephone;
		/***/
		private String fofficephone;
		/***/
		private String femail;
		/***/
		private String fadnumber;
		/***/
		private String fnamepinyin;
		/***/
		private String fnameshortpinyin;
		/***/
		private String fpinyin;
		/***/
		private String fshortpinyin;
		/***/
		private Integer fisauthenadmin;

	

}
