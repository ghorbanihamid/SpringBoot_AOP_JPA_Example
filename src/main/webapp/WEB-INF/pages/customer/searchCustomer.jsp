<%@ page import="com.soshiant.model.customer.Customer" %>
<%@ page import="java.util.List" %>
<html>
<%
    String appMessage = (String)request.getAttribute("messageType");
%>
<head>

</head>
<body>
<h1>Register Customer Form</h1>
<form name='registerCustomer' action="/springmvc/searchCustomer" method='POST'>
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
            <td style="border: solid; border-color: black; width: 350px">
                <table>
                    <tr>
                        <td>Field Name:</td>
                        <td>
                            <select id="fieldName" name="fieldName">
                                <option value="AllCustomers">All Customers</option>
                                <option value="LastName">Last Name</option>
                                <option value="EmailAddress">Email Address</option>
                                <option value="PhoneNumber">Phone Number</option>
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
                &nbsp;
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
                        List<Customer> customerList = (List<Customer>)request.getAttribute("appMessage");
                        for (Customer anCustomer : customerList) {
                %>

                    <h2 style="color:blue;"><%=anCustomer.toString()%></h2>

                <%}} else if(appMessage.equals("error")){%>

                    <h2 style="color:red;">${appMessage}</h2>

                <%}%>
            </td>
        </tr>
    </table>
</form>
</body>

</html>