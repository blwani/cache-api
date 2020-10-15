package com.amorepacific.mall.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.amorepacific.mall.criteria.ProductCriteria;
import org.springframework.web.bind.annotation.GetMapping;
import com.amorepacific.mall.tuple.ProductTuple;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.amorepacific.mall.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/product" )
public class ProductController {
    @Autowired
    private ProductService productService;
    
	/**
	 * [상품] 카테고리별 상품 리스트 조회 
	 *
	 * @param Integer categoryId
	 * @returnList<ProductTuple>
	 */
    @GetMapping("/list/{categoryId}")
    public List<ProductTuple> productServiceList(@PathVariable("categoryId")  Integer id) {
         List<ProductTuple> product = productService.getProductListInfo(id);
        return product;
    }
	/**
	 * [상품] 단일 상품 정보 조회  
	 *
	 * @param  Integer productId
	 * @return ProductTuple
	 */
    @GetMapping("/{productId}" )
    public ProductTuple productByCategoryId(@PathVariable("productId")  Integer id) {
         ProductTuple product = productService.getProductInfo(id);
        return product;
    }
    
	/**
	 * [상품] 수정  
	 *
	 * @param  ProductCriteria
	 * @return int
	 */
    @PostMapping("/update" )
    public int productUpdate(@RequestBody ProductCriteria productCriteria) {
         int update = productService.updateProductInfo(productCriteria);
        return update;
    }
    
	/**
	 * [상품] 등록  
	 *
	 * @param  ProductCriteria
	 * @return int
	 */
    @PostMapping("/insert")
    public int productInsert(@RequestBody ProductCriteria productCriteria) {
         int insert = productService.insertProductInfo(productCriteria);
        return insert;
    }
    
	/**
	 * [상품] 삭제 
	 *
	 * @param  ProductCriteria
	 * @return int
	 */
    @PostMapping("/delete")
    public int productDelete(@RequestBody ProductCriteria productCriteria) {
         int insert = productService.deleteProductInfo(productCriteria);
        return insert;
    }
}