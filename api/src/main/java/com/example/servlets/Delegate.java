package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Delegate {
	void process(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
