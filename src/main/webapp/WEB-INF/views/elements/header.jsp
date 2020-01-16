<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="/admin/admins" class="btn btn--small btn--without-border">Administratorzy</a></li>
                <li><a href="/admin/users" class="btn btn--small btn--without-border">Użytkownicy</a></li>
                <li><a href="/admin/institutions" class="btn btn--small btn--without-border">Instytucje</a></li>

            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <li><a href="/user/donations" class="btn btn--small btn--without-border">Moje dary</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('USER')">
                <li><a href="/user/manage" class="btn btn--small btn--without-border">Moje konto</a></li>
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
            <li>
                <c:url var="home" value="/"/>
                <a href="${home}" class="btn btn--without-border active">
                    Start
                </a>
            </li>
            <li><a href="/#steps" class="btn btn--without-border"><spring:message code="pages.what.is.going.on"/></a></li>
            <li><a href="/#about-us" class="btn btn--without-border"><spring:message code="pages.about"/></a></li>
            <li><a href="/#help" class="btn btn--without-border"><spring:message code="pages.fundations.and.organization"/></a></li>
            <sec:authorize access="hasRole('USER')">
                <li>
                    <c:url var="userDonation" value="/form"/>
                    <a href="${userDonation}" class="btn btn--without-border">
                        Utwórz donacje
                    </a>
                </li>
            </sec:authorize>
            <li><a href="#contact" class="btn btn--without-border"><spring:message code="pages.contact"/></a></li>
        </ul>
    </nav>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/app2.js"/>"></script>
</header>
