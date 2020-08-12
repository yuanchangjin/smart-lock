package com.ycj.lock.support;

import com.ycj.lock.Lock;
import com.ycj.lock.enums.LockType;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/8/4 下午7:43
 */
public class RedissonLock implements Lock {

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public Object lock(String lockKey, long timeOut) {
        RLock rLock =redissonClient.getLock(lockKey);
        rLock.lock(timeOut,TimeUnit.SECONDS);
        return rLock;
    }

    @Override
    public Object lock(String lockKey, LockType lockType, long timeOut) {
        if(LockType.READ_LOCK==lockType){
            RReadWriteLock rReadWriteLock =redissonClient.getReadWriteLock(lockKey);
            rReadWriteLock.expire(timeOut,TimeUnit.SECONDS);
            rReadWriteLock.readLock();
            return rReadWriteLock;
        }else if(LockType.WRITE_lOCK==lockType){
            RReadWriteLock rReadWriteLock =redissonClient.getReadWriteLock(lockKey);
            rReadWriteLock.expire(timeOut,TimeUnit.SECONDS);
            rReadWriteLock.writeLock();
            return rReadWriteLock;
        }else {
            return  lock(lockKey,timeOut);
        }
    }

    @Override
    public boolean tryLock(String lockKey, long timeOut) {
        return false;
    }

    @Override
    public boolean tryLock(String lockKey, LockType lockType, long timeOut) {
        return false;
    }

    @Override
    public void unLock(String lockKey) {

    }

    @Override
    public void unLock(Object lock) {

    }
}
