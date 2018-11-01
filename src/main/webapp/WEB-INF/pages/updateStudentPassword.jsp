<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main role="main" class="container">
    <div class="m-2">
        <form method="post" action="/users/students/editPassword">
            <div class="form-group row">
                <input name="id" hidden value="${user.id}"/>
                <label class="col-sm-2">
                    Пароль
                </label>
                <div class="col-sm-4">
                    <input class="form-control" placeholder="Введите пароль" name="password" required>
                </div>
            </div>
            <button type="submit" class="btn btn-dark">Сохранить</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</main>
<%@include file="footer-bootstrap.jsp" %>