package com.example.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5154004201694145794L;

	
	public void handleHome(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.getWriter().append("home");
	}
	
	public void callDelegate(String delegate, HttpServletRequest req, HttpServletResponse res) throws IOException {
		Delegate d = RequestDispatcher.getDelegate(delegate);
		if (d == null) {
			res.sendError(404);
			return;
		}
		
		d.process(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String delegateName = "";
		String uri = req.getRequestURI();	
		Integer secondSlash = uri.indexOf('/', 1);
		
		Boolean noPathAfterSecondSlash = secondSlash + 1 >= uri.length();
		
		if (secondSlash == -1 || noPathAfterSecondSlash) {
			delegateName = "";
			handleHome(req, res);
			return;
		}
		
		Integer thirdSlash = uri.indexOf('/', secondSlash + 1);
		
		if (thirdSlash == -1) {
			delegateName = uri.substring(secondSlash + 1, uri.length());
			callDelegate(delegateName, req, res);
			return;
		}
		
		delegateName = uri.substring(secondSlash + 1, thirdSlash);
		callDelegate(delegateName, req, res);
		return;
	}
}
