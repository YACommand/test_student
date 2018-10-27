<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">

    <h3>Тест: ${test.description}</h3>

    <form method="post" action="/tests/done">
        <input type="hidden" name="id" value="${test.id}">

        <c:forEach items="${questions}" var="question">
            <div class="col-md-6 m-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${question.text}</h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${question.answers}" var="answer">
                            <li class="list-group-item">
                                <input type="radio" name="answer${question.id}" value="${answer.id}"/> ${answer.content}<br>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </c:forEach>
        <input type="submit" class="btn btn-dark" value="Завершить"/>
    </form>
</main>
<%@include file="footer-bootstrap.jsp" %>