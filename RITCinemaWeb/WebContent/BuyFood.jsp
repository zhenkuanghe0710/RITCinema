<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Buy Food</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="purple" size="+3"><b>B</b></font><font face="Arial"><b>uy</b></font>
    <font face="Arial" color="purple" size="+3"><b>F</b></font><font face="Arial"><b>ood</b></font></p>
		
	<form method="post" action="./doBF.do">
    <font face="Arial" color="purple"><b>F</b>ood <b>I</b>D</font> 
    <input type="text" size="10" name="food_id"><br>
    <font face="Arial" color="purple"><b>D</b>elivery <b>D</b>ate</font> 
    <input type="text" size="10" name="delivery_date"><br>
    <font face="Arial" color="purple"><b>Q</b>uantity </font> 
    <input type="text" size="10" name="quantity"><br>
    <font face="Arial" color="purple"><b>U</b>ser <b>N</b>ame</font> 
    <input type="text" size="20" name="username"><br>
    <input type="submit"  value="Go,Book!"></form>
		
		
		
		
		<p class="content"><font face="Arial" color="maroon">
		    <logic:present name="RITCinemaForm" property="foodList">
	<logic:notEmpty name="RITCinemaForm" property="foodList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="purple"><b>Food ID</b></font></td>
				<td align="center"><font color="purple"><b>Food Name</b></font></td>
				<td align="center"><font color="purple"><b>Price</b></font></td>
				<td align="center"><font color="purple"><b>Type</b></font></td>
				<td align="center"><font color="purple"><b>Descrption</b></font></td>

			</tr>

			
			
			<logic:iterate name="RITCinemaForm" property="foodList" id="FoodData">
				<tr>
					<td><bean:write name="FoodData" property="food_id" filter="false" /></td>
					<td><bean:write name="FoodData" property="food_name" filter="false" /></td>
					<td><bean:write name="FoodData" property="price" filter="false" /></td>
					<td><bean:write name="FoodData" property="type" filter="false" /></td>
					<td><bean:write name="FoodData" property="description" filter="false" /></td>

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