<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h2>Reset hasla</h2>
    <form:form method="post" modelAttribute="changePassword">
        <div class="form-group">
            <div class="control has-icons-left">
              Podaj Hasło
                <form:password path="password" required="true" placeholder="${newPasswordPlaceholder}"/>
                <form:errors path="password" element="p"/>
            </div>
            <div class="control has-icons-left">
               Powtórz hasło
                <form:password path="rePassword" required="true" placeholder="${rePasswordPlaceholder}"/>
                <form:errors path="rePassword" element="p"/>
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zatwierdź</button>
        </div>
        <sec:csrfInput/>
    </form:form>
</section>

    <jsp:include page="/WEB-INF/views/elements/footer.jsp"/>
</body>
</html>
