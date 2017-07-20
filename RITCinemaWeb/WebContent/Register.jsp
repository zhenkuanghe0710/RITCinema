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
    <font face="Arial" color="red" size="+3"><b>R</b></font><font face="Arial"><b>egister</b></font></p>
		
	<form method="post" action="./doR.do">
    <font face="Arial" color="red"><b>S</b>sn</font><br><input type="text" size="10" name="ssn"><br>
<br><font face="Arial" color="red"><b>F</b>ull <b>N</b>ame</font><br><input type="text" size="20" name="person_name"><br>
<br><font face="Arial" color="red"><b>E</b>mail <b>A</b>ddress</font><br><input type="text" size="20" name="email"><br>
<br><font face="Arial" color="red"><b>P</b>hone <b>N</b>umber</font><br><input type="text" size="20" name="phone"><br>
<br><font face="Arial" color="red"><b>U</b>ser <b>N</b>ame</font><br><input type="text" size="20" name="username"><br>
<br>
    <font face="Arial" color="red"><b>P</b>assword</font><br><input type="text" size="20" name="password"><br>
    <input type="submit"  value="Go,Register!"></form>
    
<font face="Arial" color="red">
<a href="LoginSelect.html">Back to Select</a><br>
</font>
</div>
</body>
</html:html>