
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale" scope="session" value="${param.locale}" />
<fmt:setLocale  value="${locale}" scope="session"/>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- Place your stylesheet here-->
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
    <link href="jsp/main.css" rel="stylesheet">

</head>

<body>
<header></header>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top" >


    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="#"><fmt:message key="home" /><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="javascript:calculate()"><fmt:message key="calculating" /><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="javascript:sh()"><fmt:message key="about.us" /><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link"  href="/language?locale=ru" ><img src="https://img.icons8.com/color/48/000000/russian-federation.png" height="35px"><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/language?locale=en" ><img src="https://img.icons8.com/color/48/000000/usa.png" height="40px"><span class="sr-only">(current)</span></a>
            </li>


        </ul>

        <div class=" header-h1" id ="heder">
            <h1><fmt:message key="trucking.is" /></h1>
        </div>



        <button data-toggle="modal" data-target="#exampleModal"class="btn btn-primary btn-lg btn-space" type="submit" onClick='location.href="javascript:sh4()"'  ><fmt:message key="login" /></button>
        <button class="btn btn-primary btn-lg btn-space" type="submit" onClick='location.href="javascript:sh1()"'><fmt:message key="register" /></button>
    </div>



</nav>


<br><br><br>
<main role="main" class="container">
    <div class="bfh-selectbox bfh-languages" data-language="en_US" data-available="en_US,fr_CA,es_MX" data-flags="true">
        <input type="hidden" value="">
        <a class="bfh-selectbox-toggle" role="button" data-toggle="bfh-selectbox" href="#">
            <span class="bfh-selectbox-option input-medium" data-option=""></span>
            <b class="caret"></b>
        </a>
        <div class="bfh-selectbox-options">
            <div role="listbox">
                <ul role="option">
                </ul>
            </div>
        </div>
    </div>

    <div id="griting">
    <h1 class="text-center"><fmt:message key="you.can.just" /></h1>
    <h2 class="text-center"><fmt:message key="all.you.need" /></h2></div>
    <div class="text-center mt-5 pt-5" id="info" style="padding-top:15px;">
        <h3><fmt:message key="our.company.has" /></h3>
    </div>
    <div class="form" id = "form1">
        <form action="/login" method="post">


            <div>
                <label for="exampleInputEmail1"><fmt:message key="email.address" /></label>
                <input required type="email" name="useremail" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" placeholder="Enter email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
                <small id="emailHelp1" class="form-text text-muted"><fmt:message key="we'll.never.email" /></small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1"><fmt:message key="password" /></label>
                <input required type="password" name="userpassword" class="form-control" id="exampleInputPassword2" placeholder="Password" pattern=[A-Za-zА-Яа-яЁё0-9]{6,} >
            </div>
            <button type="submit" class="btn btn-primary" ><fmt:message key="submit" /></button>
        </form></div>
    <div class="form" id = "form">
        <form action="adduser" method="post">
            <div class="form-group">
                <label for="name"><fmt:message key="your.name" /></label>
                <input type="text" name="username" class="form-control" id="name" aria-describedby="basic-addon2" placeholder="Enter name">
                <small id="nameHelp" class="form-text text-muted"><fmt:message key="we'll.never" /></small>
            </div>
            <div class="form-group">
                <label for="phone"><fmt:message key="phone" /></label>
                <input type="tel" name="userphone" class="form-control" id="phone" placeholder="0671234567" pattern="[0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}" >
            </div>
            <div>
                <label for="exampleInputEmail1"><fmt:message key="email.address" /></label>
                <input type="email" name="useremail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
                <small id="emailHelp" class="form-text text-muted"><fmt:message key="we'll.never.email" /></small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1"><fmt:message key="password" /></label>
                <input type="password" name="userpassword" class="form-control" id="exampleInputPassword1" placeholder="000000" pattern=[A-Za-zА-Яа-яЁё0-9]{6,}>
            </div><br><br>
            <button type="submit" class="btn btn-primary" ><fmt:message key="submit" /></button>
        </form></div>
    <button id="send" class="btn btn-primary btn-lg btn-space" type="submit" onClick='location.href="javascript:sh2()"'><fmt:message key="send.message" /></button>

    <div class="w3-container w3-light-grey" style="padding:128px 16px" id="contact">
        <h3 class="w3-center"><fmt:message key="contact" /></h3>
        <p class="w3-center w3-large"><fmt:message key="lets.get" /></p>
        <div style="margin-top:48px">
            <p><i class="fa fa-map-marker fa-fw w3-xxlarge w3-margin-right"></i><fmt:message key="kiev.ua" /></p>
            <p><i class="fa fa-phone fa-fw w3-xxlarge w3-margin-right"></i><fmt:message key="phone.+" /></p>
            <p><i class="fa fa-envelope fa-fw w3-xxlarge w3-margin-right"> </i><fmt:message key="email1" /></p>
            <br>
            <form action="/addmessage"  method="post">

                <p><input class="w3-input w3-border" type="email" placeholder="Email" required name="useremail"></p>

                <p><input class="w3-input w3-border" type="text" placeholder="Message" required name="usermessage"></p>
                <p>
                    <button class="w3-button w3-black" type="submit" onClick='location.href="javascript:sh2()"' >
                        <i class="fa fa-paper-plane"></i><fmt:message key="Send.message" />
                    </button>
                </p>
            </form>


        </div>
    </div>



</main>



<footer class="footer">
    <div class="container">
        <p class="pep"><fmt:message key="copiright" /></p><p class="pep1"><a href="#"><img src="https://img.icons8.com/windows/32/000000/youtube.png"></a></p><p><a href="#"><img src="https://img.icons8.com/windows/32/000000/instagram-new.png"></a></p>
    </div>
</footer>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src = "jsp/js1.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

</body>
</html>