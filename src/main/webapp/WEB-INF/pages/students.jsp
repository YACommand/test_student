<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.10.2018
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Group</th>
        <th>Add</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    </thead>
    <c:forEach items="${students}" var="student">
        <jsp:useBean id="student" scope="page" type="ru.innopolis.stc13.student_test.pojo.Student"/>
        <tr>
            <td>${student.name}
            </td>
            <td>${student.group}
            </td>
            <th>
                <a href="<c:url value='/students/add/${student.id}'/>">Add</a>
            </th>
            <th>
                <a href="<c:url value='/students/remove/${student.id}'/>">Delete</a>
            </th>
            <th>
                <a href="<c:url value='/students/update/${student.id}'/>">Update</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
