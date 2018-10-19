<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <c:if test="${test.id != null}">
        <h3>Редактирование теста ${test.description}</h3>
    </c:if>
    <c:if test="${test.id == null}">
        <h3>Добавление нового теста</h3>
    </c:if>
    <c:if test="${'status_change_error'.equals(error)}">
        <div class="alert alert-danger" role="alert">
            Ошибка при изменении статуса ответа!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:forEach items="${questions}" var="question">
        <div class="col-md-6 m-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">
                        text ${question.text}
                    </h5>
                    <p class="card-text">
                        id ${question.id} <br/>
                    </p>
                </div>
                <ul class="list-group list-group-flush">
                    <c:forEach items="${question.answers}" var="answer">
                        <li class="list-group-item">
                            <c:if test="${!answer.isCorrect()}">
                                <a class="col-sm-4" href="/tests/change_status/${test.id}/${answer.id}">Неверный</a>
                            </c:if>
                            <c:if test="${answer.isCorrect()}">
                                <a class="col-sm-4" href="/tests/change_status/${test.id}/${answer.id}">Верный</a>
                            </c:if>
                                ${answer.content} ${answer.isCorrect()}
                        </li>
                    </c:forEach>
                </ul>
                <a class="btn btn-dark" href="<c:url value="/question/edit/${question.id}"/>" role="button">Редактировать</a>
            </div>
        </div>
    </c:forEach>
</main>
<%@include file="footer-bootstrap.jsp" %>