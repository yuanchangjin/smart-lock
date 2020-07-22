package com.ycj.lock.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

/**
 * @Author: yuanchangjin
 * @Description:Lock注解拦截器
 * @Date: 2020/6/29 上午10:34
 */


@Aspect
public class LockAspect implements Ordered {
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
