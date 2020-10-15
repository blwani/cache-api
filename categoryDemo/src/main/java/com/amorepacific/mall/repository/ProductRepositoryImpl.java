
package com.amorepacific.mall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amorepacific.mall.criteria.ProductCriteria;
import com.amorepacific.mall.tuple.ProductTuple;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final String NAMESPACE = "ProductMapper.";
    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public List<ProductTuple> selectProductList() {
        return sqlSession.selectList(NAMESPACE+"selectProductList");
    }
    
    @Override
    public List<ProductTuple> selectProductList(Integer categoryId) {
        return sqlSession.selectList(NAMESPACE+"selectProductList", categoryId);
    }
    
    @Override
    public ProductTuple selectProduct( Integer productId) {
        return sqlSession.selectOne(NAMESPACE+"selectProduct",productId);
    }
    
    @Override
    public int delete(ProductCriteria productCriteria) {
        return sqlSession.insert(NAMESPACE+"delete", productCriteria);
    }
    
    @Override
    public int insert(ProductCriteria productCriteria) {
        return sqlSession.insert(NAMESPACE+"insert",productCriteria);
    }
    
    @Override
    public int update(ProductCriteria productCriteria) {
        return sqlSession.update(NAMESPACE+"update",productCriteria);
    }
}

