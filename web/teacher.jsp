<%-- 
    Document   : teacher
    Created on : May 28, 2014, 11:25:22 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="teacher_pro.css" />
<title>Teacher</title>
</head>
<body>
    
    <%
            String display[][]=(String[][])session.getAttribute("table");
            String r=(String)session.getAttribute("row");
            int row=Integer.parseInt(r);
    %>
    
<form action="logout" method="post" align="right">
<input type="submit" value="Logout">
</form>


<table cellpadding="0" width="70%" align="left" cellspacing="0">
<th>
<td><form action="teacher.jsp" align="center">
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
<td><form action="form.jsp" align="center">
<input type="submit" value="Registration">
</form></td>
</table>
    
<table cellpadding="2" width="70%" height="100%" align="left" cellspacing="2" class="main">

     <tr><td align="right" colspan="4"><form action="edit_teacher.jsp">
     <input type="submit" value="Edit">   
 </form></td></tr>
<tr><td align="center" colspan="3"><font color="#D8D8D8" size="10">Welcome
        <%
            out.print(" "+display[0][1]);
        %>
        
</font></td></tr>

    <tr><td><br></td></tr><tr><td><br></td></tr>
  
<%
for(int i=1;i<row;i++){

%>    
    
<tr>
    <td align="center" width="50%"><font color="FFCC66" size="5"><%out.print(""+display[i][0]);%></font></td>
    
    <td align="center" width="50%"><font color="FFCC66" size="5">
        <%
            out.print(""+display[i][1]);
        %>
        
    </font></td>
</tr>
<%}%>

</table>
</body>
</html>