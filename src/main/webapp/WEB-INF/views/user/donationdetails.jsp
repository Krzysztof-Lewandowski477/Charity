<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>" />
</head>
<body>
<jsp:include page="../elements/header.jsp"/>
<div class="container container--85" style="text-align: center;">
    <table style="text-align: center;">
        <h1>Szczegóły daru</h1>
        <h2>
            <tr>
                <td> <b>Organizacja odbierająca:  </b><br/>
                <td>${donation.institution.name}</td>
            </tr>
            <tr>
                <td> <b>Data przekazania: </b> <br/>
                <td>${donation.pickUpDate}, ${donation.pickUpTime}</td>
            </tr>
            <tr>
                <td> <b>Status: </b> <br/>
                <td>${donation.status}</td>
            </tr>
            <tr>
                <td><b>Data i czas odebrania:</b></td>
                <td>${donation.deliverTime}</td>
                <c:url value="/changestatus" var="detailsURL">
                    <c:param name="id" value="${donation.id}"/>
                </c:url>
                <td><b> <a href="${detailsURL}">Zmiana statusu</a></b></td>
            </tr>

        </h2>
    </table>
    <a href="/user/donations" class="btn btn--large" style="text-align: center;">Powrót</a>
</div>
</body>
</html>
