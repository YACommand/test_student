<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<!-- Begin page content -->
<main role="main" class="container">

    <c:if test="${student.id != null}">
        <h3>Редактирование студента ${student.name}</h3>
    </c:if>
    <c:if test="${student.id == null}">
        <h3>Добавление нового студента ${student.name}</h3>
    </c:if>
    <c:if test="${'created_error'.equals(error)}">
        <div class="alert alert-danger" role="alert">
            Пользователь с таким логином уже существует!
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
    <div class="m-2">
        <form:form modelAttribute="student" method="post" action="/users/students/save">
            <c:if test="${student.id != null}">
                <div class="form-group row">
                    <form:label path="id" class="col-sm-2 col-form-label">
                        <spring:message text="ID"/>
                    </form:label>
                    <div class="col-sm-5">
                        <form:input class="form-control" path="id" readonly="true" required="required"/>
                    </div>
                </div>
            </c:if>
            <div class="form-group row">
                <form:label path="login" class="col-sm-2 col-form-label">
                    <spring:message text="Логин"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input class="form-control" placeholder="Введите логин" path="login" required="required"/>
                </div>
            </div>
            <c:if test="${student.id != null}">
                <form:hidden path="password" class="form-control" placeholder="Введите пароль" required="required"/>
            </c:if>
            <c:if test="${student.id == null}">
                <div class="form-group row">
                    <form:label path="password" class="col-sm-2 col-form-label">
                        <spring:message text="Пароль"/>
                    </form:label>
                    <div class="col-sm-5">
                        <form:input path="password" class="form-control" placeholder="Введите пароль"
                                    required="required"/>
                    </div>
                </div>
            </c:if>
            <div class="form-group row">
                <form:label path="name" class="col-sm-2 col-form-label">
                    <spring:message text="Имя"/>
                </form:label>
                <div class="col-sm-5">
                    <form:input path="name" class="form-control" placeholder="Введите имя" required="required"/>
                </div>
            </div>

            <div class="form-group row">
                <form:label path="groups" class="col-sm-2">
                    <spring:message text="Группы"/>
                </form:label>
                <div class="form-check">
                    <c:forEach items="${groups}" var="group">
                        <tr>
                            <td><input type="checkbox"
                                       name="groups"
                                ${student.groups.contains(group) ? "checked" : ""}
                                       value="${group.id}"/> ${group.name} - ${group.number}<br></td>
                        </tr>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="roles" class="col-sm-2">
                    <spring:message text="Роли"/>
                </form:label>
                <div class="form-check">
                    <form:checkboxes element="div class='form-check-label'" class="form-check-input" path="roles"
                                     items="${roles}"/>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
            <c:if test="${student.id!=null}">
                <a class="btn btn-dark m-2" href="<c:url value="/users/students/editPassword/${student.id}"/>"
                   role="button">Изменить пароль</a>
            </c:if>
        </form:form>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>

