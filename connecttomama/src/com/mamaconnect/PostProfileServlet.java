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


@SuppressWarnings("serial")
public class PostProfileServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String mamaName = req.getParameter("name");
		String mamaStory = req.getParameter("story");
		//TODO: take images as string and decode it
		//TODO: generate a unique story entry identifier to identify all mama entries for search purpose
		
		Key mamaKey = KeyFactory.createKey("profilesKeys", mamaName);
		Entity profileInfo = new Entity("profileData", mamaKey);
		profileInfo.setProperty("mamaName", mamaName);
		profileInfo.setProperty("mamaStory", mamaStory);
		//TODO: fill in the rest
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(profileInfo);
	}
}
