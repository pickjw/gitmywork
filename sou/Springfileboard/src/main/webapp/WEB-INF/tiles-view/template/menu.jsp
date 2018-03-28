<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
     //http~/Springfileboard/board/list.do
	System.out.println("contextPath=>"+contextPath);
    //가상 경로를 지정해서 링크문자열을 연결
%>
<ul>
	<li><a href="<%=contextPath%>/board/list.do">목록</a></li>
	<li><a href="<%=contextPath%>/board/write.do">글쓰기</a></li>
</ul>