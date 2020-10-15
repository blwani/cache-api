package com.amorepacific.mall.tuple;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CacheTuple implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3884586386202351L;
	private ProductTuple productInfo;
    private List<ProductTuple> productListInfo;
    private List<CategoryTuple> categoryListInfo;
    private CategoryTuple categoryInfo;

}
