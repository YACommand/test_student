<%@include file="header-bootstrap.jsp" %>
<%@include file="header-bootstrap.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Your login">
        <input type="password" class="form-control" name="j_password" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
</body>
<%@include file="footer-bootstrap.jsp" %>

