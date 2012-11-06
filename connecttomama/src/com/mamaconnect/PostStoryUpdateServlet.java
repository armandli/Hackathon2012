package com.mamaconnect;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PostStoryUpdateServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String updateContent = req.getParameter("content");
		String mamaName = req.getParameter("name");
		
		Entity updateEntity = new Entity("", mamaName);
		updateEntity.setProperty("content", updateContent);
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(updateEntity);
	}
}
