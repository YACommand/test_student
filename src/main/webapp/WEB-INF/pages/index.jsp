<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="header-bootstrap.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Begin page content -->
<main role="main" class="container">
    <div>
        <form id="logout" action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <ul class="list-group-item-dark m-2">

        <security:authorize access="hasAnyAuthority('TEACHER','ADMIN')">
            <li><a href="/tests">Tests</a></li>
            <li><a href="/users/students">Students</a></li>
            <security:authorize access="hasAuthority('ADMIN')">
                <li><a href="/users/admins">Admins</a></li>
                <li><a href="/users/teachers">Teachers</a></li>
                <li><a href="/groups">Groups</a></li>
            </security:authorize>
        </security:authorize>
    </ul>
    </text>
    </html>
</main>
<%@include file="footer-bootstrap.jsp" %>