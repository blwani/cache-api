
package com.amorepacific.mall.criteria;

import lombok.Data;

@Data
public class CategoryCriteria
{
    private Integer categoryNo;
    private String categoryName;
    private Integer parentNo;
    private Integer depth;
    
}