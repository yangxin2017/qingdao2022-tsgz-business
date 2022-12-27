package com.bgd.tsgz.aspect;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestLog {
    String moduleName() ;
    String functionName() ;
}
