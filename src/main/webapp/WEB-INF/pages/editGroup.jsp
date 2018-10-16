<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->
<main role="main" class="container">

    <c:if test="${group.id != null}">
        <h3>Редактирование группы ${group.name}</h3>
    </c:if>
    <c:if test="${'created_error'.equals(error)}">
        <div class="alert alert-danger" role="alert">
            Группа уже существует!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${'updated_error'.equals(error)}">
        <div class="alert alert-danger" role="alert">
            Ошибка при сохранении изменений!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${'validation_error'.equals(error)}">
        <div class="alert alert-danger" role="alert">
            Ошибка валидации! Все поля должны быть заполнены!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${'number_error'.equals(error)}">
        <div class="alert alert-danger" role="alert">
            Ошибка номера группы! Группа с таким номером уже существует!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="m-2">
        <form:form modelAttribute="group" method="post" action="/groups/save">
            <c:if test="${group.id != null}">
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
                <form:label path="name" class="col-sm-2 col-form-label">
                    <spring:message text="Название"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input class="form-control" placeholder="Введите название" path="name" required="required"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="number" class="col-sm-2 col-form-label">
                    <spring:message text="Номер"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input path="number" class="form-control" placeholder="Введите номер" required="required"/>
                </div>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <form:label path="internal" class="col-sm-2 col-form-label">
                        <spring:message text="Очное/Заочное"/>
                    </form:label>
                    <div class="input-group-text">
                        <form:checkbox path="internal"/>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
        </form:form>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>