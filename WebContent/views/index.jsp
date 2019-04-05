<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SOLUTIONS</h1>
	<table border="1">
	  <thead>
	  	<tr>
	  	  <th scope="col">Created</th>
	  	  <th scope="col">Updated</th>
	  	  <th scope="col">Description</th>
	  	  <th scope="col">ExcerciseId</th>
	  	  <th scope="col">userId</th>
	  	</tr>
	  </thead>
	  <tbody>
	  <c:forEach var="solution" items="${solutions}">
	  	<tr>
	  		<td>${solution.getCreated()}</td>
	  		<td>${solution.getUpdated()}</td>
	  		<td>${solution.getDescription()}</td>
	  		<td>${solution.getExcerciseId()}</td>
	  		<td>${solution.userId()}</td>
	  	</tr>
	  </c:forEach>
	  </tbody>	  
	</table>
	
</body>
</html>