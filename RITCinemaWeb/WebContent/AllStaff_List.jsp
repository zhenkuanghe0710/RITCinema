<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>All Staff List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="#8080c0" size="+3"><b>A</b></font><font face="Arial"><b>llStaff</b></font>
    <font face="Arial" color="#8080c0" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
    
    <font face="Arial" color="maroon" size="+1"><b>
	<a href="./doCSL.do">All</a></b></font>
	
	<form method="post" action="./doCSL.do">
    <font face="Arial" color="#8080c0"><b>D</b>partment</font>
    <font face="Arial"><input type="text" size="20" name="department"> <input type="submit" value="!"></font>
    </form>
    
    <form method="post" action="./doCSL.do">
    <font face="Arial" color="#8080c0"><b>P</b>osition</font>
    <font face="Arial"><input type="text" size="20" name="position"> <input type="submit" value="!"></font>
	</form>

		<p class="content"><font face="Arial" color="olive"> <logic:present
	name="RITCinemaForm" property="fullstaffList">
	<logic:notEmpty name="RITCinemaForm" property="fullstaffList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="#8080c0"><b>Person Name</b></font></td>
				<td align="center"><font color="#8080c0"><b>Position</b></font></td>
				<td align="center"><font color="#8080c0"><b>Department</b></font></td>
				<td align="center"><font color="#8080c0"><b>Working Time</b></font></td>
				<td align="center"><font color="#8080c0"><b>Salary</b></font></td>
				
			</tr>

			<logic:iterate name="RITCinemaForm" property="fullstaffList"
				id="FullStaffData">
				<tr>
					<td><bean:write name="FullStaffData" property="person_name" filter="false" /></td>
					<td><bean:write name="FullStaffData" property="position" filter="false" /></td>
					<td><bean:write name="FullStaffData" property="department" filter="false" /></td>
					<td><bean:write name="FullStaffData" property="working_time" filter="false" /></td>
					<td><bean:write name="FullStaffData" property="salary" filter="false" /></td>


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