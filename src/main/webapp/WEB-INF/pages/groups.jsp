<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Список групп</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Название</th>
            <th scope="col">Очное/Заочное</th>
            <th scope="col">Номер</th>
            <th scope="col" colspan="2" class="text-center">Действие</th>
        </tr>
        </thead>
        <c:forEach items="${groups}" var="group">
        <tbody>
        <tr>
            <th scope="row">${group.id}</th>
            <td>${group.name}</td>
            <td>${group.internal}</td>
            <td>${group.number}</td>
            <td><a href="<c:url value="/groups/edit/${group.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/groups/delete/${group.id}"/>">Удалить</a></td>
        </tr>
        </c:forEach>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </tbody>
    </table>
    <a class="btn btn-dark m-2" href="<c:url value="/groups/add"/>" role="button">Добавить</a>
</main>
<%@include file="footer-bootstrap.jsp" %>