<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%--footer--%>
<footer>
<div class="contact" id="contact">
    <h2><spring:message code="pages.contact.whith.us"/> </h2>
    <h3><spring:message code="pages.contact.form"/> </h3>
    <form class="form--contact">
        <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię"/></div>
        <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko"/></div>

        <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

        <button class="btn" type="submit">Wyślij</button>
    </form>
</div>
<div class="bottom-line">
    <span class="bottom-line--copy">Copyright &copy; 2020</span>
    <div class="bottom-line--icons">
        <a href="#" class="btn btn--small"><img src="/./resources/images/icon-facebook.svg"/></a>
        <a href="#" class="btn btn--small"><img src="/./resources/images/icon-instagram.svg"/></a>
    </div>
</div>
    <script src="<c:url value="./resources/js/app.js"/>"></script>
</footer>
<script src="<c:url value="./resources/js/app.js"/>"></script>

<%--footer--%>
