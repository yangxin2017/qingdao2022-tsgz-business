package com.bgd.tsgz.service.impi;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.bgd.tsgz.entity.LogVo;
import com.bgd.tsgz.service.LogVoService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogVoServiceImpl implements LogVoService {
    @Override
    public void sendLog(LogVo logVo) {

        // 开启多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // post请求http://10.16.21.24:1802/log-server/logs/saveLog并携带logVo的参数
                    String url = "http://10.16.21.24:1802/log-server/logs/saveLog";
                    String result = HttpUtil.post(url, JSONObject.toJSONString(logVo));
                    System.out.println(result);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}