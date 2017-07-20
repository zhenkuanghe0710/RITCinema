<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Shows_Info</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="maroon" size="+3"><b>S</b></font><font face="Arial"><b>hows</b></font>
    <font face="Arial" color="maroon" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>

	<font face="Arial" color="maroon" size="+1"><b>
	<a href="./doCSI.do">All</a></b></font>
<form method="post" action="./doCSI.do">
    <font face="Arial" color="maroon"><b>M</b>ovie <b>I</b>D</font>
    <font face="Arial"><input type="text" size="10" name="movie_id"> <input type="submit" value="!"></font>
    <font face="Arial" color="maroon"><b><a href="./doCM.do">Check</a></b></font><br>
</form>
<form method="post" action="./doCSI.do">
    <font face="Arial" color="maroon"><b>C</b>inema <b>I</b>D</font>
    <font face="Arial"><input type="text" size="10" name="cinema_id"> <input type="submit" value="!"></font>
    <font face="Arial" color="maroon"><b><a href="./doCC.do">Check</a></b></font><br>
</form>
<form method="post" action="./doCSI.do">
    <font face="Arial" color="maroon"><b>S</b>how <b>D</b>ate</font>
    <font face="Arial"><input type="text" size="15" name="show_date"> <input type="submit" value="!"><br></font>
</form>
<form method="post" action="./doCSI.do">
    <font face="Arial" color="maroon"><b>S</b>how <b>T</b>ime</font>
    <font face="Arial"><input type="text" size="15" name="show_time"> <input type="submit" value="!"><br></font>
</form>
    
 

		
		<p class="content"><font face="Arial" color="maroon">
		    <logic:present name="RITCinemaForm" property="fullshowsList">
	<logic:notEmpty name="RITCinemaForm" property="fullshowsList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="maroon"><b>Show ID</b></font></td>
				<td align="center"><font color="maroon"><b>Movie ID</b></font></td>
				<td align="center"><font color="maroon"><b>Movie Name</b></font></td>
				<td align="center"><font color="maroon"><b>Actor</b></font></td>
				<td align="center"><font color="maroon"><b>Cinema ID</b></font></td>
				<td align="center"><font color="maroon"><b>Cinema Name</b></font></td>
				<td align="center"><font color="maroon"><b>Screen</b></font></td>
				<td align="center"><font color="maroon"><b>Seats</b></font></td>
				<td align="center"><font color="maroon"><b>Show Date</b></font></td>
				<td align="center"><font color="maroon"><b>Show Time</b></font></td>
				<td align="center"><font color="maroon"><b>Price</b></font></td>
			</tr>

			
			
			<logic:iterate name="RITCinemaForm" property="fullshowsList" id="FullShowsData">
				<tr>
					<td><bean:write name="FullShowsData" property="show_id" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="movie_id" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="movie_name" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="actor" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="cinema_id" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="cinema_name" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="screen" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="seats" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="show_date" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="show_time" filter="false" /></td>
					<td><bean:write name="FullShowsData" property="price" filter="false" /></td>
				</tr>
			</logic:iterate>
			
			
		</table>

	</logic:notEmpty>
</logic:present>

<a href="CinemaIndex.html">Back to Index</a><br>
</font>
</div>
</body>
</html:html>