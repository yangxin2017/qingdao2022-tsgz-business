package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("intercity_travel")
@ApiModel("城市群城市联系特征")
public class IntercityTravel {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("城市群名称")
    private String sname;
    @ApiModelProperty("首位城市")
    private String ename;
    @ApiModelProperty("流量")
    private String value;
    @ApiModelProperty("起始位置")
    private String sposition;
    @ApiModelProperty("结束位置")
    private String eposition;
}
