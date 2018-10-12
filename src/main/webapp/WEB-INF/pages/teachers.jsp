<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teachers</title>
</head>
<body>
<a href="<c:url value="/teachers/add"/>">Добавить</a>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Specialization</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <c:forEach items="${teachers}" var="teacher">
        <jsp:useBean id="teacher" scope="page" type="ru.innopolis.stc13.student_test.pojo.Teacher"/>
        <tr>
            <td>${teacher.name}</td>
            <td>${teacher.specialization}</td>
            <td><a href="<c:url value="/teachers/edit/${teacher.id}"/>">Редактировать</a></td>
            <td><a href="<c:url value="/teachers/delete/${teacher.id}"/>">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
</body>

