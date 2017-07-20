<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Admin Mail Box</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="gray" size="+3"><b>A</b></font><font face="Arial"><b>dminMail</b></font>
    <font face="Arial" color="gray" size="+3"><b>B</b></font><font face="Arial"><b>ox</b></font></p>
    
    <font face="Arial" color="maroon" size="+1"><b>
	<a href="./doACMB.do">All</a></b></font>
	
<form method="post" action="./doACMB.do">
    <font face="Arial" color="gray"><b>U</b>ser <b>N</b>ame</font>
    <font face="Arial"><input type="text" size="20" name="username"> <input type="submit" value="!"></font>
</form>

<form method="post" action="./doACMB.do">
    <font face="Arial" color="gray"><b>A</b>dmin <b>N</b>ame</font>
    <font face="Arial"><input type="text" size="20" name="adminname"> <input type="submit" value="!"></font>
</form>

<form method="post" action="./doACMB.do">
    <font face="Arial" color="gray"><b>D</b>ate</font>
    <font face="Arial"><input type="text" size="20" name="contact_date"> <input type="submit" value="!"></font>
</form>

<font face="Arial" color="#ff8000"><b>S</b>end <b>M</b>ail</font>
<form method="post" action="./doSM.do">
    <font face="Arial" color="#ff8000"><b>A</b>dmin <b>N</b>ame</font><br><input type="text" size="20" name="adminname"><br>
    <font face="Arial" color="#ff8000"><b>U</b>ser <b>N</b>ame</font><br><input type="text" size="20" name="username"><br>
<br>
    <font face="Arial" color="#ff8000"><b>C</b>ontent (within 120 words)</font><br><input type="text" size="120" name="content"><br>
    <input type="submit"  value="Go,Send!"></form>

		<p class="content"><font face="Arial" color="olive"> <logic:present
	name="RITCinemaForm" property="mailList">
	<logic:notEmpty name="RITCinemaForm" property="mailList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="gray"><b>User Name</b></font></td>
				<td align="center"><font color="gray"><b>Admin Name</b></font></td>
				<td align="center"><font color="gray"><b>Date</b></font></td>
				<td align="center"><font color="gray"><b>Subject</b></font></td>
				<td align="center"><font color="gray"><b>Content</b></font></td>
				
			</tr>

			<logic:iterate name="RITCinemaForm" property="mailList"
				id="MailData">
				<tr>
					<td><bean:write name="MailData" property="username" filter="false" /></td>
					<td><bean:write name="MailData" property="adminname" filter="false" /></td>
					<td><bean:write name="MailData" property="contact_date" filter="false" /></td>
					<td><bean:write name="MailData" property="subject" filter="false" /></td>
					<td><bean:write name="MailData" property="content" filter="false" /></td>

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