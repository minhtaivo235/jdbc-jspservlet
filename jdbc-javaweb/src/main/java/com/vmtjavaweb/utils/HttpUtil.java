package com.vmtjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

// lớp utils chứa các lib.. giống như 1 tiện ích
public class HttpUtil { // chuyển json trong api về giống với model 
	private String value;
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass){ // kiểu trả về T chính là Model
		try {		
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static HttpUtil of(BufferedReader reader) {
		StringBuffer sb = new StringBuffer();
		try {
			String line;
			while((line = reader.readLine()) != null) { // chuyển json thành String 
				sb.append(line);
			}			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
}
