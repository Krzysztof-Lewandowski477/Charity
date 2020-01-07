
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<section class="">
    <h2>Edytuj dane</h2>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <h1>Nowy email:</h1><form:input path="email" name="email" placeholder="Nowy email"/>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Edytuj</button>
        </div>
    </form:form>
</section>
</body>
</html>
