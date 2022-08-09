<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- using action is better than using java code in jsp --> 
  
<%@ include file="page3.jsp" %>    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>Hi, this is page1</h1>
		
		<jsp:include page="page2.jsp"></jsp:include>
		
	</body>
	
</html>