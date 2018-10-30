<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->

<main role="main" class="container">
    Список студентов
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Имя</th>
            <th scope="col">Логин</th>
            <th scope="col">Оценка</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
        <tbody>
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>неуд</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</main>


<%@include file="footer-bootstrap.jsp"%>