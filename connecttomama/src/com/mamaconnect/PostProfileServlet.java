package com.mamaconnect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.logging.Logger;


@SuppressWarnings("serial")
public class PostProfileServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mamaName = req.getParameter("name");
		String mamaStory = req.getParameter("story");
		String mamaPic = req.getParameter("profilepic");
		
		Entity profileInfo = new Entity(mamaName);
		profileInfo.setProperty("mamaName", mamaName);
		profileInfo.setProperty("mamaStory", mamaStory);
		profileInfo.setProperty("profilepic", mamaPic);
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(profileInfo);
		
		//resp.sendRedirect("/hello.jsp");
	}
}
