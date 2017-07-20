<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Contract List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="#ff8040" size="+3"><b>C</b></font><font face="Arial"><b>ontract</b></font>
    <font face="Arial" color="#ff8040" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
    <font face="Arial" color="#ff8040" size="+1"><b>
	<a href="./doCCL.do">All</a></b></font>
<form method="post" action="./doCCL.do">
    <font face="Arial" color="#ff8040"><b>C</b>inema <b>S</b>tate</font>
    <font face="Arial"><input type="text" size="20" name="address_state"> <input type="submit" value="!"></font>
</form>
<form method="post" action="./doCCL.do">
    <font face="Arial" color="#ff8040"><b>C</b>ompany <b>C</b>ountry</font>
    <font face="Arial"><input type="text" size="20" name="country"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="#0080c0"> <logic:present
	name="RITCinemaForm" property="fullcontractList">
	<logic:notEmpty name="RITCinemaForm" property="fullcontractList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="#ff8040"><b>Cinema Name</b></font></td>
				<td align="center"><font color="#ff8040"><b>Cinema State</b></font></td>
				<td align="center"><font color="#ff8040"><b>Company Name</b></font></td>
				<td align="center"><font color="#ff8040"><b>Company Country</b></font></td>
				
			</tr>

			<logic:iterate name="RITCinemaForm" property="fullcontractList"
				id="FullContractData">
				<tr>
					<td><bean:write name="FullContractData" property="cinema_name" filter="false" /></td>
					<td><bean:write name="FullContractData" property="address_state" filter="false" /></td>
					<td><bean:write name="FullContractData" property="company_name" filter="false" /></td>
					<td><bean:write name="FullContractData" property="country" filter="false" /></td>

				</tr>
			</logic:iterate>


		</table>

	</logic:notEmpty>
</logic:present> 

<a href="CinemaIndexManage.html">Back to Index</a><br>
</font></p>
</div>
</body>
</html:html>