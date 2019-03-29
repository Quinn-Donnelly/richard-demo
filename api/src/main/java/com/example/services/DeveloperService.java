package com.example.services;

import java.util.List;

import org.hibernate.Session;

import com.example.models.Developer;
import com.example.util.HibernateUtil;

public class DeveloperService {
	@SuppressWarnings("unchecked")
	public static List<Developer> getAll() {
		Session s = HibernateUtil.sf.openSession();
		return s.createQuery("from Developer").list();
	}
}
