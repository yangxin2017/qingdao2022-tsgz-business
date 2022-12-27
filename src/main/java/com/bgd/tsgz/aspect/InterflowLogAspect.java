package com.bgd.tsgz.aspect;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
@Log4j2
public class InterflowLogAspect {

    //使用环绕通知，获取接口请求和返回参数
//    @Around("@annotation(com.bgd.tsgz.aspect.RequestLog)")
    @AfterReturning("@annotation(com.bgd.tsgz.aspect.RequestLog)")
    public void logAroundController(JoinPoint joinPoint) {
        try{
            //获取当前请求对象
            //这个RequestContextHolder是Springmvc提供来获得请求的东西
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

            //请求入参
            String postData="";
            try {
                postData = IoUtil.read(request.getInputStream(), Charset.forName("UTF-8"));
            } catch (IOException e) {
                log.error( "##error found", e);
            }
            //获取进入的类名
//            String className = joinPoint.getSignature().getDeclaringTypeName();
            // 获取方法签名
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            // 调用方法名称
//            String methodName = joinPoint.getSignature().getName();
            //获取方法上的注解
            RequestLog reqLog = methodSignature.getMethod().getAnnotation(RequestLog.class);
            //请求方法中文名称
//            String reqMethodName = reqLog.moduleName();
            JSONObject params = new JSONObject();
            params.put("sysName","tsgz");
            params.put("saveDate", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            params.put("logType","3");
            params.put("moduleName", reqLog.moduleName());
            params.put("functionName", reqLog.functionName());
            params.put("userId","admin");
            params.put("userName",getIp(request));
            params.put("operateIp",getIp(request));
            params.put("operateResult","1");
            params.put("description",reqLog.functionName());
            String url = "http://10.16.7.14:8999/log-server/logs/saveLog";
            String result = HttpUtil.post(url,params.toJSONString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 获取到多个ip时取第一个作为客户端真实ip
        if (StringUtils.isNotEmpty(ip) && ip.contains(",")) {
            String[] ipArray = ip.split(",");
            if (ArrayUtils.isNotEmpty(ipArray)) {
                ip = ipArray[0];
            }
        }
        return ip;
    }
}
