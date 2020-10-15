package com.amorepacific.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amorepacific.mall.cacheRepository.CacheRepository;
import com.amorepacific.mall.criteria.CategoryCriteria;
import com.amorepacific.mall.repository.CategoryRepository;
import com.amorepacific.mall.tuple.CacheTuple;
import com.amorepacific.mall.tuple.CategoryTuple;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CacheRepository cacheRepository;
    
    private static final String CacheNamePrefix = "category";
    private static final String DELIMETER = ":";
	
    
    /**
	 * [카테고리] 리스트 조회 
	 *
	 * @param 
	 * @return List<CategoryTuple>
	 */
    @Override
    public List<CategoryTuple> getCategoryListInfo() {
    	
        List<CategoryTuple> categoryList = null;
        
         String cacheKey = "list";
         
         CacheTuple value = cacheRepository.getCache(CacheNamePrefix+DELIMETER + cacheKey);
         
        if (value != null) {
        	
            categoryList = value.getCategoryListInfo();
            
            log.info("#############################################################################");
            log.info("#########################       Cache             ###########################");
            log.info("#############################################################################\n");
        }
        else {
            categoryList = categoryRepository.selectCategoryList();
            
            if (categoryList != null && categoryList.size() > 0) {
            	
                 CacheTuple registValue = new CacheTuple();
                registValue.setCategoryListInfo(categoryList);
                cacheRepository.registCache(CacheNamePrefix+DELIMETER + cacheKey, registValue);
                
            }
            
            log.info("#############################################################################");
            log.info("#########################       DB             ##############################");
            log.info("#############################################################################\n");
        }
        return categoryList;
    }
    
    
	/**
	 * [카테고리] 단일 카테고리 정보 조회  
	 *
	 * @param  Integer categoryId
	 * @return CategoryTuple
	 */
    @Override
    public CategoryTuple getCategoryInfo( Integer categoryId) {
    	
        CategoryTuple category = null;
        String cacheKey = Integer.toString(categoryId);
        CacheTuple value = cacheRepository.getCache(CacheNamePrefix+DELIMETER + cacheKey);
        
        if (value != null) {
        	
            category = value.getCategoryInfo();
            log.info("#############################################################################");
            log.info("#########################       Cache             ###########################");
            log.info("#############################################################################\n");
        }
        else {
            category = categoryRepository.selectCategory(categoryId);
            if (category != null) {
                CacheTuple registValue = new CacheTuple();
                registValue.setCategoryInfo(category);
                cacheRepository.registCache(CacheNamePrefix+DELIMETER + cacheKey, registValue);
            }
            log.info("#############################################################################");
            log.info("#########################       DB             ##############################");
            log.info("#############################################################################\n");
        }
        return category;
    }
    
	/**
	 * [카테고리] 수정  
	 *
	 * @param  CategoryCriteria
	 * @return int
	 */
    @Override
    public int updateCategoryInfo( CategoryCriteria categoryCriteria) {
    	
        int updateCnt = categoryRepository.update(categoryCriteria);
        
        if (updateCnt > 0) {
            String cacheKey = Integer.toString(categoryCriteria.getCategoryNo());
            cacheRepository.deleteCache(CacheNamePrefix+DELIMETER + cacheKey);
        }
        return updateCnt;
    }
    
	/**
	 * [카테고리] 등록  
	 *
	 * @param  CategoryCriteria
	 * @return int
	 */
    @Override
    public int insertCategoryInfo( CategoryCriteria categoryCriteria) {
         int insertCnt = categoryRepository.insert(categoryCriteria);
        return insertCnt;
    }
    
	/**
	 * [카테고리] 삭제 
	 *
	 * @param  CategoryCriteria
	 * @return int
	 */
    @Override
    public int deleteCategoryInfo( CategoryCriteria categoryCriteria) {
        int deleteCnt = categoryRepository.delete(categoryCriteria);
        if (deleteCnt > 0) {
            if (categoryCriteria.getCategoryNo() != null) {
                 String cacheKey = Integer.toString(categoryCriteria.getCategoryNo());
                cacheRepository.deleteCache(CacheNamePrefix+DELIMETER + cacheKey);
            }
            else {
                cacheRepository.deleteAllCache(CacheNamePrefix+DELIMETER );
            }
        }
        return deleteCnt;
    }
}