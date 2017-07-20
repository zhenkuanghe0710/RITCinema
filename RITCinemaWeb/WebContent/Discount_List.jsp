<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Discount List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="#0080c0" size="+3"><b>D</b></font><font face="Arial"><b>iscount</b></font>
    <font face="Arial" color="#0080c0" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
    <font face="Arial" color="maroon" size="+1"><b>
	<a href="./doCD.do">All</a></b></font>
<form method="post" action="./doCD.do">
    <font face="Arial" color="#0080c0"><b>W</b>ork or <b>S</b>tudy <b>P</b>lace</font>
    <font face="Arial"><input type="text" size="20" name="works_for"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="#0080c0"> <logic:present
	name="RITCinemaForm" property="discountList">
	<logic:notEmpty name="RITCinemaForm" property="discountList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="#0080c0"><b>Discount ID</b></font></td>
				<td align="center"><font color="#0080c0"><b>Place</b></font></td>
				<td align="center"><font color="#0080c0"><b>%OFF</b></font></td>
				
			</tr>

			<logic:iterate name="RITCinemaForm" property="discountList"
				id="DiscountData">
				<tr>
					<td><bean:write name="DiscountData" property="discount_id" filter="false" /></td>
					<td><bean:write name="DiscountData" property="works_for" filter="false" /></td>
					<td><bean:write name="DiscountData" property="off_rate" filter="false" /></td>

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