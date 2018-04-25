<html>
<head></head>
<body>
<h1>Register Employee Form</h1>
<form name='registerEmployee' action="/springmvc/registerEmployee" method='POST'>
    <table border="1" style="border: black; width: 350px">
        <tr>
            <td>
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type='text' name='firstName' value=''></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type='text' name='lastName' /></td>
                    </tr>
                    <tr>
                        <td>Email Address:</td>
                        <td><input type='text' name='emailAddress' value=''></td>
                    </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type='text' name='phoneNumber' /></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input name="submit" type="submit" value="Register" /></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>