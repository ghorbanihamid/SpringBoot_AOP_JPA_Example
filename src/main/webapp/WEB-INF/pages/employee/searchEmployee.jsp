<%@ page import="com.soshiant.model.employee.Employee" %>
<%@ page import="java.util.List" %>
<html>
<%
    String appMessage = (String)request.getAttribute("messageType");
%>

<head></head>
<body>
<h1>Register Customer Form</h1>
<form name='searchEmployee' action="/springmvc/searchEmployee" method='POST'>
    <table>
        <tr>
            <td style="border: solid; border-color: black; width: 350px">
                <br>
                <a href="/springmvc/dashboard">Back to Dashboard</a>
                <br>
            </td>
        </tr>
        <tr>
            <td>
                <br>
            </td>
        </tr>
        <tr>
            <td style="border:solid; border-color: black; width: 350px">
                <table>
                    <tr>
                        <td>Field Name:</td>
                        <td>
                            <select id="fieldName" name="fieldName">
                                <option value="AllEmployees">All Employees</option>
                                <option value="EmployeeId">Employee Id</option>
                                <option value="FirstName">First Name</option>
                                <option value="LastName">Last Name</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Field Value:</td>
                        <td><input type='text' id="fieldValue" name='fieldValue' /></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input name="Search" type="submit" value="Search" /></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                <h1>Result:</h1>
            </td>
        </tr>
        <tr>
            <td>
                <%
                    if(appMessage.equals("success")){
                        List<Employee> employeeList = (List<Employee>)request.getAttribute("appMessage");
                        for (Employee anEmployee : employeeList) {
                %>
                <table>
                    <tr>
                        <td style="color:blue;"><%=anEmployee.toString()%></td>
                    </tr>
                </table>

                <%}} else if(appMessage.equals("error")) {%>
                <h2 style="color:red;">${appMessage}</h2>
                <%}%>
            </td>
        </tr>
    </table>

</form>
</body>

</html>