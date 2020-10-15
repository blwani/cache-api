
package com.amorepacific.mall.cacheRepository;

import org.apache.commons.lang3.StringUtils;
import com.amorepacific.mall.utils.CacheModel;
import com.amorepacific.mall.tuple.CacheTuple;
import org.springframework.beans.factory.annotation.Autowired;
import com.amorepacific.mall.utils.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheRepository
{
    @Autowired
    CacheManager cacheManager;
    
    public void registCache( String key,  CacheTuple value) {
        CacheModel cacheModel = new CacheModel();
        cacheModel.setKey(key);
        cacheModel.setValue(value);
        if (StringUtils.isNotBlank(key)) {
            cacheManager.setCache(cacheModel);
        }
    }
    
    public void deleteCache( String key) {
        if (StringUtils.isNotBlank(key)) {
            cacheManager.removeCache(key);
        }
    }
    
    public void deleteAllCache( String key) {
        if (StringUtils.isNotBlank(key)) {
            cacheManager.removeCacheAll(key);
        }
    }
    
    public CacheTuple getCache( String key) {
        CacheTuple value = null;
        if (StringUtils.isNotBlank(key)) {
            value = cacheManager.getCache(key);
        }
        return value;
    }
}