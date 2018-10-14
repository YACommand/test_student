<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="header.jsp" %>

<form:form method="post" action="/students/save" modelAttribute="student">
    <form:label path="id">
        <spring:message text="Id"/>
    </form:label>
    <form:input path="id" readonly="false"/>
    <br>
    <form:label path="login">
        <spring:message text="Login"/>
    </form:label>
    <form:input path="login" readonly="false"/>
    <br>
    <form:label path="password">
        <spring:message text="Password"/>
    </form:label>
    <form:input path="password" readonly="false"/>
    <br>
    <form:label path="name">
        <spring:message text="Name"/>
    </form:label>
    <form:input path="name" readonly="false"/>
    <br>
    <form:label path="group">
        <spring:message text="Group"/>
    </form:label>
    <form:input path="group" readonly="false"/>
    <input type="submit" value="Save">
</form:form>

<%@include file="footer.jsp" %>

</body>
</html>