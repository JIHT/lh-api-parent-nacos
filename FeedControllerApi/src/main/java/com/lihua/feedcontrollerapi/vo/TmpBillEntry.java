package com.lihua.feedcontrollerapi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
@ApiModel("生产分录")
public class TmpBillEntry {

    @ApiModelProperty("分录编号")
    private String id;

    @ApiModelProperty("实际数量")
    private BigDecimal qty;
}
