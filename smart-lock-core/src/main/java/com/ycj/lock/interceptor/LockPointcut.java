package com.ycj.lock.interceptor;

import com.ycj.lock.annotation.Lock;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/29 上午10:39
 */
public class LockPointcut extends StaticMethodMatcherPointcut implements Serializable {
    @Override
    public boolean matches(Method method, Class<?> aClass) {

        if(null!=method.getAnnotation(Lock.class)){
            return true;
        }else {
            return false;
        }
    }
}
