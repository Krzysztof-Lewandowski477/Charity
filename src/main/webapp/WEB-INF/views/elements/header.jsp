<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="" class="btn btn--small btn--without-border"><spring:message code="pages.login"/> </a></li>
            <li><a href="#" class="btn btn--small btn--highlighted"><spring:message code="pages.create.account"/></a></li>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="pages.what.is.going.on"/></a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="pages.about"/></a></li>
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
