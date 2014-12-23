<%-- 
    Document   : edit
    Created on : Aug 5, 2014, 9:37:38 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="admin_pro.css" />
<title>Edit Information</title>
</head>
<body>
   
    
    
<form action="logout" method="post" align="right">
<input type="submit" value="Logout">
</form>


<table cellpadding="0" width="70%" align="center" cellspacing="0">
<th>
<td><form action="admin.jsp" align="center">
<input type="submit" value="Profile">
</form></td>
<td><form action="ViewMark" align="center">
<input type="submit" value="View Marks" name="btViewMark">
</form></td>
<td><form action="setMark" align="center">
<input type="submit" value="Submit Marks" name="btSetMark">
</form></td>
<td><form action="ResultViewAdmin" align="center">
<input type="submit" value="View Result" name="btResultYear">
</form></td>
<td><form action="regDelete" align="center">
<input type="submit" value="Delete Registration" name="btDelete">
</form></td>
<td><form action="form2.html" align="center">
<input type="submit" value="Registration">
</form></td>
</table>
<form action="EditInfo" method="post">
<table cellpadding="2" width="70%" height="100%" align="center" cellspacing="2" class="main">
    <tr><td align="right" colspan="4">
     <input type="submit" value="Save">   
 </td></tr>
<tr>
<td align="center" width="50%"><font color="FFCC66" size="5">Address</font></td>
<td align="center" width="50%"><input type="text" name="address" id="address"
size="30"></td>
</tr>
<tr>
<td align="center" width="50%"><font color="FFCC66" size="5">Division</font></td>
<td align="center" width="50%"><input type="text" name="division" id="division"
size="30"></td>
</tr>
<tr>
<td align="center" width="50%"><font color="FFCC66" size="5">City</font></td>
<td align="center" width="50%"><input type="text" name="city" id="city"
size="30"></td>
</tr>
<tr>
<td align="center" width="50%"><font color="FFCC66" size="5">Mobile Number</font></td>
<td align="center" width="50%"><input type="text" name="mobile" id="mobile"
size="30"></td>
</tr>
<tr>
<td align="center" width="50%"><font color="FFCC66" size="5">Mail</font></td>
<td align="center" width="50%"><input type="email" name="mail" id="mail"
size="30"></td>
</tr>
</table>
    </form>
</body>
</html>
