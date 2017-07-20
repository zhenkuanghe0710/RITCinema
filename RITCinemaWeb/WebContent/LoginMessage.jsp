<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
<head>
		<title>Login Message</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
		<div class="body">
				<p class="title">
				<font face="Arial" color="blue"><b>Message</b></font></p>
				<p class="content">
				 <font face="Arial">
				   <bean:write name="RITCinemaForm" property = "result" filter ="false"/><br><br>
	   
			<a href="./UserLogin.jsp">Back to Consumer</a><br><br>
			<a href="./AdminLogin.jsp">Back to Administrator</a></font>
		</div>
			
</body>

</html:html>