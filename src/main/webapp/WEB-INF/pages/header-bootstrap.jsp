<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="icon" href="../../../../favicon.ico">--%>

    <title>Student testing</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/sticky-footer-navbar.css"/>" rel="stylesheet">
</head>

<body>

<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/">STUDENT TESTING</a>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <security:authentication property="name" var="authuser"/>
            <ul class="navbar-nav mr-auto">
                <a class="nav-link disabled">Hello, ${authuser}</a>
            </ul>
            <c:if test="${'anonymousUser'.equals(authuser)}">
                <a class="btn btn-outline-primary" href="/login">Войти</a>
            </c:if>
            <c:if test="${!'anonymousUser'.equals(authuser)}">
                <form class="p-0 m-0" action="/logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" class="btn btn-outline-primary" value="Выйти">
                </form>
            </c:if>
        </div>
    </nav>
</header>
