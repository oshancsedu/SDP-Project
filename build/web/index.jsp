<%-- 
    Document   : index
    Created on : May 28, 2014, 10:52:04 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="login/css" href="login.css" />
<title>Login</title>
</head>
<body>

<form action="login" name="StudentRegistration" method="post"">

<table cellpadding="2" width="35%" height="50%" bgcolor="#D0D0D0" align="right" border=2px 
cellspacing="2">

<tr>
<td colspan=2>
<center><font size=5><b><h2><font face="Castellar">User Login</h2></b></font></center>
</td>
</tr>

<tr>
<td>User Name</td>
<td><input type="text" name="username" id="username" size="40"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" id="password" size="40"></td>
</tr>

<tr>
    <td colspan="2" align="center"><input type="submit" value="Sign-in"></form></td>
<td><br><form action="form.jsp"><input type="submit" value="Sign up" /></form></td>
</tr>

</table>
</body>
</html>
