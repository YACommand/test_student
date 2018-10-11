<%@ page import="ru.innopolis.stc13.student_test.pojo.Teacher" %>
<%@ page import="java.util.List" %>

<%@include file="header.jsp"%>

<%
    List<Teacher> list = (List<Teacher>) request.getAttribute("teachers");
    for (Teacher teacher : list) {%>
<a href="/teachers?id=<%=teacher.getId()%>">
    <%=teacher.getName()%>
    <%=teacher.getSpecialization()%>
    <%=teacher.getSpecialization()%>
</a><BR>
<%
    }
%>

<%@include file="footer.jsp"%>
