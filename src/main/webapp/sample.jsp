<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mvcboard.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.mvcboard.mybatis.SqlSessionManager"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample.jsp</title>
</head>
<body>
<%
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession();
%>
<h1>boardList - BoardVO</h1>
<%
	List<BoardVO> boardList	= sqlSession.selectList("sample.getBoardListVO");
%>
<% for(BoardVO vo : boardList) {%>
<%= vo  %><br>
<%} %>

<h1>boardList - HashMap</h1>
<%
	List<HashMap> boardListMap	= sqlSession.selectList("sample.getBoardListMap");
%>
<% for(HashMap vo : boardListMap) {%>
<%= vo  %><br>
<%} %>

<h1>board - BoardVO</h1>
<%
	BoardVO vo = sqlSession.selectOne("sample.getBoardVO", 1);
%>
<%= vo  %><br>

<h1>board - HashMap</h1>
<%
	HashMap voMap = sqlSession.selectOne("sample.getBoardMap", 2);
%>
<%= voMap  %><br>

<h1>boardSearch - BoardVO</h1>
<%
	List<BoardVO> boardSearch = sqlSession.selectList("sample.getBoardSearch", "1");
%>
<% for(BoardVO vos : boardSearch) {%>
<%= vos %><br>
<%} %>

<h1>boardSearchMap - BoardVO</h1>
<%
	Map<String, String> map = new HashMap<>();
	map.put("title","2");
	map.put("writer","writer2");
	List<BoardVO> boardSearchMap = sqlSession.selectList("sample.getBoardSearchMap", map);
%>
<% for(BoardVO vos : boardSearchMap) {%>
<%= vos %><br>
<%} %>
</body>
</html>