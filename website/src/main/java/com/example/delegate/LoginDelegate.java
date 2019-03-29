package com.example.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servlets.Delegate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginDelegate implements Delegate {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("quinn")) {
			System.out.println("Quinn logged in");
			req.getRequestDispatcher("static/manager.html").forward(req, res);
		} else if (username.equals("richard")) {
			req.getRequestDispatcher("static/emp.html").forward(req, res);;
		} else {
			res.sendError(401);
		}
	}

}
