<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.time.LocalDateTime, java.time.format.DateTimeFormatter" %> <!-- Add import statement for LocalDateTime -->
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Page</title>
</head>
<body>
    <%
     /*    String name = (String)request.getAttribute("name");  */
        LocalDateTime time = (LocalDateTime)request.getAttribute("time");
        
        // Convert LocalDateTime to string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = time.format(formatter); 
    %>

    <h1>Hello, my name is <%-- <%= name %> --%> ${name}</h1>
    <h2>This is the current time: <%= formattedTime %></h2>
    <hr>
    
    <c:forEach var="item" items="${num }">
    	<h1>${item }</h1>
    </c:forEach>
    
</body>
</html>
