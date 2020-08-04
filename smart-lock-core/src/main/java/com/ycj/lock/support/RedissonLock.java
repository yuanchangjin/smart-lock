package com.ycj.lock.support;

import com.ycj.lock.Lock;
import com.ycj.lock.enums.LockType;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yuanchangjin
 * @Description:
 * @Date: 2020/8/4 下午7:43
 */
public class RedissonLock implements Lock {

    @Autowired
    private RedissonClient redissonClient;


    private static Map<Lock,RLock> lockCacheMap =new ConcurrentHashMap<>();

    @Override
    public Lock lock(String lockKey, long timeOut) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeOut, TimeUnit.SECONDS);
        lockCacheMap.put(this,lock);
        return this;
    }

    @Override
    public Lock lock(String lockKey, LockType lockType, long timeOut) {
        return null;
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

        RLock lock = redissonClient.getLock(lockKey);
        if (Objects.nonNull(lock)) {
            lock.unlock();
        }

    }

    @Override
    public void unLock(Lock lock) {
        RLock rLock =lockCacheMap.get(lock);
        rLock.unlock();
        lockCacheMap.remove(lock);

    }
}
