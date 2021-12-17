<%--
  Created by IntelliJ IDEA.
  User: syed_
  Date: 11/21/2021
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>LabTask</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

<form:form action="process-request" modelAttribute="product">
    Product ID:
    <form:input path="productId" />
    <form:errors path="productId" cssClass="error"/>
    <br><br>
    Product Name:
    <form:input path="productName"/>
    <form:errors path="productName" cssClass="error"/>
    <br><br>
    Quantity:
    <form:input path="quantity"/>
    <form:errors path="quantity" cssClass="error"/>
    <br><br>
    Category:
    <form:select path="category">
        <form:options items="${categories}" />
    </form:select>
    <br><br>
    <input type="submit" value="submit">
</form:form>

</body>
</html>
