<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 11.10.2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Teacher</title>
</head>
<body>
<form:form method="post" action="/teachers/save" modelAttribute="teacher" >
    <form:label path="id">
        <spring:message text="ID"/>
    </form:label>
    <form:input path="id" readonly="true"/> <br>
    <form:label path="login">
        <spring:message text="Логин"/>
    </form:label>
    <form:input path="login" /> <br>
    <form:label path="password">
        <spring:message text="Пароль"/>
    </form:label>
    <form:input path="password"/><br>
    <form:label path="name">
        <spring:message text="Имя"/>
    </form:label>
    <form:input path="name"/><br>
    <form:label path="specialization">
        <spring:message text="Специализация"/>
    </form:label>
    <form:input path="specialization"/><br>
    <input type="submit" value="Сохранить">
</form:form>
</body>
</html>
