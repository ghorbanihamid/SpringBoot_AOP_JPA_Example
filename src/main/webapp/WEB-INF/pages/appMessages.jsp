<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String appMessage = (String)request.getAttribute("messageType");
%>
<head>
    <title>Spring MVC Web Application</title>
</head>
<body>
    <h1>Spring MVC JAVA Config Example</h1>
    <br>
    <% if(appMessage.equals("success")){%>
        <h2 style="color:blue;">${appMessage}</h2>
    <%} else {%>
        <h2 style="color:red;">${appMessage}</h2>
    <%}%>
</body>
</html>
