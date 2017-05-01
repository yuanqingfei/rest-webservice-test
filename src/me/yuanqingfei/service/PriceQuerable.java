package me.yuanqingfei.service;

import org.json.JSONException;

import me.yuanqingfei.pojo.BestPrice;

/**
 * get best price according to name from different suppliers
 * 
 * @author aaron
 *
 */
public interface PriceQuerable {

	BestPrice queryPrice(String name) ;
	
}
