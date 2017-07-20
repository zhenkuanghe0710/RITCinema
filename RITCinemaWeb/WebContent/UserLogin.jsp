<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>User Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="blue" size="+3"><b>U</b></font><font face="Arial"><b>ser</b></font>
    <font face="Arial" color="blue" size="+3"><b>L</b></font><font face="Arial"><b>ogin</b></font></p>
		
	<form method="post" action="./doUL.do">
    <font face="Arial" color="blue"><b>U</b>ser <b>N</b>ame</font><br><input type="text" size="20" name="username"><br>
<br>
    <font face="Arial" color="blue"><b>P</b>assword</font><br><input type="text" size="20" name="password"><br>
    <input type="submit"  value="Go,Login!"><br>
</form>

    
<font face="Arial" color="olive">
<a href="./Register.jsp"><font size="+2"><b>Register Now!!</b></font></a><br><br>
<a href="LoginSelect.html">Back to Select</a><br>
</font>
</div>
</body>
</html:html>