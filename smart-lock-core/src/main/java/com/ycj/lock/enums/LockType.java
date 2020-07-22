package com.ycj.lock.enums;

/**
 *支持的锁类型
 * @author changjin.yuan
 * @Date 2019/10/10 14:12
 */
public enum LockType {

    /**
     * 读锁
     */
    READ_LOCK,

    /**
     * 写锁
     */
    WRITE_lOCK,

    /**
     * 公平锁
     */
    FAIR_LOCK,

    /**
     * 可重入锁
     */
    REENTRANT_LOCK;


}
