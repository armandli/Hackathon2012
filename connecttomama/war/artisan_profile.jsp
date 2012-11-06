<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <body>
  <p>
<%
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	//String mamaName = request.getParameter("name");
	String mamaName = "mama";
	Query query = new Query(mamaName);
	%> '${ fn:escapeXml(mamaName); }' <% 
%>
  </p>
  <p>Story: 
<%
	List<Entity> mamas = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(1));
	if (!mamas.isEmpty()){
		String storyContent = mamas.get(0).getProperty("mamaStory").toString();
		%> '${ fn:escapeXml(storyContent) }' <% 
	}
%>
  </p>
  </body>
</html>