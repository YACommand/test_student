<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Hello jsp</title>
</head>
<text>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 ${admin}
</text>
</html>