<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Movie List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="teal" size="+3"><b>M</b></font><font face="Arial"><b>ovies</b></font>
    <font face="Arial" color="teal" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
<font face="Arial" color="maroon" size="+1"><b>
	<a href="./doCM.do">All</a></b></font>
<form method="post" action="./doCM.do">
    <font face="Arial" color="teal"><b>A</b>ctor</font>
    <font face="Arial"><input type="text" size="20" name="actor"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="teal"> <logic:present
	name="RITCinemaForm" property="movieList">
	<logic:notEmpty name="RITCinemaForm" property="movieList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="teal"><b>Movie ID</b></font></td>
				<td align="center"><font color="teal"><b>Movie Name</b></font></td>
				<td align="center"><font color="teal"><b>Actor</b></font></td>
			</tr>

			<logic:iterate name="RITCinemaForm" property="movieList"
				id="Movie_infoData">
				<tr>
					<td><bean:write name="Movie_infoData" property="movie_id" filter="false" /></td>
					<td><bean:write name="Movie_infoData" property="movie_name" filter="false" /></td>
					<td><bean:write name="Movie_infoData" property="actor" filter="false" /></td>

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