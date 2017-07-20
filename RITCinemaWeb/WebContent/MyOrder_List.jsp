<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>My Order List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="purple" size="+3"><b>M</b></font><font face="Arial"><b>yOrder</b></font>
    <font face="Arial" color="purple" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
<form method="post" action="./doCOL.do">
    <font face="Arial" color="purple"><b>U</b>ser <b>N</b>ame</font>
    <font face="Arial"><input type="text" size="20" name="username"> <input type="submit" value="!"></font>
</form>

		<p class="content"><font face="Arial" color="purple"> <logic:present
	name="RITCinemaForm" property="orderList">
	<logic:notEmpty name="RITCinemaForm" property="orderList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="purple"><b>Order ID</b></font></td>
				<td align="center"><font color="purple"><b>Food ID</b></font></td>
				<td align="center"><font color="purple"><b>Delivery Date</b></font></td>
				<td align="center"><font color="purple"><b>Quantity</b></font></td>
				<td align="center"><font color="purple"><b>Total Price</b></font></td>

				
			</tr>

			<logic:iterate name="RITCinemaForm" property="orderList"
				id="BuyData">
				<tr>
					<td><bean:write name="BuyData" property="order_id" filter="false" /></td>
					<td><bean:write name="BuyData" property="food_id" filter="false" /></td>
					<td><bean:write name="BuyData" property="delivery_date" filter="false" /></td>
					<td><bean:write name="BuyData" property="quantity" filter="false" /></td>
					<td><bean:write name="BuyData" property="total_price" filter="false" /></td>

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