package com.amorepacific.mall.service;

import com.amorepacific.mall.criteria.CategoryCriteria;
import com.amorepacific.mall.tuple.CategoryTuple;
import java.util.List;

public interface CategoryService
{
    List<CategoryTuple> getCategoryListInfo();
    
    CategoryTuple getCategoryInfo(Integer categoryId);
    
    int updateCategoryInfo(CategoryCriteria categoryCriterias);
    
    int insertCategoryInfo(CategoryCriteria categoryCriteria);
    
    int deleteCategoryInfo(CategoryCriteria categoryCriteria);
}