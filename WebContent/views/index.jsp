<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Database-CRUD</title>
</head>
<style>
<%@ include file="css/style.css"%>
</style>
<body>
<div>
<jsp:include page="header.jsp"/>
</div>
<br>
<br>
<center>
<h1>${title}</h1>
	<table border="1">
	  <thead>
	  	<tr>
	  	  <th scope="col">Created</th>
	  	  <th scope="col">Updated</th>
	  	  <th scope="col">Description</th>
	  	  <th scope="col">Excercise Id</th>
	  	  <th scope="col">user Id</th>
	  	</tr>
	  </thead>
	  <tbody>
	  <c:forEach var="solution" items="${solutions}">
	  	<tr>
	  		<td>${solution.getCreatedAsString()}</td>
	  		<td>${solution.getUpdatedAsString()}</td>
	  		<td>${solution.getDescription()}</td>
	  		<td>${solution.getExercise_id()}</td>
	  		<td>${solution.getUsers_id()}</td>
	  	</tr>
	  </c:forEach>
	  </tbody>	  
	</table>
</center>	
</body>
</html>