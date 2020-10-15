
package com.amorepacific.mall.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.amorepacific.mall.tuple.CacheTuple;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CacheManager
{
    private static int MAX_SIZE = 5;
    private static LinkedHashMap<String, Object> caches = new LinkedHashMap<String, Object>(MAX_SIZE,0.75f, true){
         /**
		 * 
		 */
		private static final long serialVersionUID = 2665317098409065709L;

			@Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size() > MAX_SIZE;
            }
    };

    public void setCache( CacheModel model) {
    	if (caches.containsKey(model.getKey())) {
            this.reCache(model);
        }
    	else {
    		caches.put(model.getKey(), model.getValue());
        }
    }
    
    public void removeCache( String name) {
        caches.remove(name);
    }
    
    public void reCache( CacheModel model) {
        caches.remove(model.getKey());
        caches.put(model.getKey(), model.getValue());
    }
    
    public CacheTuple getCache( String name) {
         CacheTuple value = (CacheTuple) caches.get(name);
        if (value != null) {
            caches.remove(name);
            caches.put(name, value);
        }
        List<String> keyList = CacheManager.caches.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
        keyList.stream().forEach(target -> log.info("################ Cache Key : " + target + "################\n"));
        return value;
    }
    
    public void removeCacheAll( String key) {
        List<String> keyList = caches.keySet().stream().filter(i -> i.startsWith(key)).collect(Collectors.toCollection(ArrayList::new));
        keyList.stream().forEach(target -> caches.remove(target));
    }
}