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
    <h3>Список ваших групп</h3>

        <%
            User user = (User) request.getAttribute("user");
            List<Group> list = new ArrayList<Group>();
            list.addAll(user.getGroups());
            for (Group group : list) {%>
        <%=group.getName()%> - <%=group.getNumber()%>
        </a><BR>
        <%
            }
        %>
</main>


<%@include file="footer-bootstrap.jsp" %>