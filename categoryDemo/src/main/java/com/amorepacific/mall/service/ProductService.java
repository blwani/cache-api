package com.amorepacific.mall.service;

import java.util.List;

import com.amorepacific.mall.criteria.ProductCriteria;
import com.amorepacific.mall.tuple.ProductTuple;

public interface ProductService
{
    List<ProductTuple> getProductListInfo();
    
    List<ProductTuple> getProductListInfo(Integer categoryId);
    
    ProductTuple getProductInfo(Integer productId);
    
    int updateProductInfo(ProductCriteria productCriteria);
    
    int insertProductInfo(ProductCriteria productCriteria);
    
    int deleteProductInfo(ProductCriteria productCriteria);
}