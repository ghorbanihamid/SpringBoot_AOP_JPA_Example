<%@ page import="com.soshiant.model.user.UserInfo" %>
<%@ page import="java.util.List" %>
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
    <%
        if(appMessage.equals("success")){
            List<UserInfo> usersList = (List<UserInfo>)request.getAttribute("appMessage");
            for (UserInfo anUsersList : usersList) {
    %>
                <table>
                    <tr>
                        <td style="color:blue;"><%=anUsersList.toString()%></td>
                    </tr>
                </table>

    <%}} else {%>
        <h2 style="color:red;">${appMessage}</h2>
    <%}%>
</body>
</html>
