<%-- 
    Document   : show_req
    Created on : Aug 7, 2014, 4:59:06 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="admin_pro.css" />
<title>Request</title>
</head>
<body>
    
    <%
            String name[]=new String[1000];
            String FatherName[]=new String[1000];
            String Pin[]=new String[1000];
            name=(String[])session.getAttribute("name_req");
            FatherName=(String[])session.getAttribute("fathername_req");
            Pin=(String[])session.getAttribute("pin_req");
            String type[]=(String[])session.getAttribute("type_req");
            //String r=(String)session.getAttribute("NumOfReq");
            //int row=Integer.parseInt(r);
            int row=(Integer)session.getAttribute("NumOfReq");
    %>
    
    
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

<table cellpadding="2" width="70%" height="100%" align="center" cellspacing="2" class="main">
    <%if(row!=0){%>
    <tr><td align="center" width="20%"><font color="FFCC66" size="5">Name</td>
        <td align="center" width="20%"><font color="FFCC66" size="5">Father Name</td>
        <td align="center" width="25%"><font color="FFCC66" size="5">Pin</td>
        <td align="center" width="25%"><font color="FFCC66" size="5">Type</td>
    </tr><%}%>
   <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
    <%if(row==0){%>
    <tr><td colspan="3" align="center" width="25%"><font color="FFCC66" size="5">No Request</td></tr>
    <%}%>
    <%for(int i=0;i<row;i++){%>
     <tr>
        <td align="center" width="20%"><font color="FFCC66" size="5"><%out.print(name[i]);%></td>
        <td align="center" width="20%"><font color="FFCC66" size="5"><%out.print(FatherName[i]);%></td>
        <td align="center" width="25%"><font color="FFCC66" size="5"><%out.print(Pin[i]);%></td>
        <td align="center" width="15%"><font color="FFCC66" size="5"><%out.print(type[i]);%></td>
        <td align="center" width="10%">
            <form action="RequestAction" method="post"><input type="submit" value="Add" name="btReq"></form>
        </td>
        <td align="center" width="10%">
            <form action="RequestAction" method="post"><input type="submit" value="Delete" name="btReq"></form>
        </td>
     </tr>
    
    <%}%>
</table>
</body>
</html>