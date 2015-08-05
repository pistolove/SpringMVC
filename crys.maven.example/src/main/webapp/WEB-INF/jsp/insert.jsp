<%@ page trimDirectiveWhitespaces="true"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ page import="com.crys.model.User"%>

<html>

insert successfully!

<%
	User user = (User)request.getSession().getAttribute("user");
%>

Session取值：<%=user.getId()%>
<%=user.getName()%>
</html>