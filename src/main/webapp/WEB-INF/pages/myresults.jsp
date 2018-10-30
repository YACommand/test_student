<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Мои результаты тестов</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">Тест</th>
            <th scope="col">Оценка</th>
        </tr>
        </thead>
        <c:forEach items="${results}" var="result">
        <tbody>
        <tr>
            <td>${result.test.description}</td>
            <td>${result.grade} %</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@include file="footer-bootstrap.jsp" %>