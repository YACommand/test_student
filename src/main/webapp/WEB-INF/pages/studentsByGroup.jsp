<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->

<main role="main" class="container">
    <c:if test="${users.isEmpty()}">
        <br>Список студентов пуст
    </c:if>
    <c:if test="${!users.isEmpty()}">
        Список студентов
        <table class="table table-hover text-left">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Имя</th>
                <th scope="col">Логин</th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
            <tbody>
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.name}</td>
                <td>${user.login}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
</main>


<%@include file="footer-bootstrap.jsp"%>