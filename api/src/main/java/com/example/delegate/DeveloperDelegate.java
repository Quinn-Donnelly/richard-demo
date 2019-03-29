package com.example.delegate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Developer;
import com.example.services.DeveloperService;
import com.example.servlets.Delegate;
import com.example.util.HibernateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeveloperDelegate implements Delegate {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (req.getMethod().equals("GET")) {
			res.setHeader("Content-Type", "application/json");		
			new ObjectMapper().writeValue(res.getWriter(), DeveloperService.getAll());
		} else if (req.getMethod().equals("POST")) {
			ObjectMapper om = new ObjectMapper();
			Developer sentDev = (Developer) om.readValue(req.getReader(), Developer.class);
			Session s = HibernateUtil.sf.openSession();
			Transaction t = s.beginTransaction();
			s.save(sentDev);
			t.commit();
			res.setStatus(201);
		}
	}

}
