<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Cinema List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="navy" size="+3"><b>C</b></font><font face="Arial"><b>inema</b></font>
    <font face="Arial" color="navy" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
<font face="Arial" color="navy" size="+1"><b>
	<a href="./doCC.do">All</a></b></font>
<form method="post" action="./doCC.do">
    <font face="Arial" color="navy"><b>C</b>ity</font>
    <font face="Arial"><input type="text" size="20" name="address_city"> <input type="submit" value="!"></font>
</form>
<form method="post" action="./doCC.do">
    <font face="Arial" color="navy"><b>S</b>tate</font>
    <font face="Arial"><input type="text" size="20" name="address_state"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="navy"> <logic:present
	name="RITCinemaForm" property="cinemaList">
	<logic:notEmpty name="RITCinemaForm" property="cinemaList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="navy"><b>Cinema ID</b></font></td>
				<td align="center"><font color="navy"><b>Cinema Name</b></font></td>
				<td align="center"><font color="navy"><b>Street</b></font></td>
				<td align="center"><font color="navy"><b>City</b></font></td>
				<td align="center"><font color="navy"><b>State</b></font></td>
			</tr>

			<logic:iterate name="RITCinemaForm" property="cinemaList" id="CinemaData">
				<tr>
					<td><bean:write name="CinemaData" property="cinema_id" filter="false" /></td>
					<td><bean:write name="CinemaData" property="cinema_name" filter="false" /></td>
					<td><bean:write name="CinemaData" property="address_street" filter="false" /></td>
					<td><bean:write name="CinemaData" property="address_city" filter="false" /></td>
					<td><bean:write name="CinemaData" property="address_state" filter="false" /></td>
				</tr>
			</logic:iterate>


		</table>

	</logic:notEmpty>
</logic:present> 
<a href="./doCSI.do">Go to Show List</a><br>
<br>
<a href="CinemaIndex.html">Back to Index</a><br>
</font></p>
</div>
</body>
</html:html>