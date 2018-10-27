<%--<%@include file="header-bootstrap.jsp" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<form class="form-signin">--%>
    <%--<img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
    <%--<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>--%>
    <%--<label for="Login" class="sr-only">Login</label>--%>
    <%--<input type="Login" id="input" class="form-control" placeholder="Email address" required autofocus>--%>
    <%--<label for="inputPassword" class="sr-only">Password</label>--%>
    <%--<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>--%>
    <%--&lt;%&ndash;<div class="checkbox mb-3">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<label>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input type="checkbox" value="remember-me"> Remember me&ndash;%&gt;--%>
        <%--&lt;%&ndash;</label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
    <%--<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>--%>
<%--</form>--%>
<%--<%@include file="footer-bootstrap.jsp" %>--%>

<%--&lt;%&ndash;<form action="/login" method="post">--%>
    <%--<div><label> User Name : <input type="text" name="username"/> </label></div>--%>
    <%--<div><label> Password: <input type="password" name="password"/> </label></div>--%>
    <%--<div><input type="submit" value="Sign In"/></div>--%>
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--</form>--%>
<%--<a href="<c:url value="/registration"/>">Регистрация новго пользователя.</a>--%>
<%--&ndash;%&gt;--%>

<%--<%@ page language="java" contentType="text/html; charset=utf8"--%>
         <%--pageEncoding="utf8"%>--%>
<%--<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>--%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf8">--%>
    <%--<title><spring:message code="label.title" /></title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<a href="<c:url value="/index" />">--%>
    <%--<spring:message code="label.contacts" />--%>
<%--</a><br/>--%>

<%--<c:if test="${not empty param.error}">--%>
    <%--<font color="red"> <spring:message code="label.loginerror" />--%>
        <%--: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>--%>
<%--</c:if>--%>
<%--<form method="POST" action="<c:url value="/j_spring_security_check" />">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td align="right"><spring:message code="label.login" /></td>--%>
            <%--<td><input type="text" name="j_username" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td align="right"><spring:message code="label.password" /></td>--%>
            <%--<td><input type="password" name="j_password" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td align="right"><spring:message code="label.remember" /></td>--%>
            <%--<td><input type="checkbox" name="_spring_security_remember_me" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2" align="right"><input type="submit" value="Login" />--%>
                <%--<input type="reset" value="Reset" /></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<form action="/j_spring_security_check" method="POST">
    <label for="username">User Name:</label>
    <input id="username" name="j_username" type="text"/>
    <label for="password">Password:</label>
    <input id="password" name="j_password" type="password"/>
    <input type="submit" value="Log In"/>
</form>
</body>
<%@include file="footer-bootstrap.jsp" %>
