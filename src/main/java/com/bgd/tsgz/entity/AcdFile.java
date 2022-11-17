package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;


@Data
@TableName("acd_file")
@ApiModel("事故")
public class AcdFile {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("事故编号")
    private String sgbh;
    @ApiModelProperty("行政区划")
    private String xzqh;
    @ApiModelProperty("登记编号")
    private String djbh;
    @ApiModelProperty("开始勘查时间")
    private Date kskcsj;
    @ApiModelProperty("结束勘查时间")
    private Date jskcsj;
    @ApiModelProperty("县区")
    private String xq;
    @ApiModelProperty("事故发生时间")
    private Date sgfssj;
    @ApiModelProperty("路号")
    private String lh;
    @ApiModelProperty("路名")
    private String lm;
    @ApiModelProperty("公里数")
    private String gls;
    @ApiModelProperty("米数")
    private String ms;
    @ApiModelProperty("起点米数")
    private String qdms;
    @ApiModelProperty("街道位置")
    private String jdwz;
    @ApiModelProperty("事故地点")
    private String sgdd;
    @ApiModelProperty("灾害点名称位置")
    private String zhdmwz;
    @ApiModelProperty("主要管理所属")
    private String zyglss;
    @ApiModelProperty("道路安全属性")
    private String dlaqsx;
    @ApiModelProperty("交通型号分类")
    private String jtxhfs;
    @ApiModelProperty("发生事故类型")
    private String fhsslx;
    @ApiModelProperty("道路物理管理")
    private String dlwlgl;
    @ApiModelProperty("路面状况")
    private String lmzk;
    @ApiModelProperty("路标情况")
    private String lbqk;
    @ApiModelProperty("路面结构")
    private String lmjg;
    @ApiModelProperty("路口路段类型")
    private String lkldlx;
    @ApiModelProperty("道路线型")
    private String dlxx;
    @ApiModelProperty("道路类型")
    private String dllx;
    @ApiModelProperty("勘查人1")
    private String kcr1;
    @ApiModelProperty("勘查人2")
    private String kcr2;
    @ApiModelProperty("编案人1")
    private String bar1;
    @ApiModelProperty("编案人2")
    private String bar2;
    @ApiModelProperty("死亡人数")
    private String swrs;
    @ApiModelProperty("死亡人数其中")
    private String swrsq;
    @ApiModelProperty("死亡人数24小时内")
    private String swrs24;
    @ApiModelProperty("受伤人数24小时内")
    private String ssrs24;
    @ApiModelProperty("死亡人数3天内")
    private String swrs3;
    @ApiModelProperty("受伤人数3天内")
    private String ssrs3;
    @ApiModelProperty("死亡人数7天内")
    private String swrs7;
    @ApiModelProperty("受伤人数7天内")
    private String ssrs7;
    @ApiModelProperty("死亡人数30天内")
    private String swrs30;
    @ApiModelProperty("受伤人数30天内")
    private String ssrs30;
    @ApiModelProperty("失踪人数")
    private String szrs;
    @ApiModelProperty("重伤人数")
    private String zsrs;
    @ApiModelProperty("轻伤人数")
    private String qsrs;
    @ApiModelProperty("受伤人数")
    private String ssrs;
    @ApiModelProperty("机动车数量")
    private String jdcsl;
    @ApiModelProperty("非机动车数量")
    private String fjdcsl;
    @ApiModelProperty("行人数量")
    private String xrsl;
    @ApiModelProperty("事故管理部门")
    private String xsglbm;
    @ApiModelProperty("事故办案单位")
    private String xsbadw;
    @ApiModelProperty("事故办案人")
    private String xsbar;
    @ApiModelProperty("图片张数")
    private String tpzs;
    @ApiModelProperty("现场图张数")
    private String xctzs;
    @ApiModelProperty("现场照片张数")
    private String xczpzs;
    @ApiModelProperty("直接财产损失")
    private String zjccss;
    @ApiModelProperty("事故类型")
    private String sglx;
    @ApiModelProperty("路外事故类型")
    private String lwsglx;
    @ApiModelProperty("车辆主要原因分类")
    private String ccyyfl;
    @ApiModelProperty("人员主要原因分类")
    private String rdyyfl;
    @ApiModelProperty("事故主要原因")
    private String sgccyy;
    @ApiModelProperty("事故人员主要原因")
    private String sgrdyy;
    @ApiModelProperty("简要案情")
    private String jyaq;
    @ApiModelProperty("天气")
    private String tq;
    @ApiModelProperty("能见度")
    private String njd;
    @ApiModelProperty("现场")
    private String xc;
    @ApiModelProperty("死亡事故")
    private String swsg;
    @ApiModelProperty("事故系统")
    private String sgxt;
    @ApiModelProperty("是否通知")
    private String sfty;
    @ApiModelProperty("车辆接触事故")
    private String cljsg;
    @ApiModelProperty("倒车事故")
    private String dcsg;
    @ApiModelProperty("碰撞方式")
    private String pzfs;
    @ApiModelProperty("逃逸事故照片")
    private String tysgzp;
    @ApiModelProperty("逃逸照片时间")
    private String tyzpsj;
    @ApiModelProperty("地形")
    private String dx;
    @ApiModelProperty("路面状况")
    private String zmtj;
    @ApiModelProperty("填报人1")
    private String tjr1;
    @ApiModelProperty("填报人2")
    private String tjr2;
    @ApiModelProperty("有证无效牌")
    private String yzwxp;
    @ApiModelProperty("有证无效牌合格")
    private String yzwxphg;
    @ApiModelProperty("出车离去时间")
    private String cclrsj;
    @ApiModelProperty("交通事故记录类型")
    private String jllx;
    @ApiModelProperty("事故经度")
    private String scsjd;
    @ApiModelProperty("经办人")
    private String jbr;
    @ApiModelProperty("填报时间")
    private String tjsj;
    @ApiModelProperty("更新时间")
    private String gxsj;
    @ApiModelProperty("所属中队")
    private String sszd;
    @ApiModelProperty("管理性质等级")
    private String glxzdj;
    @ApiModelProperty("档案号")
    private String dah;
    @ApiModelProperty("警官号")
    private String jnh;
    @ApiModelProperty("事故性质")
    private String sxxz;
    @ApiModelProperty("事故标志")
    private String sb;
    @ApiModelProperty("统计事故编号")
    private String tjsgbh;
    @ApiModelProperty("管理部门")
    private String glbm;
    @ApiModelProperty("预留字段1")
    private String ylzd1;
    @ApiModelProperty("预留字段2")
    private String ylzd2;
    @ApiModelProperty("预留字段3")
    private String ylzd3;
    @ApiModelProperty("预留字段4")
    private String ylzd4;
    @ApiModelProperty("预留字段5")
    private String ylzd5;
    @ApiModelProperty("定位坐标")
    private String dzzb;
    @ApiModelProperty("特殊预留1")
    private String tdyl1;
    @ApiModelProperty("特殊预留2")
    private String tdyl2;
    @ApiModelProperty("特殊预留3")
    private String tdyl3;
    @ApiModelProperty("特殊预留4")
    private String tdyl4;
    @ApiModelProperty("特殊预留5")
    private String tdyl5;
    @ApiModelProperty("特殊预留6")
    private String tdyl6;
    @ApiModelProperty("特殊预留7")
    private String tdyl7;
    @ApiModelProperty("特殊预留8")
    private String tdyl8;
    @ApiModelProperty("特殊预留9")
    private String tdyl9;
    @ApiModelProperty("特殊预留10")
    private String tdyl10;
    @ApiModelProperty("报案联系方式")
    private String balxfs;
    @ApiModelProperty("报案单位")
    private String badw;
    @ApiModelProperty("行业性质代码")
    private String xyxdm;
    @ApiModelProperty("校验位")
    private String jyw;
    @ApiModelProperty("是否二次事故")
    private String sfecsg;
    @ApiModelProperty("是否单行事故")
    private String sfdxsg;
    @ApiModelProperty("道路安全隐患等级")
    private String dlaqyhdj;
    @ApiModelProperty("当事人总数")
    private String dsrzs;
    @ApiModelProperty("发生机构")
    private String fsjg;
    @ApiModelProperty("发放机构")
    private String ffjg;
    @ApiModelProperty("事故地点市场位置")
    private String sdsgdscwz;
    @ApiModelProperty("核录状态")
    private String hlzt;
    @ApiModelProperty("证本类型")
    private String zblx;
    @ApiModelProperty("案件名称")
    private String ajmc;
    @ApiModelProperty("道路安全隐患类型")
    private String dlaqyhlx;
    @ApiModelProperty("事故认定原因描述")
    private String sgrdyyms;
    @ApiModelProperty("事故性质采集")
    private String sxxcj;
    
    
}
