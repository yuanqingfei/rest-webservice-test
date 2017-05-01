package me.yuanqingfei.service;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


public class HttpUtils {
	
    public static HttpHeaders getHttpHeaders() {
        System.setProperty("http.keepAlive", "false");
        HttpHeaders requestHeaders = new HttpHeaders();
//        HttpAuthentication authHeader = new HttpBasicAuthentication(userName, password);
//        requestHeaders.setAuthorization(authHeader);
        requestHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return requestHeaders;
    }

}
