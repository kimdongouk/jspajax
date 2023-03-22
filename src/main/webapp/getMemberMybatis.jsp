<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>

</head>
<body>
<h1>getMember</h1>
<h2>
<table border="1">
<tr><th>ID</th><th>PASS</th><th>NAME</th><th>REGIDATE</th><th>EMAIL</th><th>TEL</th></tr>
	<tr>
		<td align="center">${vo.id }</td>
		<td align="center">${vo.pass }</td>
		<td align="center">${vo.name }</td>
		<td align="center">${vo.regidate }</td>
		<td align="center">${vo.email }</td>
		<td align="center">${vo.tel }</td>
	</tr>
</table>
</h2>
</body>
</html>