
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
    <title>Moje konto</title>
    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>" />
</head>
<body>


<jsp:include page="../elements/header.jsp"/>
<a href="/user/changeEmail" class="btn btn--large" style="text-align: center;">Zmiana email</a>
<a href="/user/changePassword" class="btn btn--large" style="text-align: center;">Zmiana hasła</a>
<a href="/user/changedetalis" class="btn btn--large" style="text-align: center;">Zmiana szczegółów </a>

</body>
</html>
