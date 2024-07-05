<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>this is home page</h1>
	<% 
	    String name = (String) request.getAttribute("name"); 
	    List<String> friends = (List<String>) request.getAttribute("f");
	%>
	<h1>My name is <%= name %></h1>
	
	<% 
	    if (friends != null) {
	        for(String s : friends) { 
	%>
	    <h1><%= s %></h1>
	<% 
	        } 
	    } 
	%>
</body>
</html>
