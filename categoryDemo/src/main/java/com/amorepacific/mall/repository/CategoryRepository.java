package com.amorepacific.mall.repository;

import com.amorepacific.mall.tuple.CategoryTuple;
import java.util.List;
import com.amorepacific.mall.criteria.CategoryCriteria;

public interface CategoryRepository
{
    int insert(CategoryCriteria categoryCriteria);
    
    int update(CategoryCriteria categoryCriteria);
    
    int delete(CategoryCriteria categoryCriteria);
    
    List<CategoryTuple> selectCategoryList();
    
    CategoryTuple selectCategory(Integer categoryId);
}