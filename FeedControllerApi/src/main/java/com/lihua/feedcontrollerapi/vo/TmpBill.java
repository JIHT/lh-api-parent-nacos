package com.lihua.feedcontrollerapi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("生产结果")
public class TmpBill {

    @ApiModelProperty("单据编号")
    private String billIId;

    @ApiModelProperty("分录")
    private List<TmpBillEntry> entries;


}
