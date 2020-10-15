package com.amorepacific.mall.tuple;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CategoryTuple implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 156130472398192245L;
	private Integer categoryNo;
    private String categoryName;
    private Integer parentNo;
    private Integer depth;
    private List<ProductTuple> productList;
    private String parentName;
    private String categoryFullName;
    
}