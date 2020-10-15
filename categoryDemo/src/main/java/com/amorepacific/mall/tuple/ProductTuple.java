
package com.amorepacific.mall.tuple;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductTuple implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 555255921099757775L;
	
	private Integer productNo;
    private String brandName;
    private String productName;
    private Integer productPrice;
    private Integer categoryNo;
    private Integer parentNo;
    private String categoryFullName;
    private String categoryName;

}