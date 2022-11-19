package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("bis_device")
@ApiModel("区域")
public class BisDevice {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("设备编号")
    private String deviceCode;
    @ApiModelProperty("设备序列号")
    private String deviceSn;
    @ApiModelProperty("设备名称")
    private String deviceName;
    @ApiModelProperty("设备类型")
    private String devicetypeId;
    @ApiModelProperty("所属机构")
    private String orgId;
    @ApiModelProperty("所属区域")
    private String areaId;
    @ApiModelProperty("设备位置")
    private String deviceLocation;
    @ApiModelProperty("设备位置编码")
    private String deviceLocationCode;
    @ApiModelProperty("经度")
    private String longitude;
    @ApiModelProperty("纬度")
    private String latitude;
    @ApiModelProperty("设备状态")
    private String deviceStatus;
    @ApiModelProperty("厂商")
    private String vendorId;
    @ApiModelProperty("分包商")
    private String subcontractorId;
    @ApiModelProperty("品牌")
    private String brand;
    @ApiModelProperty("型号")
    private String model;
    @ApiModelProperty("所属项目")
    private String projectId;
    @ApiModelProperty("设备IP")
    private String deviceIp;
    @ApiModelProperty("设备端口")
    private String devicePort;
    @ApiModelProperty("出厂序列号")
    private String factorySn;
    @ApiModelProperty("安装日期")
    private Date installDate;
    @ApiModelProperty("第三方系统编码")
    private String thirdsyscode;
    @ApiModelProperty("维护单位")
    private String maintaindepart;
    @ApiModelProperty("方向")
    private String direction;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("创建人")
    private String creUser;
    @ApiModelProperty("创建时间")
    private Date creDate;
    @ApiModelProperty("最后修改人")
    private String lastModUser;
    @ApiModelProperty("最后修改时间")
    private Date lastModDate;
    @ApiModelProperty("是否有效")
    private String isactive;
    @ApiModelProperty("车道编号")
    private String laneCode;
    @ApiModelProperty("设备类型")
    private String devicetypeHitamp;
    @ApiModelProperty("施工状态")
    private String constructStatus;
    @ApiModelProperty("设备规格编码")
    private String deviceRulCode;
    @ApiModelProperty("几何信息")
    private String geometry;

}
