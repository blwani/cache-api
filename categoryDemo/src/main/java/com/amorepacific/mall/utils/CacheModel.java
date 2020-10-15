package com.amorepacific.mall.utils;

import com.amorepacific.mall.tuple.CacheTuple;

import lombok.Data;

import java.io.Serializable;

@Data
public class CacheModel implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8423959853505625822L;
	private String key;
    private CacheTuple value;
}