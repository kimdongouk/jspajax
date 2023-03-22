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
<tr><th>SEQ</th><th>TITLE</th><th>WRITER</th><th>CONTENT</th><th>REGDATE</th><th>CNT</th></tr>
	<tr>
		<td align="center">${vo.seq }</td>
		<td align="center">${vo.title }</td>
		<td align="center">${vo.writer }</td>
		<td align="center">${vo.content }</td>
		<td align="center">${vo.regDate }</td>
		<td align="center">${vo.cnt }</td>
	</tr>
</table>
</h2>
</body>
</html>