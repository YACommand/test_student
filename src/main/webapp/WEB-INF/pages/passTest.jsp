<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">

    <div class="card border-primary m-4">
        <div class="card-header">
            <h5 class="card-title">Название: ${test.description}</h5>
        </div>
    </div>

    <form method="post" action="/student/done">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="${test.id}">

        <c:forEach items="${questions}" var="question">
            <div class="col-md m-4">
                <div class="card bg-light shadow-sm">
                    <div class="card-header">
                        <h5 class="card-title">${question.text}</h5>
                    </div>
                    <div class="card-body">
                        <ul class="list-group list-group-flush">
                            <c:forEach items="${question.answers}" var="answer">
                                <li class="list-group-item bg-light">
                                    <label><input type="radio" name="answer${question.id}"
                                                  value="${answer.id}"/> ${answer.content}</label>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
        <input type="submit" class="btn btn-dark" value="Завершить"/>
    </form>
</main>
<%@include file="footer-bootstrap.jsp" %>