<%--
  Created by IntelliJ IDEA.
  User: muhammad.shayaan
  Date: 9/30/2021
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

<div id="wrapper">
    <div id = header>
        <h2>CRM- Customer Relationship Manager</h2>
    </div>
    <div id = container>
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">

<%--            need to associate this data with the customer id--%>
            <form:hidden path="id"></form:hidden>
            <table>
                <tbody>
                <tr>
                    <td><label>First name: </label></td>
                    <td><form:input path="first_name"></form:input></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><form:input path="last_name"></form:input></td>
                </tr>

                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email"></form:input></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></input></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div ></div>
        <p>
            <a href="/customer/list"></a>
        </p>
    </div>
</div>
</body>
</html>
