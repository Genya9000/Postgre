<%--
  Created by IntelliJ IDEA.
  User: genya9000
  Date: 10.06.19
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale" scope="session" value="${param.locale}" />
<fmt:setLocale  value="${empty sessionScope.locale ? 'en_US' : sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>

<html lang="en">


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href ="jsp/css/catalog.css">
</head>
<body>
<div class="container-fluid " align="center">
    <div class="row-fluid ">
        <div class=" error alert alert-danger ">
            <strong> ${pageContext.errorData.statusCode}</strong><br />
            <strong>
                <fmt:message key="server.error"/>
            </strong>
            <h3>Error Details</h3>
            <strong>Status Code</strong>: ${pageContext.errorData.statusCode}
            <br>
            <strong>Requested URI</strong>: ${pageContext.errorData.requestURI}
            <br>
            <strong>Exception Message: ${pageContext.errorData.throwable.message}</strong>

            <ul>
                <li><a href="index.jsp">Home Page</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
