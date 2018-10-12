<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Specialization</th>
    </tr>
    </thead>
    <c:forEach items="${teachers}" var="teacher">
        <jsp:useBean id="teacher" scope="page" type="ru.innopolis.stc13.student_test.pojo.Teacher"/>
        <tr>
            <td>${teacher.name}
            </td>
            <td>${teacher.specialization}
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="footer.jsp" %>