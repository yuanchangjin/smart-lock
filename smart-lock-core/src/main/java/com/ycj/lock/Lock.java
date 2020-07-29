package com.ycj.lock;

import com.ycj.lock.enums.LockType;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/7/28 上午11:18
 */
public interface Lock {

    /**
     *
     * @param lockKey
     * @param timeOut
     * @return
     */
    Lock lock(String lockKey, long timeOut);

    /**
     *
     * @param lockKey
     * @param lockType
     * @param timeOut
     * @return
     */
    Lock lock(String lockKey, LockType lockType, long timeOut);

    /**
     *
     * @param lockKey
     * @param timeOut
     * @return
     */
    boolean tryLock(String lockKey, long timeOut);

    /**
     *
     * @param lockKey
     * @param lockType
     * @param timeOut
     * @return
     */
    boolean tryLock(String lockKey, LockType lockType, long timeOut);

    /**
     *
     * @param lockKey
     */
    void unLock(String lockKey);

    /**
     *
     * @param lock
     */
    void unLock(Lock lock);
}
