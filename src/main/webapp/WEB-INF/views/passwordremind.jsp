<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">
<head>

    <jsp:include page="/WEB-INF/views/elements/head.jsp"/>

</head>
<body>
    <jsp:include page="/WEB-INF/views/elements/header.jsp"/>
<section class="">
    <h2>Reset Email</h2>
    <form:form modelAttribute="rePassword" method="post">
        <div class="form-group">
            <div class="control has-icons-left">
                email
                <c:input path="email" placeholder="${emailPlaceholder}" />
                <form:errors path="email" element="p"/>
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zmień</button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>
    <jsp:include page="/WEB-INF/views/elements/footer.jsp"/>
</body>
</html>
