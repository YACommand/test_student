<%@include file="header-bootstrap.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main role="main" class="container">
    <div class="container" style="width: 300px;">
        <body class="text-center login">
        <c:url value="/login" var="loginUrl"/>
        <form class="form-signin" action="${loginUrl}" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputLogin" class="sr-only">Login</label>
            <input required autofocus type="login" id="inputLogin" class="form-control" name="j_username"
                   placeholder="Login">
            <label for="inputPassword" class="sr-only">Password</label>
            <input required type="password" id="inputPassword" class="form-control" name="j_password"
                   placeholder="Password">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
            <p class="mt-5 mb-3 text-muted">ru.innopolis.stc13.YACommand&copy; 2017-2018</p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <c:if test="${not empty sessionScope.message}">
            <span style="color:green"><c:out value="${sessionScope.message}"/></span>
            <c:remove var="message" scope="session"/>
        </c:if>

        </body>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>