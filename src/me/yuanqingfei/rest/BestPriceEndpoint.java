package me.yuanqingfei.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;

import me.yuanqingfei.pojo.BestPrice;
import me.yuanqingfei.service.PriceQuerable;

/**
 * where the rest webserivce live
 * 
 * @author aaron
 *
 */
@Component
@Path("/product")
public class BestPriceEndpoint {
	
	private List<PriceQuerable> suppliers;
	
	@Resource(name = "bestbuyInvoker")
	private PriceQuerable bestbuySupplier;
	
	@Resource(name = "walmartInvoker")
	private PriceQuerable walmartSupplier;
	
	@PostConstruct
	public void setupSuppliers(){
		suppliers = new ArrayList<PriceQuerable>();
		suppliers.add(bestbuySupplier);
		suppliers.add(walmartSupplier);
		
		System.out.println("suppliers: " + suppliers);
	}
	
	@GET
	@Path("/search")
	@Produces({MediaType.APPLICATION_JSON})
	@JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
	public BestPrice queryBest(@QueryParam("name") @NotNull String queryName) {
		
		if ("".equals(queryName.trim())) {
			return null;
		}
		
		// assume all supplier will use the same currency: CAD for simplicity for now.
		BestPrice result = new BestPrice();
		double lowestPrice = 1000000000000000D; // very large
		for(PriceQuerable supplier : suppliers){
			BestPrice bestPrice = supplier.queryPrice(queryName);
			if (bestPrice.getBestPrice().doubleValue() < lowestPrice){
				lowestPrice = bestPrice.getBestPrice().doubleValue();
				result = bestPrice;
			}
		}
				
		return result;
	}

}
