package com.amorepacific.mall.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amorepacific.mall.service.CategoryService;
import com.amorepacific.mall.service.ProductService;
import com.amorepacific.mall.tuple.CategoryTuple;
import com.amorepacific.mall.tuple.ProductTuple;

@Controller
public class ViewController
{
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping({ "/view/product/{productId}" })
    public String update(Model model, @PathVariable("productId") Integer id) {
        ProductTuple product = productService.getProductInfo(id);
        String returnView = "productInsert";
        if (product != null) {
            returnView = "productUpdate";
            model.addAttribute("productInfo", product);
        }
        return returnView;
    }
    
    @GetMapping({ "/view/product" })
    public String update(Model model) {
        return "productInsert";
    }
    
    @GetMapping({ "/view/category/{category}" })
    public String categoryUpdate(Model model, @PathVariable("category") Integer id) {
        CategoryTuple category = categoryService.getCategoryInfo(id);
        String returnView = "categoryInsert";
        if (category != null) {
            returnView = "categoryUpdate";
            model.addAttribute("categoryInfo", category);
        }
        return returnView;
    }
    
    @GetMapping({ "/view/category" })
    public String categoryUpdate(Model model) {
        return "categoryInsert";
    }
}