<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sprng" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <jsp:include page="/WEB-INF/views/elements/head.jsp"/>
    <title>Index</title>
</head>
<body>
<%--header--%>
<jsp:include page="/WEB-INF/views/elements/header.jsp"/>

<%--header--%>
<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${quantities}</em>

            <h3><spring:message code="pages.index.body.quantity"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>5</em>
            <h3><spring:message code="pages.index.body.organizations"/> </h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section class="steps">
    <h2><spring:message code="pages.index.body.4steps"/></h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3><spring:message code="pages.index.body.4steps2"/></h3>
            <p><spring:message code="pages.index.body.4steps22"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3><spring:message code="pages.index.body.4steps23"/></h3>
            <p><spring:message code="pages.index.body.4steps24"/> </p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3><spring:message code="pages.index.body.4steps25"/></h3>
            <p><spring:message code="pages.index.body.4steps26"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3><spring:message code="pages.index.body.4steps27"/></h3>
            <p><spring:message code="pages.index.body.4steps28"/></p>
        </div>
    </div>

    <a href="#" class="btn btn--large"><spring:message code="pages.create.account"/></a>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2><spring:message code="pages.about"/></h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="./resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="./resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section class="help">
    <h2><spring:message code="pages.who.helps"/></h2>

    <!-- SLIDE 1 -->

    <div class="help--slides active" data-id="1">
        <p><spring:message code="pages.index.text.institution"/> </p>

        <ul class="help--slides-items">
            <li>
                <c:forEach items="${donations}" var="donation">
                <div class="col">
                    <div class="title">${donation.institution.name}</div>
                    <div class="subtitle">${donation.institution.description}</div>
                </div>
                </c:forEach>
                <div class="col">
                    <div class="title">Fundacja "A kogo"</div>
                    <div class="subtitle">Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Dla dzieci"</div>
                    <div class="subtitle">Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.</div>
                </div>
                <div class="col">
                    <div class="title">Fundacja “Bez domu”</div>
                    <div class="subtitle">Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania</div>
                </div>

            </li>

        </ul>
    </div>

</section>
<%--footer--%>
<jsp:include page="/WEB-INF/views/elements/footer.jsp"/>
<%--footer--%>
</body>
</html>
