<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Book</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="green" size="+3"><b>B</b></font><font face="Arial"><b>ook</b></font>
    <font face="Arial" color="green" size="+3"><b>T</b></font><font face="Arial"><b>icket</b></font></p>
		
	<form method="post" action="./doBT.do">
    <font face="Arial" color="green"><b>S</b>how <b>I</b>D</font> 
    <input type="text" size="10" name="show_id"><br>
    <font face="Arial" color="green"><b>D</b>iscount <b>I</b>D</font> 
    <input type="text" size="10" name="discount_id"><br>
    <font face="Arial" color="green"><b>U</b>ser <b>N</b>ame</font> 
    <input type="text" size="20" name="username"><br>
    <input type="submit"  value="Go,Book!"></form>
		
		
		
		
		<p class="content"><font face="Arial" color="maroon">
		    <logic:present name="RITCinemaForm" property="fullshowsList">
	<logic:notEmpty name="RITCinemaForm" property="fullshowsList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="green"><b>Show ID</b></font></td>
				<td align="center"><font color="green"><b>Movie ID</b></font></td>
				<td align="center"><font color="green"><b>Movie Name</b></font></td>
				<td align="center"><font color="green"><b>Actor</b></font></td>
				<td align="center"><font color="green"><b>Cinema ID</b></font></td>
				<td align="center"><font color="green"><b>Cinema Name</b></font></td>
				<td align="center"><font color="green"><b>Screen</b></font></td>
				<td align="center"><font color="green"><b>Seats</b></font></td>
				<td align="center"><font color="green"><b>Show Date</b></font></td>
				<td align="center"><font color="green"><b>Show Time</b></font></td>
				<td align="center"><font color="green"><b>Price</b></font></td>
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