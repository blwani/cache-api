package com.amorepacific.mall.criteria;

import lombok.Data;

@Data
public class ProductCriteria
{
    private String productNo;
    private String productName;
    private Integer productPrice;
    private String brandName;
    private Integer categoryNo;

}