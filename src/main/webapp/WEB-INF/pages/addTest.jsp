<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <div class="card border-primary m-4">
        <form action="/tests/add/" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="card-header">
                <label for="description">Введите название теста: </label>
                <input required id="description" type="text" name="description" class="col-10">
                <input type="submit" class="btn btn-primary" value="Создать тест"/>
            </div>
        </form>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>
