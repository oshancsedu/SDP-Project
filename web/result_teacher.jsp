<%-- 
    Document   : result_teacher
    Created on : Jun 6, 2014, 4:26:49 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="teacher_pro.css" />
<title>Result</title>
</head>
<body>
    <%
    String grade[][]=new String[20][2];
    String course[]=new String[20];
    grade=(String[][])session.getAttribute("ResultGrade");
    course=(String[])session.getAttribute("ResultCourse");
    int len=(Integer) session.getAttribute("RV#ofcourse");
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

<form method="post" action="ResultViewAdmin">
<table cellpadding="2" width="70%" align="left" cellspacing="5" class="main" style="padding:25px; border-spacing:15px;">


<tr><td colspan="4" align="right">
    <select name="semester">
<option value="-1" selected>Select Semester</option>
<option value="1st Semester">1st Semester</option>
<option value="2nd Semester">2nd Semester</option>
<option value="3rd Semester">3rd Semester</option>
<option value="4th Semester">4th Semester</option>
<option value="5th Semester">5th Semester</option>
<option value="6th Semester">6th Semester</option>
<option value="7th Semester">7th Semester</option>
<option value="8th Semester">8th Semester</option>
</select>

    <input type="text" name="year" placeholder="Enter Year"> 
    <input type="text" name="RV_reg_num" placeholder="Registration Number"><font color="FFCC66" size="3">
    <input type="radio" name="resultType" value="cgpa">CGPA 
    <input type="radio" name="resultType" value="division">Division </font>
    <input type="submit" value="Submit" name="btResultYear">
    </td></tr>
<tr><td colspan="4" align="right"><font color="FFCC66" size="5">
	<%
           String result_publish=(String)session.getAttribute("ViewResultMsg");
           out.print(""+result_publish);
        %>
</font></td></tr>
<%
for(int i=0;i<len;i++){
%>
<tr>
    <td width="25%" aling="center"><font color="FFCC66" size="5">
    <%out.print(""+course[i]);%>    </font>
    </td>
    <td width="25%" aling="center"><font color="FFCC66" size="5">
      <%out.print(""+grade[i][0]);%>  </font>
    </td>
    <td width="25%" aling="center"><font color="FFCC66" size="5">
      <%out.print(""+grade[i][1]);%>  </font>
    </td>
</tr>
<%}%>
<% if(len>0){%>
<tr><td colspan="3"><hr></td></tr>
<tr>
    <td width="25%" aling="center"><font color="FFCC66" size="5">
    <%out.print(""+course[len]);%>    </font>
    </td>
    <td width="25%" aling="center"><font color="FFCC66" size="5">
      <%out.print(""+grade[len][0]);%>  </font>
    </td>
    <td width="25%" aling="center"><font color="FFCC66" size="5">
      <%out.print(""+grade[len][1]);%>  </font>
    </td>
</tr><%}%>

</table>
</form>

</body>
</html>

