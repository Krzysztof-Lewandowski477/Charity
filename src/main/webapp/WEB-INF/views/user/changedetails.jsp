<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
<h2>Twoje dane</h2>
<form:form method="post" modelAttribute="user">


            <h3>Imię</h3>
            <form:input type="text" path="name" class="form-control" placeholder="First Name"
                        autofocus="true" id="inputFirstName"/>
            <form:errors path="name"/>
    <div class="form-group">

<%--        <form:input path="email" required="true" placeholder="${emailPlaceholder}"/>--%>
<%--        <form:errors path="email" element="p"/>--%>
    </div>
    <form:hidden path="email"/>
    <form:hidden name="id" path="id"/>
    <form:hidden path="password"/>
    <form:hidden path="active"/>
            <h3>Nazwisko</h3>
            <form:input type="text" path="surname" class="form-control" placeholder="Last Name"
                        autofocus="true"/>
            <form:errors path="surname"/>




    <div class="form-group form-group--buttons">
        <button class="btn" type="submit">Akceptuj zmiany</button>
    </div>
    <sec:csrfInput/>
</form:form>
</section>

</body>
</html>
