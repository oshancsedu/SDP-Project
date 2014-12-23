<%-- 
    Document   : viewMark_teacher
    Created on : Jun 2, 2014, 5:14:11 PM
    Author     : Oshan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="teacher_pro.css" />
<title>Mark</title>
</head>
<body>
    <%Boolean flag=(Boolean)session.getAttribute("showViewMarkMsg");
      Boolean table=(Boolean)session.getAttribute("showViewMarkMsgTable");
      Boolean flag1=true;
      int total=0,mark=0,length=0;
      String courseCode[]=new String[10000];
      courseCode=(String[])session.getAttribute("CourseCode");
      length=(Integer)session.getAttribute("#ofCourseCode");%>
<form action="index.jsp" align="right">
<input type="submit" value="logout">
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

<form method="post" action="ViewMark">
<table cellpadding="2" width="70%" align="left" cellspacing="5" class="main" style="padding:25px; border-spacing:15px;">

<tr><td colspan="4" align="right">
<select name="course_code">
<option value="-1" selected>Select Course</option>
<%for(int i=0;i<length;i++){%>
<option value=<%out.println(courseCode[i]);%>><%out.println(courseCode[i]);%></option>
<%}%>
</select>

    <input type="text" name="ViewMarkreg_num" placeholder="Registration Number">            
    <input type="submit" value="Submit" name="btViewMark">
</td></tr>


<tr><td colspan="4" align="right"><font color="FFCC66" size="5">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("ViewMark_msg"));
    %>
</font></td></tr>
<%if(table==flag1){%>
<%
ResultSet rs=(ResultSet)session.getAttribute("rsViewMark");
rs.beforeFirst();
while(rs.next()){
%>
<tr><td width="25%">
</td>
<td aling="center" width="25%"><font color="FFCC66" size="5">
    <%out.println(rs.getString(1)+" ("+rs.getString(3)+")");
    total+=Integer.parseInt(rs.getString(3));%></font>
</td>
<td aling="center" width="25%"><font color="FFCC66" size="5">
    <%out.println(rs.getString(2));
    mark+=Integer.parseInt(rs.getString(2));%></font>
</td>
</tr>
<%}%>
<tr><td width="25%"></td><td colspan="2" width="50%"><hr></td></tr>
<tr><td width="25%">
</td>
<td aling="center" width="25%"><font color="FFCC66" size="5">
    <%out.println("Total ("+total+")");%></font>
</td>
<td aling="center" width="25%"><font color="FFCC66" size="5">
    <%out.println(mark+" ("+(mark*100/total)+"%)");%></font>
</td>
</tr>
<%}%>
</table>
</form>
</body>
</html>