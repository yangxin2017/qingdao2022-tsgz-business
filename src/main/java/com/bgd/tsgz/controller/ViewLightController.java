package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewLight;
import com.bgd.tsgz.service.ViewLightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "信号灯", tags = {"信号灯"})
public class ViewLightController {
    @Autowired
    private ViewLightService viewLightService;

   /* @GetMapping("add")
    @ApiOperation(value = "测试添加", notes = "测试添加")
    public ResponseData<ViewLight> AddData() {
        ViewLight v = new ViewLight();
        v.setAddress("1");
        v.setDepartment("2");
        v.setInstalldate("3");
        v.setLat("4");
        v.setLng("5");
        v.setName("6");
        v.setStatus("7");
        v.setThirdnumber("8");
        v.setSignalid("9");
        viewLightService.save(v);
        return ResponseData.OK(v);
    }*/

    // getLightList，接收name参数
    @GetMapping("getLightList")
    @ApiOperation(value = "获取信号灯列表", notes = "获取信号灯列表")
    public ResponseData<ViewLight> getLightList(String name) {
        QueryWrapper<ViewLight> queryWrapper = new QueryWrapper<>();
        if(name != null && !name.equals("")){
            queryWrapper.like("name", name);
        }
        return OK(viewLightService.list(queryWrapper));
    }
}
