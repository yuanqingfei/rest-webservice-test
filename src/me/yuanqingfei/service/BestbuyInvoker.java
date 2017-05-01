package me.yuanqingfei.service;

import org.springframework.stereotype.Component;

import me.yuanqingfei.pojo.BestPrice;
import me.yuanqingfei.pojo.Currency;
import me.yuanqingfei.pojo.Store;

@Component
public class BestbuyInvoker implements PriceQuerable {

	@Override
	public BestPrice queryPrice(String name) {
		
		// will use real Bestbuy API 
		BestPrice bestbuyPrice = new BestPrice();
		bestbuyPrice.setBestPrice(12.3);
		bestbuyPrice.setCurrency(Currency.CAD);
		bestbuyPrice.setLocation(Store.Bestbuy);
		bestbuyPrice.setProductName("bestbuyProd");
		return bestbuyPrice;
	}

}
