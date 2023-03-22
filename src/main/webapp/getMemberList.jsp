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
		url: 'getMemberListJson.do',
		data: param,
		dataType: 'json',
		success: function(list){
			// 내가 할일
			console.log(list);
			let td;
			for(var dto in list){
				var d = list[dto];
				td += "<tr><td>ID :" +d.id+"</td>";
				td += "<td>pass :" +d.pass+"</td>";
				td += "<td>Name :" +d.name+"</td>";
				td += "<td>regidate :" +d.regidate+"</td>";
				td += "<td>email :" +d.email+"</td>";
				td += "<td>tel :" +d.tel+"</td></tr>";
				
			}
			$('#area').html(td);
			
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
<table border="1">
	<tr>
		<td>ID : ${dto.id}</td>
		<td>pass : ${dto.pass}</td>
		<td>Name : ${dto.name}</td>
		<td>regidate : ${dto.regidate}</td>
		<td>email : ${dto.email}</td>
		<td>tel : ${dto.tel}</td>
	</tr>
</table>
<button type="button" id="btn">getMemberList</button>
<table id="area">

</table>
</h2>
</body>
</html>