package com.ycj.lock.annotation;

import com.ycj.lock.enums.LockType;

import java.lang.annotation.*;

/**
 * @Author: yuanchangjin
 * @Description: 分布式锁注解
 * @Date: 2020/6/29 上午10:39
 */



@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Lock {


    /**
     * 锁的前缀key
     * @return
     */
    String preKey() default "";


    /**
     *锁的主体key，支持spring EL表达式
     */
    String mainKey() default "";


    /**
     * key
     * @return
     */
    String key() default "";



    /**
     * 锁类型
     * @return LockType
     */
    LockType lockType() default LockType.REENTRANT_LOCK;

    /**
     * 锁超时时间/单位秒，默认3S
     * @return
     */
    long timeOut() default 3L;
}
