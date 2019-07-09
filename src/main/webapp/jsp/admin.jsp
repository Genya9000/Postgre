<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="prog" uri="/WEB-INF/tld/testTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale" scope="session" value="${param.locale}"/>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Traffic</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- Place your stylesheet here-->
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
    <link href="jsp/main1.css" rel="stylesheet">

</head>

<body>
<header></header>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">


    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="#"><fmt:message key="home"/><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="javascript:calculate()"><fmt:message key="calculating"/><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="javascript:sh()"><fmt:message key="about.us"/><span
                        class="sr-only">(current)</span></a>
            </li>


        </ul>

        <div class=" header-h1" id="heder">
            <h1><fmt:message key="trucking.is"/></h1>
        </div>


        <%--        <button data-toggle="modal" data-target="#exampleModal"class="btn btn-primary btn-lg btn-space" type="submit" onClick='location.href="javascript:sh4()"'  ><fmt:message key="login" /></button>--%>
        <button class="btn btn-primary btn-lg btn-space" type="submit" onClick='location.href="/login?a=exit"'>
            <fmt:message key="logout"/></button>
    </div>


</nav>


<br><br><br>
<main role="main" class="container">


    <div id="griting">
        <h1 class="text-center"><fmt:message key="admin"/></h1>
        <h2 class="text-center"><fmt:message key="today"/> <prog:date/></h2>

    </div>
    <div class="text-center mt-5 pt-5" id="info" style="padding-top:15px;">
        <h3><fmt:message key="our.company.has"/></h3>
    </div>
    <table class="table">
        <caption><fmt:message key="list.orders"/></caption>
        <thead>
        <tr>

            <th scope="col">userId</th>
            <th scope="col">type</th>
            <th scope="col">weight</th>
            <th scope="col">date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="list">
        <tr>

            <td>${list.getUserId()}</td>
            <td>${list.getType()}</td>
            <td>${list.getWeight()}</td>
            <td>${list.getDate()}</td>

        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="form" id="form2">

    <button id="send" class="btn btn-primary btn-lg btn-space" type="submit" onClick='location.href="/addorder?limit1=5&limit2=0"'>
        <fmt:message key="show"/></button>

    </div>
    <div id="pagination">
    <nav aria-label="Page navigation example">
        <ul class="pagination">

            <li class="page-item"><a class="page-link" href="/addorder?limit5=0&limit2=1">1</a></li>
            <li class="page-item"><a class="page-link" href="/addorder?limit1=5&limit2=10">2</a></li>
            <li class="page-item"><a class="page-link" href="/addorder?limit1=10&limit2=15">3</a></li>

        </ul>
    </nav></div>
</main>


<footer class="footer">
    <div class="container">
        <p class="pep"><fmt:message key="copiright"/></p>
        <p class="pep1"><a href="#"><img src="https://img.icons8.com/windows/32/000000/youtube.png"></a></p>
        <p><a href="#"><img src="https://img.icons8.com/windows/32/000000/instagram-new.png"></a></p>
    </div>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script src="jsp/js1.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

</body>
</html>