<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Список студентов</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Логин</th>
            <th scope="col">Имя</th>
            <th scope="col">Группа</th>
            <th scope="col">Роли</th>
            <th scope="col" colspan="2" class="text-center">Действие</th>
        </tr>
        </thead>
        <c:forEach items="${students}" var="student">
        <tbody>
        <tr>
            <th scope="row">${student.id}</th>
            <td>${student.login}</td>
            <td>${student.name}</td>
            <td>
                <c:if test="${student.groups.size() == 0}">
                    <a>Группа не назначена</a>
                </c:if>
                <c:forEach items="${student.groups}" var="group">
                    ${group.name} - ${group.number};
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${student.roles}" var="role">
                    ${role}
                </c:forEach>
            </td>
            <td><a href="<c:url value="/users/students/edit/${student.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/users/students/delete/${student.id}"/>">Удалить</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-dark m-2" href="<c:url value="/users/students/add"/>" role="button">Добавить</a>
</main>
<%@include file="footer-bootstrap.jsp"%>