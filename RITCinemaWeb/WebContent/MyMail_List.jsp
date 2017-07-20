<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>My Mail List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title">
    <font face="Arial" color="gray" size="+3"><b>M</b></font><font face="Arial"><b>yMail</b></font>
    <font face="Arial" color="gray" size="+3"><b>L</b></font><font face="Arial"><b>ist</b></font></p>
<form method="post" action="./doCML.do">
    <font face="Arial" color="gray"><b>U</b>ser <b>N</b>ame</font>
    <font face="Arial"><input type="text" size="20" name="username"> <input type="submit" value="!"></font>
</form>

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

<a href="CinemaIndex.html">Back to Index</a><br>
</font></p>
</div>
</body>
</html:html>