<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/elements/head.jsp"/>
</head>
<body>

    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj Agata
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="#">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
        <li><a href="#" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border"><spring:message code="pages.what.is.going.on"/></a></li>
        <li><a href="#" class="btn btn--without-border"><spring:message code="pages.about"/></a></li>
        <li><a href="#" class="btn btn--without-border"><spring:message code="pages.fundations.and.organization"/></a></li>
        <li><a href="#" class="btn btn--without-border"><spring:message code="pages.contact"/></a></li>
    </ul>
    </nav>





</body>
</html>
