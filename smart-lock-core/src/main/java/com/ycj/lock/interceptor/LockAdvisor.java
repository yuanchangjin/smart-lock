package com.ycj.lock.interceptor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/29 上午10:36
 */
public class LockAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private final LockPointcut pointcut = new LockPointcut();

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }
}
