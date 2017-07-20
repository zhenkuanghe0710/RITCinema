<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Production List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="#408080" size="+3"><b>P</b></font><font face="Arial"><b>roduction</b></font>
    <font face="Arial" color="#408080" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
    <font face="Arial" color="#408080" size="+1"><b>
	<a href="./doCPL.do">All</a></b></font>
<form method="post" action="./doCPL.do">
    <font face="Arial" color="#408080"><b>C</b>ompany <b>N</b>ame</font>
    <font face="Arial"><input type="text" size="20" name="company_name"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="#0080c0"> <logic:present
	name="RITCinemaForm" property="productionList">
	<logic:notEmpty name="RITCinemaForm" property="productionList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				
				<td align="center"><font color="#408080"><b>Company Name</b></font></td>
				<td align="center"><font color="#408080"><b>Movie Name</b></font></td>
				
			</tr>

			<logic:iterate name="RITCinemaForm" property="productionList"
				id="ProductionData">
				<tr>
					<td><bean:write name="ProductionData" property="company_name" filter="false" /></td>
					<td><bean:write name="ProductionData" property="movie_name" filter="false" /></td>
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