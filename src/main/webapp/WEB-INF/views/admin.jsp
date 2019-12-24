<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Oddaj rzeczy</title>

    <link rel="stylesheet" href="<c:url value="./resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">
        <nav class="container container--70">
            <ul class="nav--actions">
                <sec:authentication var="user" property="principal"/>
                <sec:authorize access="isAnonymous()">
                    <li><a href="/login" class="btn btn--small btn--without-border"><spring:message code="pages.login"/> </a></li>
                    <li><a href="/register" class="btn btn--small btn--highlighted"><spring:message code="pages.create.account"/></a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="/" class="btn btn--small btn--without-border">Administratorzy</a></li>
                    <li><a href="/" class="btn btn--small btn--without-border">Użytkownicy</a></li>
                    <li><a href="/login" class="btn btn--small btn--without-border">Instytucje</a></li>

                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form method="post" action="/logout">
                            <button class="btn btn--small btn--without-border" type="submit">Wyloguj</button>
                            <sec:csrfInput/>
                        </form>
                    </li>
                </sec:authorize>
            </ul>
            <ul>
                <li><a href="/" class="btn btn--without-border active">Start</a></li>
                <li><a href="#about" class="btn btn--without-border"><spring:message code="pages.what.is.going.on"/></a></li>
                <li><a href="#about" class="btn btn--without-border"><spring:message code="pages.about"/></a></li>
                <li><a href="#" class="btn btn--without-border"><spring:message code="pages.fundations.and.organization"/></a></li>
                <li><a href="#" class="btn btn--without-border"><spring:message code="pages.contact"/></a></li>
            </ul>
        </nav>
    <div class="slogan container container--90">
        <h2>
            To jest widoczne dla administratora tylko po zalogowaniu.
        </h2>
    </div>
</header>

<%@include file="./elements/footer.jsp" %>

<script src="<c:url value="./resources/js/app.js"/>"></script>
</body>
</html>
