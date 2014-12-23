<%-- 
    Document   : reg_num
    Created on : May 28, 2014, 11:32:09 PM
    Author     : Oshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1 align="center">Your Registration number is
        <% 
            out.println(""+session.getAttribute("reg_num"));
        %></h1>
    </body>
</html>
