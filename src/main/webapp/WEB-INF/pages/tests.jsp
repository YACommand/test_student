<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Список тестов</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Название</th>
            <th scope="col">Преподаватель</th>
            <th scope="col">Количество вопросов</th>
            <th scope="col">Группы</th>
            <th scope="col" colspan="2" class="text-center">Действие</th>
        </tr>
        </thead>
        <c:forEach items="${tests}" var="test">
        <tbody>
        <tr>
            <th scope="row">${test.id}</th>
            <td>${test.description}</td>
            <td>${test.teacher.name}</td>
            <td>${test.questions.size()}</td>
            <td>
                <c:forEach items="${test.groups}" var="group">
                    ${group.number}
                </c:forEach>
            </td>
            <td><a href="<c:url value="/tests/edit${test.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/tests/delete/${test.id}"/>">Удалить</a></td>
        </tr>
        </c:forEach>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </tbody>
    </table>
    <a class="btn btn-dark m-2" href="<c:url value="/tests/add"/>" role="button">Добавить</a>
</main>
<%@include file="footer-bootstrap.jsp" %>