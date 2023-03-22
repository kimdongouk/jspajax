<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script type="text/javascript">

function getMemberJson(){
	let param = {id:'hong'};
	$.ajax({
		type: 'GET',
		url: 'getMemberJson.do',
		data: param,
		dataType: 'json',
		success: function(response){
			// 내가 할일
			console.log(response);
			let li = '<li>ID : '+ response['id'] +  '</li>\n';
			li += '<li>NAME : '+ response['name'] +  '</li>';
			console.log(li);
			$('#area').html(li);
		},
		error: function(request, status, error) {
			console.log(request, status, error);
		}
	});
	
}
	
$(function(){
	$('#btn').on('click',function(){
		getMemberJson();
	});
});
	
</script>
</head>
<body>
<h1>getMember</h1>
<h2>
<a href="index.do">INDEX</a><hr>
<ul>
	<li>ID : ${dto.id}</li>
	<li>NAME : ${dto.name}</li>
</ul>
<button type="button" id="btn">getMember</button>
<ul id="area">
	
</ul>
</h2>
</body>
</html>