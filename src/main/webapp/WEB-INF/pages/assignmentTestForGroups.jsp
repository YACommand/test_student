<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">

    <div class="m-2">
        <form:form modelAttribute="tests" method="post" action="/teacher/assignmentTestForGroups">

            <div class="form-group row">
                <div class="form-check">
                    <c:forEach items="${tests}" var="test">
                        <input hidden name="groupId" value="${groupId}">
                        <input hidden name="group" value="${group}">
                        <tr>
                            <td><input type="checkbox"
                                       name="tests"
                                ${test.groups.contains(group) ? "checked" : ""}
                                       value="${test.id}"/> ${test.description}<br></td>
                        </tr>
                    </c:forEach>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
        </form:form>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>
