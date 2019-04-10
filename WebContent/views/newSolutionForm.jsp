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
<%@include file="css/style.css"%>
</style>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<br>
	<br>
	<center>
		<h1>NEW SOLUTION</h1>
		<form action="" method="post">
 		<label>Description 
 			<input type="text" name="description"> 
 		</label> 
 		<label>Exercise id 
 			<input type="text" name="exercise_id"> 
 		</label> 
 		<label>User id 
 			<input type="text" name="user_id"> 
 		</label> 
 		<input type="submit" value="Send"> 
 	</form> 
		

	</center>
</body>
</html>