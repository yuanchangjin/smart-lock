package com.ycj.lock;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/28 上午11:19
 */
public interface LockManager {

    /**
     * 获取Lock对象
     * @param name
     * @return
     */
    Lock getLock(String name);
}
