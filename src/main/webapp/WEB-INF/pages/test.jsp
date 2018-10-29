<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Тест: ${test.description}</h3>
    <div class="card border-primary m-4">
        <div class="card-header">
            <h5 class="card-title">Название: ${test.description}</h5>
        </div>
        <div class="card-body text-primary">
            <h5 class="card-title">ID: ${test.id}</h5>
            <h5 class="card-title">Создал: ${test.teacher.name}</h5>
            <h5 class="card-title">Количество вопросов: ${test.questions.size()}</h5>
        </div>
    </div>

    <c:forEach items="${test.questions}" var="question">
        <div class="col-md m-4">
            <div class="card bg-light shadow-sm">
                <div class="card-header">
                    <h5 class="card-title">
                        id ${question.id}
                        text ${question.text}
                    </h5>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${question.answers}" var="answer">
                            <li class="list-group-item ${answer.isCorrect() ? "bg-success text-light" : "bg-light"}">
                                    ${answer.content}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>
</main>
<%@include file="footer-bootstrap.jsp" %>

