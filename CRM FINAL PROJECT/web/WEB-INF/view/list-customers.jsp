<%--
  Created by IntelliJ IDEA.
  User: muhammad.shayaan
  Date: 9/29/2021
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Customer List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>CRM - Customer Relationship Manager </h1>
    </div>
    <div id="container">
        <div id="content">

            <button type="button" value="Add Customer" onclick="window.location.href = 'showFormForAdd'; return false;"
            class="add-button"
            >Add Customer</button>

<%--            add html table--%>
            <table >
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
<%--   loop over customers and print--%>
                <c:forEach var="tempCustomers" items="${customers}">
                    <%--                        construct an update link with customer id--%>

                    <c:url var="updateLink" value="/customer/showFormforUpdate">
                        <c:param name="customerId" value="${tempCustomers.id}"></c:param>
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomers.id}"></c:param>
                    </c:url>
                    <tr>
                        <td>${tempCustomers.first_name}</td>
                        <td>${tempCustomers.last_name}</td>
                        <td>${tempCustomers.email}</td>
                        <td><a href="${updateLink}">Update</a>
                        | <a href="${deleteLink}"
                            onclick="
                            if (!(confirm('Are you sure you want to delete this customer?')))
                                return false"
                            >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
