<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<%@include file="/includes/header.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     
    </head>
    <body >
        <div id="main">
              <h1>Hello World!</h1>
        <ul style="text-align: left">
            <p>${count}</p>
            <c:forEach items="${questions}" var="question">
                <p>${question.getDetails()}</p>
                <p>${question.getOption1()}</p>
                <p>${question.getOption2()}</p>
                <p>${question.getAnswer()}</p>
            </c:forEach>
        </ul>
        </div>
      
             <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Clients</a>
        <a href="#">Contact</a>
    </div>

    </body>
</html>
