
package com.amorepacific.mall.repository;

import com.amorepacific.mall.tuple.ProductTuple;
import java.util.List;
import com.amorepacific.mall.criteria.ProductCriteria;

public interface ProductRepository
{
    int insert(ProductCriteria productCriteria);
    
    int update(ProductCriteria productCriteria);
    
    int delete(ProductCriteria productCriteria);
    
    List<ProductTuple> selectProductList();
    
    List<ProductTuple> selectProductList(Integer productId);
    
    ProductTuple selectProduct(Integer id);
}