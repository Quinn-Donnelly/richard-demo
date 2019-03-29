package com.example.servlets;

import java.util.HashMap;
import java.util.Map;

import com.example.delegate.DeveloperDelegate;

public class RequestDispatcher {
	private static RequestDispatcher instance;
	private static Map<String, Delegate> delegates;
	
	private RequestDispatcher() {
		delegates = new HashMap<>();
		delegates.put("developer", new DeveloperDelegate());
	}
	
	public static Delegate getDelegate(String delegate) {
		if (instance == null) {
			instance = new RequestDispatcher();
		}
		
		return delegates.get(delegate);
	}
	
	public static String str;
}
