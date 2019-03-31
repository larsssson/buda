package com.example.demo.service;

import com.example.demo.model.CachedUser;
import net.sf.ehcache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.stereotype.Service;
import net.sf.ehcache.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {
//    private final Cache cache;
//    private final String CACHE_NAME = "userPerServiceCache";
    private ConcurrentHashMap<Integer,Integer> cache= new ConcurrentHashMap<>();

    @Autowired
    public CacheService() {
//        CacheManager cacheManager = CacheManager.getInstance();
//        this.cache = cacheManager.getCache(CACHE_NAME);
    }

    public void addToCache(int cacheId, int userId) {

//        cache.put(new Element(userId, cacheId));
        cache.put(userId,cacheId);
    }

    public Integer getServiceByUserIdInCache(int userId) {
//        if (cache.isKeyInCache(userId)) {
//            return Integer.parseInt(cache.get(userId).getObjectValue().toString());
        if(cache.containsKey(userId)){
            return cache.get(userId);
        } else {
            return null;
        }

    }
//
//    private services getCacheName(int cacheId) {
//        switch (cacheId) {
//        case 1:
//            return services.MAIN_MENU;
//        default:
//            throw new CacheException();
//        }
//    }


}