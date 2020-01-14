<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">
<head>
    <jsp:include page="/WEB-INF/views/elements/head.jsp"/>
</head>
<body>
    <jsp:include page="/WEB-INF/views/elements/header.jsp"/>
<div class="slogan container container--90">
    <h2>Sprawdź skrzynkę email ,wysyłanie powiodło się</h2>
</div>
    <jsp:include page="/WEB-INF/views/elements/footer.jsp"/>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
