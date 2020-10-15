package com.amorepacific.mall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amorepacific.mall.criteria.CategoryCriteria;
import com.amorepacific.mall.tuple.CategoryTuple;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository
{
    private static final String NAMESPACE = "CategoryMapper.";
    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public List<CategoryTuple> selectCategoryList() {
        return sqlSession.selectList(NAMESPACE+"selectCategoryList");
    }
    
    @Override
    public CategoryTuple selectCategory(Integer categoryId) {
        return sqlSession.selectOne(NAMESPACE+"selectCategory",categoryId);
    }
    
    @Override
    public int insert(CategoryCriteria categoryCriteria) {
        return sqlSession.insert(NAMESPACE+"insert", categoryCriteria);
    }
    
    @Override
    public int update(CategoryCriteria categoryCriteria) {
        return sqlSession.update(NAMESPACE+"update", categoryCriteria);
    }
    
    @Override
    public int delete(CategoryCriteria categoryCriteria) {
        return sqlSession.update(NAMESPACE+"delete", categoryCriteria);
    }
}


