package com.example.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.models.Hello;
import com.example.servlets.Delegate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelloDelegate implements Delegate {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (!req.getMethod().equals("POST")) {
			res.sendError(405);
			return;
		}
		ObjectMapper om = new ObjectMapper();
		Hello msg = om.readValue(req.getReader(), Hello.class);
		Hello response = new Hello();
		response.setName("Hello " + msg.getName());
		res.setHeader("Content-Type", "applicaton/json");
		om.writeValue(res.getWriter(), response);
	}

}
