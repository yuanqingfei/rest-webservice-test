package me.yuanqingfei.service;

import org.springframework.stereotype.Component;

import me.yuanqingfei.pojo.BestPrice;
import me.yuanqingfei.pojo.Currency;
import me.yuanqingfei.pojo.Store;

@Component
public class WalmartInvoker implements PriceQuerable{

	@Override
	public BestPrice queryPrice(String name) {
		// will use real Walmart API 
		BestPrice bestbuyPrice = new BestPrice();
		bestbuyPrice.setBestPrice(12.1);
		bestbuyPrice.setCurrency(Currency.CAD);
		bestbuyPrice.setLocation(Store.Walmart);
		bestbuyPrice.setProductName("walmartProd");
		return bestbuyPrice;
	}

}
