<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>

	<body>
	
		<jsp:useBean id="student" class="com.javabeans.beans.Student">
	
			<jsp:setProperty name="student" property="firstName" value="Merve" />
			<jsp:setProperty name="student" property="lastName" value="Yılmaz" />
			<jsp:setProperty name="student" property="email" value="yilmaz.67@outlook.com" />
	
		</jsp:useBean>
	
		<p>
			Student firstName:
			<jsp:getProperty property="firstName" name="student" />
		</p>
		<p>
			Student lastName:
			<jsp:getProperty property="lastName" name="student" />
		</p>
		<p>	
			Student email:
			<jsp:getProperty property="email" name="student" />
		</p>
		
			
		
	</body>
		
</html>