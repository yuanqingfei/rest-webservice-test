package me.yuanqingfei.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import me.yuanqingfei.pojo.BestPrice;
import me.yuanqingfei.pojo.Currency;
import me.yuanqingfei.pojo.Store;

/**
 * Call Best Buy web service
 * https://api.bestbuy.com/v1/products(search=ipad)?&sort=salePrice.asc&format=json&show=name,salePrice&apiKey=pfe9fpy68yg28hvvma49sc89
 * 
 * @author aaron
 *
 */
@Component
public class BestbuyInvoker implements PriceQuerable {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public BestPrice queryPrice(String name) {

		String restString = "https://api.bestbuy.com/v1/products(search=" + name
				+ ")?&sort=salePrice.asc&format=json&show=name,salePrice&apiKey=pfe9fpy68yg28hvvma49sc89";

		HttpEntity<Object> requestEntity = new HttpEntity<Object>(HttpUtils.getHttpHeaders());
		ResponseEntity<String> response = restTemplate.exchange(restString, HttpMethod.GET, requestEntity,
				String.class);

		BestPrice bestPrice = new BestPrice();
		bestPrice.setCurrency(Currency.CAD);
		bestPrice.setLocation(Store.Bestbuy);

		try {
			// System.out.println("Walmart: " + response.getBody());
			JSONObject resultJson = new JSONObject(response.getBody());
			if (resultJson != null) {
				JSONArray productArray = resultJson.getJSONArray("products");
				if (productArray.length() > 0) {
					JSONObject first = (JSONObject) productArray.get(0);
					if (first != null) {
						bestPrice.setProductName(first.getString("name"));
						bestPrice.setBestPrice(first.getDouble("salePrice"));
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return bestPrice;
	}

}
