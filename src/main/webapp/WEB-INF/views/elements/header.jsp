<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<header class="header--main-page">
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
        <div class="slogan--item">
            <h1>
                <spring:message code="pages.content.header"/>
            </h1>
        </div>
    </div>
</header>
