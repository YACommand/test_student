<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">

    <c:if test="${teacher.id != null}">
        <h3>Редактирование учителя ${teacher.name}</h3>
    </c:if>
    <div class="m-2">
        <form:form modelAttribute="teacher" method="post" action="/teachers/save">
            <c:if test="${teacher.id != null}">
                <div class="form-group row">
                    <form:label path="id" class="col-sm-2 col-form-label">
                        <spring:message text="ID"/>
                    </form:label>
                    <div class="col-sm-5">
                        <form:input class="form-control" path="id" readonly="true"/>
                    </div>
                </div>
            </c:if>
            <div class="form-group row">
                <form:label path="login" class="col-sm-2 col-form-label">
                    <spring:message text="Логин"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input class="form-control" placeholder="Введите логин" path="login"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="password" class="col-sm-2 col-form-label">
                    <spring:message text="Пароль"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input path="password" class="form-control" placeholder="Введите пароль"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="name" class="col-sm-2 col-form-label">
                    <spring:message text="Имя"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input path="name" class="form-control" placeholder="Введите имя"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="specialization" class="col-sm-2 col-form-label">
                    <spring:message text="Специализация"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input path="specialization" class="form-control" placeholder="Введите специализацию"/>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
        </form:form>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>
