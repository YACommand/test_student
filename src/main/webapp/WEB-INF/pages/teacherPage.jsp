<%@ page import="ru.innopolis.stc13.student_test.pojo.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.stc13.student_test.pojo.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: maksim
  Date: 29.10.2018
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>

<main role="main" class="container">
    <br>
    Здравствуйте, ${user.name}!<br><br>
    Ваша специализация: ${user.specialization}<br><br>
    Список ваших групп:<br><br>

    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Название</th>
            <th scope="col">Номер</th>
            <th scope="col">Форма обучения</th>
            <th scope="col">Список студентов</th>
            <th scope="col">Назначить тест</th>
        </tr>
        </thead>
        <c:forEach items="${groups}" var="group">
        <tbody>
        <tr>
            <th scope="row">${group.id}</th>
            <td>${group.name}</td>
            <td>${group.number}</td>
            <td>${group.internal ? "Заочная" : "Очная"}</td>
            <td><a href="<c:url value="/user_page/groups/${group.id}"/>">Список студентов</a></td>
            <td>Типа ссылка на назначение теста</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <br><br>Список ваших тестов:<br><br>

    <table class="table table-hover text-left">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Описание</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <c:forEach items="${tests}" var="test">
        <tbody>
        <tr>
            <th scope="row">${test.id}</th>
            <td>${test.description}</td>
            <td><a href="<c:url value="/tests/edit/${test.id}"/>">Редактировать</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <br><a href="<c:url value="/tests/add"/>">Создать тест</a>

</main>


<%@include file="footer-bootstrap.jsp" %>