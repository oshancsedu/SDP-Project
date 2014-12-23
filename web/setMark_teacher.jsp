<%-- 
    Document   : setMark
    Created on : May 31, 2014, 3:19:00 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validate.js"></script>
<link rel="stylesheet" type="text/css" href="teacher_pro.css" />
<title>Submit Mark</title>
</head>
<body>
    <%Boolean flag=(Boolean)session.getAttribute("showSetMarkMsg");
      Boolean flag1=true;
      int length=0;
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
<form method="post" action="setMark">
<table cellpadding="2" width="70%" align="left" cellspacing="5" class="main" style="padding:25px; border-spacing:15px;">

<tr><td colspan="4" align="right">
<select name="course_code">
<option value="-1" selected>Select Course</option>
<%for(int i=0;i<length;i++){%>
<option value=<%out.println(courseCode[i]);%>><%out.println(courseCode[i]);%></option>
<%}%>
</select>
</td></tr>
<tr>
<td width="25%" align="center"><select name="exam_type1">
<option value="-1" selected>select..</option>
<option value="Incourse">Incourse</option>
<option value="Assignment">Assignment</option>
<option value="Attendence">Attendence</option>
<option value="Viva">Viva</option>
<option value="Presentation">Presentation</option>
<option value="Final Exam">Final Exam</option>
</select></td>
<td width="25%" align="center"><input type="text" placeholder="Enter Mark" name="mark1"></td>
<td width="25%" align="center"><input type="text" placeholder="Total Mark" name="totalmark1"></td>
<td>
    <font color="FFCC66" size="3">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg1"));
    %>
</font>
</td>
</tr>

<tr>
<td width="25%" align="center"><select name="exam_type2">
<option value="-1" selected>select..</option>
<option value="Incourse">Incourse</option>
<option value="Assignment">Assignment</option>
<option value="Attendence">Attendence</option>
<option value="Viva">Viva</option>
<option value="Presentation">Presentation</option>
<option value="Final Exam">Final Exam</option>
</select></td>
<td width="25%" align="center"><input type="text" placeholder="Enter Mark" name="mark2"></td>
<td width="25%" align="center"><input type="text" placeholder="Total Mark" name="totalmark2"></td>
<td>
    <font color="FFCC66" size="3">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg2"));
    %>
</font>
</td>
</tr>

<tr>
<td width="25%" align="center"><select name="exam_type3">
<option value="-1" selected>select..</option>
<option value="Incourse">Incourse</option>
<option value="Assignment">Assignment</option>
<option value="Attendence">Attendence</option>
<option value="Viva">Viva</option>
<option value="Presentation">Presentation</option>
<option value="Final Exam">Final Exam</option>
</select></td>
<td width="25%" align="center"><input type="text" placeholder="Enter Mark" name="mark3"></td>
<td width="25%" align="center"><input type="text" placeholder="Total Mark" name="totalmark3"></td>
<td>
    <font color="FFCC66" size="3">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg3"));
    %>
</font>
</td>
</tr>

<tr>
<td width="25%" align="center"><select name="exam_type4">
<option value="-1" selected>select..</option>
<option value="Incourse">Incourse</option>
<option value="Assignment">Assignment</option>
<option value="Attendence">Attendence</option>
<option value="Viva">Viva</option>
<option value="Presentation">Presentation</option>
<option value="Final Exam">Final Exam</option>
</select></td>
<td width="25%" align="center"><input type="text" placeholder="Enter Mark" name="mark4"></td>
<td width="25%" align="center"><input type="text" placeholder="Total Mark" name="totalmark4"></td>
<td>
    <font color="FFCC66" size="3">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg4"));
    %>
</font>
</td>
</tr>

<tr>
<td width="25%" align="center"><input type="text" placeholder="Others" name="exam_type5"></td>
<td width="25%" align="center"><input type="text" placeholder="Enter Mark" name="mark5"></td>
<td width="25%" align="center"><input type="text" placeholder="Total Mark" name="totalmark5"></td>
<td>
    <font color="FFCC66" size="3">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg5"));
    %>
</font>
</td>
</tr>
<tr>
<td width="25%" align="center"><input type="text" placeholder="Others" name="exam_type6"></td>
<td width="25%" align="center"><input type="text" placeholder="Enter Mark" name="mark6"></td>
<td width="25%" align="center"><input type="text" placeholder="Total Mark" name="totalmark6"></td>
<td>
    <font color="FFCC66" size="3">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg6"));
    %>
</font>
</td>
</tr>
<tr><td colspan="4" align="right">
	<input type="text" name="SetMarkreg_num" placeholder="Registration Number">            
    <input type="submit" value="Submit" name="btSetMark">
</td></tr>

<tr><td colspan="4" align="right"><font color="FFCC66" size="5">
    <%
        if(flag==flag1)
        out.println((String)session.getAttribute("SetMark_msg"));
    %>
</font></td></tr>


</table>
</form>
</body>
</html>