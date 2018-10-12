<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

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

<%@include file="footer.jsp" %>
