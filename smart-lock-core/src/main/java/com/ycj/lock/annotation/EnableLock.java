package com.ycj.lock.annotation;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import java.lang.annotation.*;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/29 上午10:20
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LockConfigurationSelector.class)
public @interface EnableLock {


    boolean proxyTargetClass() default false;


    AdviceMode mode() default AdviceMode.PROXY;


    int order() default Ordered.LOWEST_PRECEDENCE;
}
