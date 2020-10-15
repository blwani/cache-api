
package com.amorepacific.mall.tuple;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonResponseTuple implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8738961875300469756L;
	private String resultCode;
    private String resultMessage;
}
