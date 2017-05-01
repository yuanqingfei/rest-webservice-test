package me.yuanqingfei.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import org.glassfish.jersey.server.ServerProperties;


/**
 * 
 * Jersey configuration for the whole rest web service.
 * 
 * @author aaron
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(BestPriceEndpoint.class);
	    property(ServletProperties.FILTER_FORWARD_ON_404, true);
	    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}

}
