<%-- 
    Document   : del_reg
    Created on : May 30, 2014, 7:26:55 PM
    Author     : Oshan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="admin_pro.css" />
<title>Delete Registration</title>
</head>
<body>
    <%Boolean flag=(Boolean)session.getAttribute("showDeleteMsg"); %>
    
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
<td><form action="ShowRequest" align="center">
<input type="submit" value="Registration">
</form></td>
</table>
<table cellpadding="2" width="70%" align="center" cellspacing="2" class="main" style="padding:25px">
    <tr><td valign="top"><form action="regDelete" align="left" padding="10px" method="post">
            <input type="text" name="del_reg_num" placeholder="Registration Number">  
            <select name="type">
               <option value="student">Student</option>
               <option value="teacher">Teacher</option>
            </select>    
            <input type="submit" value="Delete" name="btDelete">
            </form>
         <font color="FFCC66" size="5">
    <%
        Boolean flag1=true;
        if(flag==flag1)
        out.println((String)session.getAttribute("del_msg"));
    %>    
    </font>
    </td></tr>

 
    
</table>
</body>
</html>