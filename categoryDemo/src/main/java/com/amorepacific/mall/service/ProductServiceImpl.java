package com.amorepacific.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amorepacific.mall.cacheRepository.CacheRepository;
import com.amorepacific.mall.criteria.ProductCriteria;
import com.amorepacific.mall.repository.ProductRepository;
import com.amorepacific.mall.tuple.CacheTuple;
import com.amorepacific.mall.tuple.ProductTuple;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CacheRepository cacheRepository;
    private static final String CacheNamePrefix = "product";
    private static final String DELIMETER = ":";
    
    
	/**
	 * [상품] 전체 상품 리스트 조회 
	 *
	 * @param Integer categoryId
	 * @returnList<ProductTuple>
	 */
    @Override
    public List<ProductTuple> getProductListInfo() {
    	
        List<ProductTuple> productList = null;
        
        String cacheKey = "list";
        
        CacheTuple value = cacheRepository.getCache(CacheNamePrefix+DELIMETER + cacheKey);
        
        if (value != null) {
        	
            productList = value.getProductListInfo();
            
            log.info("#############################################################################");
            log.info("#########################       Cache             ###########################");
            log.info("#############################################################################\n");
        }
        else {
            productList = productRepository.selectProductList();
            if (productList != null && productList.size() > 0) {
                 CacheTuple registValue = new CacheTuple();
                registValue.setProductListInfo(productList);
                cacheRepository.registCache(CacheNamePrefix+DELIMETER + cacheKey, registValue);
            }
            log.info("#############################################################################");
            log.info("#########################       DB             ##############################");
            log.info("#############################################################################\n");
        }
        return productList;
    }
    
	/**
	 * [상품] 카테고리별 상품 리스트 조회 
	 *
	 * @param Integer categoryId
	 * @returnList<ProductTuple>
	 */
    @Override
    public List<ProductTuple> getProductListInfo( Integer categoryId) {
    	
        List<ProductTuple> productList = null;
        
        String cacheKey = "ById" + categoryId;
        
        CacheTuple value = cacheRepository.getCache(CacheNamePrefix+DELIMETER + cacheKey);
        
        if (value != null) {
        	
            productList = value.getProductListInfo();
            
            log.info("#############################################################################");
            log.info("#########################       Cache             ###########################");
            log.info("#############################################################################\n");
        }
        else {
        	
            productList = productRepository.selectProductList(categoryId);
            
            if (productList != null && productList.size() > 0) {
                CacheTuple registValue = new CacheTuple();
                registValue.setProductListInfo(productList);
                cacheRepository.registCache(CacheNamePrefix+DELIMETER + cacheKey, registValue);
            }
            
            log.info("#############################################################################");
            log.info("#########################       DB             ##############################");
            log.info("#############################################################################\n");
        }
        return productList;
    }
    
	/**
	 * [상품] 단일 상품 정보 조회  
	 *
	 * @param  Integer productId
	 * @return ProductTuple
	 */
    @Override
    public ProductTuple getProductInfo( Integer productId) {
    	
        ProductTuple productInfo = null;
        
         String cacheKey = Integer.toString(productId);
         
         CacheTuple value = cacheRepository.getCache(CacheNamePrefix+DELIMETER + cacheKey);
         
        if (value != null) {
        	
            productInfo = value.getProductInfo();
            
            log.info("#############################################################################");
            log.info("#########################       Cache             ###########################");
            log.info("#############################################################################\n");
        }
        else {
            productInfo = productRepository.selectProduct(productId);
            
            if (productInfo != null) {
            	
                 CacheTuple registValue = new CacheTuple();
                registValue.setProductInfo(productInfo);
                cacheRepository.registCache(CacheNamePrefix+DELIMETER + cacheKey, registValue);
            }
            
            log.info("#############################################################################");
            log.info("#########################       DB             ##############################");
            log.info("#############################################################################\n");
        }
        return productInfo;
    }
	/**
	 * [상품] 수정  
	 *
	 * @param  ProductCriteria
	 * @return int
	 */
    @Override
    public int updateProductInfo( ProductCriteria productCriteria) {
    	
        int updateCnt = productRepository.update(productCriteria);
        if (updateCnt > 0) {
             String cacheKey = productCriteria.getProductNo();
            cacheRepository.deleteCache(CacheNamePrefix+DELIMETER + cacheKey);
        }
        return updateCnt;
    }
	/**
	 * [상품] 등록  
	 *
	 * @param  ProductCriteria
	 * @return int
	 */
    @Override
    public int insertProductInfo( ProductCriteria productCriteria) {
         int insertCnt = productRepository.insert(productCriteria);
        return insertCnt;
    }
	/**
	 * [상품] 삭제 
	 *
	 * @param  ProductCriteria
	 * @return int
	 */
    @Override
    public int deleteProductInfo( ProductCriteria productCriteria) {
        int deleteCnt = productRepository.delete(productCriteria);
        if (deleteCnt > 0) {
            if (productCriteria.getCategoryNo() != null) {
                 String cacheKey = productCriteria.getProductNo();
                cacheRepository.deleteCache(CacheNamePrefix+DELIMETER + cacheKey);
            }
            else {
                cacheRepository.deleteAllCache(CacheNamePrefix+DELIMETER);
            }
        }
        return deleteCnt;
    }
}