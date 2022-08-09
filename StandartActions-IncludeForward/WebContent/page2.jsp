<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<h1>Hi, from page 2.</h1>
		
		<%= request.getParameter("param1") %>
		
		<!--<jsp:include page="page3.jsp"></jsp:include>-->
		
		<%-- <jsp:forward page="page3.jsp"></jsp:forward> --%>
	
	</body>
	
</html>