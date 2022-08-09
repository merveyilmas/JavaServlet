<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<!-- Servlet Class -->
		<%! 
			public String sayHello(){
				return "Hello from JSP";
			}
		%>
		<br/>
		<!-- Service Method -->
		<%= 
			//printWriter.print(sayHello());
			sayHello() 
		
		%>
		<br/>
		<%  //equal things
			out.print(sayHello());
		out.print("<br/>");
			response.getWriter().print(sayHello());
		%>
		
		
	</body>
	
</html>