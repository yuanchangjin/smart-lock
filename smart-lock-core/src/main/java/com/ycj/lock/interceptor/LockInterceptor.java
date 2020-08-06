package com.ycj.lock.interceptor;

import com.ycj.lock.LockManager;
import com.ycj.lock.annotation.Lock;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/29 上午10:29
 */
public class LockInterceptor implements MethodInterceptor,Serializable {

    /**
     *
     */
    private LockManager lockManager;


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Lock lock = methodInvocation.getMethod().getAnnotation(Lock.class);

        if (Objects.nonNull(lock)) {
            com.ycj.lock.Lock lock1 = lockManager.getLock("");
            try {
                lock1.lock("", 0L);
                return methodInvocation.proceed();
            } finally {
                lock1.unLock("");
            }
        }
        return methodInvocation.proceed();
    }
}
