package com.ycj.lock.annotation;

import com.ycj.lock.interceptor.LockAdvisor;
import com.ycj.lock.interceptor.LockInterceptor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/29 上午10:27
 */

@Configuration
public class LockProxyConfiguration {

    @Bean(name = "lockAdvisor")
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public LockAdvisor lockAdvisor(){
        LockAdvisor lockAdvisor =new LockAdvisor();
        lockAdvisor.setAdvice(lockInterceptor());
        lockAdvisor.setAdviceBeanName("lockAdvisor");
        return lockAdvisor;
    }


    @Bean
    public LockInterceptor lockInterceptor(){
        LockInterceptor lockInterceptor = new LockInterceptor();
        return lockInterceptor;
    }
}
