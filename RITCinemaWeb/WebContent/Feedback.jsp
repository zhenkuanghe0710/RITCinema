<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Buy Food</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="olive" size="+3"><b>F</b></font><font face="Arial"><b>eedback</b></font></p>
		
	<form method="post" action="./doFB.do">
    <font face="Arial" color="olive"><b>U</b>ser <b>N</b>ame</font><br><input type="text" size="20" name="username"><br>
<br>
    <font face="Arial" color="olive"><b>C</b>ontent (within 120 words)</font><br><input type="text" size="120" name="content"><br>
    <input type="submit"  value="Go,Send!"></form>
    
<font face="Arial" color="olive">
<a href="CinemaIndex.html">Back to Index</a><br>
</font>
</div>
</body>
</html:html>