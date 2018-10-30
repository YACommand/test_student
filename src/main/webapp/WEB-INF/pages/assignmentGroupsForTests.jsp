<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">

    <div class="m-2">
        <form:form modelAttribute="groups" method="post" action="/user_page/assignmentGroupsForTests">

            <div class="form-group row">
                <div class="form-check">
                    <c:forEach items="${groups}" var="group">
                        <input hidden name="testId" value="${testId}">
                        <tr>
                            <td><input type="checkbox"
                                       name="groups"
                                <%--${student.groups.contains(group) ? "checked" : ""}--%>
                                       value="${group.id}"/> ${group.name} - ${group.number}<br></td>
                        </tr>
                    </c:forEach>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
        </form:form>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>
