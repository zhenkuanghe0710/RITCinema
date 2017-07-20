<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>My Ticket List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="olive" size="+3"><b>M</b></font><font face="Arial"><b>yTicket</b></font>
    <font face="Arial" color="olive" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
<form method="post" action="./doCMT.do">
    <font face="Arial" color="olive"><b>U</b>ser <b>N</b>ame</font>
    <font face="Arial"><input type="text" size="20" name="username"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="olive"> <logic:present
	name="RITCinemaForm" property="booksList">
	<logic:notEmpty name="RITCinemaForm" property="booksList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="olive"><b>Ticket ID</b></font></td>
				<td align="center"><font color="olive"><b>Show ID</b></font></td>
				<td align="center"><font color="olive"><b>Movie Name</b></font></td>
				<td align="center"><font color="olive"><b>Cinema Name</b></font></td>
				<td align="center"><font color="olive"><b>Show Date</b></font></td>
				<td align="center"><font color="olive"><b>Show Time</b></font></td>
				<td align="center"><font color="olive"><b>Seat #</b></font></td>
				<td align="center"><font color="olive"><b>Price</b></font></td>
				
			</tr>

			<logic:iterate name="RITCinemaForm" property="booksList"
				id="BooksData">
				<tr>
					<td><bean:write name="BooksData" property="ticket_id" filter="false" /></td>
					<td><bean:write name="BooksData" property="show_id" filter="false" /></td>
					<td><bean:write name="BooksData" property="movie_name" filter="false" /></td>
					<td><bean:write name="BooksData" property="cinema_name" filter="false" /></td>
					<td><bean:write name="BooksData" property="show_date" filter="false" /></td>
					<td><bean:write name="BooksData" property="show_time" filter="false" /></td>
					<td><bean:write name="BooksData" property="seatnumber" filter="false" /></td>
					<td><bean:write name="BooksData" property="price" filter="false" /></td>


				</tr>
			</logic:iterate>


		</table>

	</logic:notEmpty>
</logic:present> 

<a href="CinemaIndex.html">Back to Index</a><br>
</font></p>
</div>
</body>
</html:html>