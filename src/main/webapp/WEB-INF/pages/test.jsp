<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <h3>Тест: ${test.description}</h3>
    <c:forEach items="${test.questions}" var="question">
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    id: ${question.id} <br>
                    text: ${question.text} <br>
                    answers:
                    <c:forEach items="${question.answers}" var="answer">
                        <br>${answer.content} ${answer.isCorrect()}
                    </c:forEach>
                    <br>
                </div>
            </div>
        </div>
    </c:forEach>
</main>
<%@include file="footer-bootstrap.jsp" %>