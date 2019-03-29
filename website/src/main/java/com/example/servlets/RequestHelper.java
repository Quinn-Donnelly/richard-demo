package com.example.servlets;

import java.util.HashMap;
import java.util.Map;

import com.example.delegate.HelloDelegate;
import com.example.delegate.LoginDelegate;

public class RequestHelper {
	private static RequestHelper instance;
	private static Map<String, Delegate> delegates;
	
	private RequestHelper() {
		delegates = new HashMap<>();
		delegates.put("login", new LoginDelegate());
		delegates.put("hello", new HelloDelegate());
	}
	
	public static Delegate getDelegate(String delegate) {
		if (instance == null) {
			instance = new RequestHelper();
		}
		
		return delegates.get(delegate);
	}
}
