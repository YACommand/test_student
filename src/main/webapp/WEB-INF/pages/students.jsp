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
    </tr>
    </thead>
    <c:forEach items="${students}" var="student">
        <jsp:useBean id="student" scope="page" type="ru.innopolis.stc13.student_test.pojo.Student"/>
        <tr>
            <td>${student.name}
            </td>
            <td>${student.group}
            </td>
        </tr>
    </c:forEach>
</table>
<%--<%
    List<Student> list = (List<Student>) request.getAttribute("students");
    for (Student student : list) {%>
<a href="/students?id=<%=student.getId()%>">
    <%=student.getName()%>
    <%=student.getGroup()%>
</a><BR>
<%
    }
%>--%>
</body>
</html>
