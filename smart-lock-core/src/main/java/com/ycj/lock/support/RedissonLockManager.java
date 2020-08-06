package com.ycj.lock.support;

import com.ycj.lock.Lock;
import com.ycj.lock.LockManager;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/8/4 下午7:37
 */
public class RedissonLockManager implements LockManager {


    private  Lock lock;


    public RedissonLockManager(Lock lock){

        this.lock=lock;

    }

    @Override
    public Lock getLock() {
        return this.lock;
    }
}
