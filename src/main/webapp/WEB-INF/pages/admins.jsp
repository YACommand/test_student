<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Список администраторов</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Логин</th>
            <th scope="col">Имя</th>
            <th scope="col">Роли</th>
            <th scope="col" colspan="2" class="text-center">Действие</th>
        </tr>
        </thead>
        <c:forEach items="${admins}" var="admin">
        <tbody>
        <tr>
            <th scope="row">${admin.id}</th>
            <td>${admin.login}</td>
            <td>${admin.name}</td>
            <td>
                <c:forEach items="${admin.roles}" var="role">
                    ${role}
                </c:forEach>
            </td>
            <td><a href="<c:url value="/users/admins/edit/${admin.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/users/admins/delete/${admin.id}"/>">Удалить</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-dark m-2" href="<c:url value="/users/admins/add"/>" role="button">Добавить</a>
</main>
<%@include file="footer-bootstrap.jsp" %>