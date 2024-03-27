//package com.clip.gwr.conf;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisKeyExpirationScheduler {
//	
//	@Autowired
//    private RedisTemplate<String, Integer> redisTemplate;
//
//    public void setKeyWithExpiration(String key, int value, long expirationTimeInSeconds) {
//        redisTemplate.opsForValue().set(key, value, expirationTimeInSeconds, TimeUnit.SECONDS);
//    }
//
//    public void deleteKey(String key) {
//        redisTemplate.delete(key);
//    }
//}
