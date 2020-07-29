package com.ycj.lock.annotation;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/29 上午10:23
 */
public class LockConfigurationSelector extends AdviceModeImportSelector<EnableLock>{


    @Override
    protected String[] selectImports(AdviceMode adviceMode) {

        switch (adviceMode) {
			case PROXY:
				return new String[] { AutoProxyRegistrar.class.getName(), LockProxyConfiguration.class.getName() };
			default:
				return null;
		}
    }
}
