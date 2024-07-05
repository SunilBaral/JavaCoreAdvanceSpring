<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>file uploaded result</title>
</head>
<body>
	<h1>${msg }</h1>
	<img alt="imagee" src="<c:url value="/resources/image/${image }"/>">
	
</body>
</html>