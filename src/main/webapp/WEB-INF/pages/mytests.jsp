<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Мои тесты</h3>
    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Преподаватель</th>
            <th scope="col">Количество вопросов</th>
            <th scope="col" class="text-center">Действие</th>
        </tr>
        </thead>
        <c:forEach items="${tests}" var="test">
        <tbody>
        <tr>
            <td>${test.description}</td>
            <td>${test.teacher.name}</td>
            <td>${test.questions.size()}</td>
            <td class="text-center"><a href="<c:url value="/student/passtest/${test.id}"/>">Пройти тест</a></td>
        </tr>
        </c:forEach>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </tbody>
    </table>
</main>
<%@include file="footer-bootstrap.jsp" %>