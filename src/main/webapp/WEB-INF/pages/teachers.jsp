<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Список учителей</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Логин</th>
            <th scope="col">Имя</th>
            <th scope="col">Специализация</th>
            <th scope="col">Группы</th>
            <th scope="col">Роли</th>
            <th scope="col" colspan="2" class="text-center">Действие</th>
        </tr>
        </thead>
        <c:forEach items="${teachers}" var="teacher">
        <tbody>
        <tr>
            <th scope="row">${teacher.id}</th>
            <td>${teacher.login}</td>
            <td>${teacher.name}</td>
            <td>${teacher.specialization.name}</td>
            <td>
                <c:if test="${teacher.groups.size() == 0}">
                    <a>Группа не назначена</a>
                </c:if>
                <c:forEach items="${teacher.groups}" var="group">
                    ${group.name} - ${group.number};
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${teacher.roles}" var="role">
                    ${role}
                </c:forEach>
            </td>
            <td><a href="<c:url value="/users/teachers/edit/${teacher.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/users/teachers/delete/${teacher.id}"/>">Удалить</a></td>
        </tr>
        </c:forEach>
        </tbody>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </table>
    <a class="btn btn-dark m-2" href="<c:url value="/users/teachers/add"/>" role="button">Добавить</a>
</main>
<%@include file="footer-bootstrap.jsp" %>