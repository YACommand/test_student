<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">
    <c:if test="${question.id != null}">
        <h3>Редактирование вопроса id: ${question.id}</h3>
    </c:if>
    <c:if test="${question.id == null}">
        <h3>Добавление нового вопроса</h3>
    </c:if>
    <form:form action="/question/save" modelAttribute="question" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="col-md m-4">
            <div class="card bg-light shadow-sm">
                <div class="card-header">
                    <h5 class="card-title">
                        <div class="form-group">
                            <input name="questionId" value="${question.id}" hidden/>
                            <input name="testId" value="${question.test.id}" hidden/>
                            <label for="text">Текст</label>
                            <div class="col-12">
                                <textarea class="form-control" id="text" required
                                          name="text">${question.text}</textarea>
                            </div>
                        </div>
                    </h5>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <c:forEach var="answer" items="${question.answers}">
                            <li class="list-group-item bg-light">
                                <input type="text" name="answerId" value="${answer.id}" hidden/>
                                <div class="row">
                                    <div class="col-9">
                                        <input type="text" name="content${answer.id}" class="form-control"
                                               value="${answer.content}" required="required"/>
                                    </div>
                                    <div class="col-sm">
                                        <a class="btn btn-outline-danger"
                                           href="/question/delete_answer/${answer.id}" role="button">Удалить</a>
                                    </div>
                                </div>
                                <label>Правильный <input type="radio" name="correct${answer.id}"
                                    ${answer.isCorrect() ? "checked" : ""} value="${"true"}"/></label>
                                <label>Не правильный <input type="radio" name="correct${answer.id}"
                                    ${!answer.isCorrect() ? "checked" : ""} value="${"false"}"/></label>
                            </li>
                        </c:forEach>
                        <li class="list-group-item bg-light">
                            <input type="text" name="contentNew" class="form-control"
                                   value="${null}" placeholder="Новый ответ"/>
                            <label>Правильный <input type="radio" name="correctNew" value="${"true"}"/></label>
                            <label>Не правильный <input type="radio" name="correctNew" value="${"false"}"
                                                        checked/></label>
                        </li>
                    </ul>
                </div>
                <button type="submit" class="btn btn-dark">Сохранить</button>
            </div>
        </div>
    </form:form>
</main>
<%@include file="footer-bootstrap.jsp" %>