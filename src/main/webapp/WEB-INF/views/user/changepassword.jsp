<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="../elements/header.jsp"/>
<section>
    <h1 class="title">
        Zmiana hasła
    </h1>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <h1>Nowe hasło</h1>
            <form:password path="password" required="true" placeholder="${newPasswordPlaceholder}"/>
            <form:errors path="password" element="p"/>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zmień hasło</button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

</body>
</html>
