<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<main role="main" class="container">
    <div class="m-2">
        <form:form modelAttribute="groups" method="post" action="/teacher/assignmentGroupsForTests">

            <div class="form-group row">
                <div class="form-check">
                    <c:forEach items="${groups}" var="group">
                        <input hidden name="testId" value="${testId}">
                        <input hidden name="test" value="${test}">
                        <tr>
                            <td><input type="checkbox"
                                       name="groups"
                                ${group.tests.contains(test) ? "checked" : ""}
                                       value="${group.id}"/> ${group.name} - ${group.number}<br></td>
                        </tr>
                    </c:forEach>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
        </form:form>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>
