# smart-lock
基于spring @EnableXXX的实现原理，抽象分布式锁的解决方案，提供业务上对分布式锁的应用。不做锁的具体实现，锁的实现可自定义也可用其他开源组件如redisson、ZK、数据库等等


## Quick start

## Maven

<dependency>
		  <groupId>com.ycj</groupId>
		  <artifactId>smart-lock-core</artifactId>
		  <version>1.0-SNAPSHOT</version>
	  </dependency>
    
## Java

1、实例化具体实现的Lock
 @Bean
    public Lock redissonLock(){
        Lock lock = new RedissonLock();
        return lock;
    }
    
2、实例化LockManager
 @Bean
    public LockManager lockManager(){
        LockManager lockManager = new RedissonLockManager(redissonLock());
        return lockManager;
    }
    
3、@Configuration配置类加@EnableLock注解

4、具体方法上加@Lock(key = "lock",lockType = LockType.READ_LOCK,timeOut = 5L)如：

 public User getUser(String name){
      .....
      .....
    }



