<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
<head>
		<title>SendMail Message</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
		<div class="body">
				<p class="title">
				<font face="Arial" color="gray"><b>Message</b></font></p>
				<p class="content">
				 <font face="Arial">
				   <bean:write name="RITCinemaForm" property = "result" filter ="false"/><br><br>
	   
			<a href="./AdminMail_Box.jsp">Back to SendMail</a><br>
			<a href="CinemaIndexManage.html">Back to Index</a></font></div>
			
</body>

</html:html>