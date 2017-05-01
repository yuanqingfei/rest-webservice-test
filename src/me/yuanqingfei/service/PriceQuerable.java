package me.yuanqingfei.service;

import me.yuanqingfei.pojo.BestPrice;

/**
 * get best price according to name
 * 
 * @author aaron
 *
 */
public interface PriceQuerable {

	BestPrice queryPrice(String name);
	
}
