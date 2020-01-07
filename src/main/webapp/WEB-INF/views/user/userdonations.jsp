<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container container--85">
    <table id="tabAdmins">
        <h1>Moje dary</h1>
        <h2>
            <tr>
                <td> Id:  <br/>
                <td> Ilośc worków:  <br/>
                <td> Miasto: </td>
                <td> Komentarz:</td>
                <td> Data odbioru:</td>
            </tr>
            <for:forEach items="${donations}" var="donation" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${donation.quantity}</td>
                    <td>${donation.city}</td>
                    <td>${donation.pickUpComment}</td>
                    <td>${donation.pickUpDate}, ${donation.pickUpTime}</td>


        <sec:csrfInput/>
                </tr>
            </for:forEach>
        </h2>
    </table>
</div>
</body>
</html>
