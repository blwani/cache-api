package com.amorepacific.mall.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.amorepacific.mall.criteria.CategoryCriteria;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.amorepacific.mall.tuple.CategoryTuple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.amorepacific.mall.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category" )
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
	/**
	 * [카테고리] 리스트 조회 
	 *
	 * @param 
	 * @return List<CategoryTuple>
	 */
    @GetMapping("/list" )
    public List<CategoryTuple> categoryList() {
         List<CategoryTuple> category = categoryService.getCategoryListInfo();
        return category;
    }
	/**
	 * [카테고리] 단일 카테고리 정보 조회  
	 *
	 * @param  Integer categoryId
	 * @return CategoryTuple
	 */
    @GetMapping("/{categoryId}")
    public CategoryTuple productByCategoryId(@PathVariable("categoryId") Integer id) {
         CategoryTuple category = categoryService.getCategoryInfo(id);
        return category;
    }
	/**
	 * [카테고리] 수정  
	 *
	 * @param  CategoryCriteria
	 * @return int
	 */
    @PostMapping("/update")
    public int productUpdate(@RequestBody CategoryCriteria categoryCriteria) {
         int update = categoryService.updateCategoryInfo(categoryCriteria);
        return update;
    }
	/**
	 * [카테고리] 등록  
	 *
	 * @param  CategoryCriteria
	 * @return int
	 */
    @PostMapping( "/insert")
    public int productInsert(@RequestBody CategoryCriteria categoryCriteria) {
         int insert = categoryService.insertCategoryInfo(categoryCriteria);
        return insert;
    }
	/**
	 * [카테고리] 삭제 
	 *
	 * @param  CategoryCriteria
	 * @return int
	 */
    @PostMapping("/delete")
    public int productDelete(@RequestBody CategoryCriteria categoryCriteria) {
         int insert = categoryService.deleteCategoryInfo(categoryCriteria);
        return insert;
    }
}