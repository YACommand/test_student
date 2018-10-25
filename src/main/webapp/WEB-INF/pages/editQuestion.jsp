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
        <div class="col-md-6 m-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">
                        <div class="form-group row">
                            <form:label path="text" class="col-sm-2 col-form-label">
                                <spring:message text="Text"/>
                            </form:label>
                            <div class="col-sm-10">
                                <form:textarea class="form-control" path="text" required="required"/>
                            </div>
                        </div>
                    </h5>
                </div>
                <ul class="list-group list-group-flush">
                    <c:forEach var="answer" items="${question.answers}">
                        <li class="list-group-item">

                            <input type="text" id="id" name="id" value="${answer.id}" hidden/>
                                    <input type="text" id="question" name="question" value="${answer.question.id}"
                                           hidden/>
                                    <input type="text" id="content" name="content" class="form-control"
                                           value="${answer.content}" required="required"/>

                        </li>
                    </c:forEach>
                </ul>
                <button type="submit" class="btn btn-dark">Сохранить</button>
            </div>
        </div>
    </form:form>
</main>
<%@include file="footer-bootstrap.jsp" %>