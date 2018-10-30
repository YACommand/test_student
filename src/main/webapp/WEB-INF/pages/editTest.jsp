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

    <c:if test="${'success'.equals(add_test_status)}">
        <div class="alert alert-success" role="alert">
            Тест ${test.description} успешно создан!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${'error'.equals(add_test_status)}">
        <div class="alert alert-danger" role="alert">
            Не удалось создать тест!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <div class="card border-primary m-4">
        <form action="/tests/edit/" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="card-header">
                <input hidden name="id" value="${test.id}"/>
                <input required type="text" name="description" class="col-7" value="${test.description}">
                <input type="submit" class="btn btn-outline-primary" value="Сохранить"/>
            </div>
        </form>
        <div class="card-body text-primary">
            <h5 class="card-title">ID: ${test.id}</h5>
            <h5 class="card-title">Создал: ${test.teacher.name}</h5>
            <h5 class="card-title">Количество вопросов: ${test.questions.size()}</h5>

        </div>
        <div class="card-footer bg-transparent border-primary">
            <a class="btn btn-block btn-dark" href="/question/add/${test.id}" role="button">Добавить вопрос</a>
        </div>
    </div>

    <c:forEach items="${questions}" var="question">
        <div class="col-md m-4">
            <div class="card bg-light shadow-sm">
                <div class="card-header">
                    <h5 class="card-title">
                            ${question.text}
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
                <a class="btn btn-block btn-dark" href="<c:url value="/question/edit/${question.id}"/>" role="button">Редактировать</a>
                <a class="btn btn-block btn-outline-danger" href="<c:url value="/question/delete/${question.id}"/>"
                   role="button">Удалить</a>
            </div>
        </div>
        </div>
    </c:forEach>

</main>
<%@include file="footer-bootstrap.jsp" %>