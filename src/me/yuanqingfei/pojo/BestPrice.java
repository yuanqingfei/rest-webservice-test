package me.yuanqingfei.pojo;

/**
 * represent the lowest price from Walmart and Bestbuy.
 * 
 * @author aaron
 *
 */
public class BestPrice {
	
	private String productName;
	
	private Double bestPrice;
	
	private Currency currency;
	
	private Store location;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(Double bestPrice) {
		this.bestPrice = bestPrice;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Store getLocation() {
		return location;
	}

	public void setLocation(Store location) {
		this.location = location;
	}
	
	

}
