<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/views/elements/head.jsp"/>
    <title>Form</title>
</head>
<body>
<header class="header--form-page">
<jsp:include page="/WEB-INF/views/elements/headerUser.jsp"/>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title"><spring:message code="pages.index.body.4steps"/></div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span><spring:message code="pages.index.body.4steps2"/></span></div>
                    </li>
                    <li>
                        <div><em>2</em><span><spring:message code="pages.form.bags"/></span></div>
                    </li>
                    <li>
                        <div><em>3</em><span><spring:message code="pages.form.organization"/></span></div>
                    </li>
                    <li>
                        <div><em>4</em><span><spring:message code="pages.index.body.4steps27"/></span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <form:form modelAttribute="donations" method="post" >
<%--        <form action="form-confirmation.html" method="post">--%>
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
               <c:forEach items="${categories}" var="category">

                <div class="form-group form-group--checkbox">
                    <label>
                        <input
                                type="checkbox"
                                name="categories"
                                value="${category.id}"
                        />
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
               </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input path="quantity" type="number" step="1" min="1" requaired="true"/>
                        <form:errors path="quantity"/>
<%--                        <input type="number" name="bags" step="1" min="1" />--%>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>



            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="radio" name="institution" value="${institution.id}" requaired="true" />
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">
                    ${institution.description}
                  </div>
                </span>
                    </label>

                </div>
            </c:forEach>

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="radio" name="organization" value="old" />--%>
<%--                        <span class="checkbox radio"></span>--%>
<%--                        <span class="description">--%>
<%--                  <div class="title">Fundacja “Dla dzieci"</div>--%>
<%--                  <div class="subtitle">--%>
<%--                    Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji--%>
<%--                    życiowej.--%>
<%--                  </div>--%>
<%--                </span>--%>
<%--                    </label>--%>
<%--                </div>--%>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>Ulica<form:input path="street" cssClass="text" requaired="true"/><form:errors path="street"/> </label>
<%--                            <label> Ulica <input type="text" name="address" /> </label>--%>
                        </div>

                        <div class="form-group form-group--inline">
                           <label> Miasto <form:input path="city" cssClass="text" /><form:errors path="city" requaired="true"/></label>
<%--                            <label> Miasto <input type="text" name="city" /> </label>--%>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                               Kod pocztowy <form:input path="zipCode" cssClass="text" name="postcode" requaired="true"/>
                                <form:errors path="zipCode"/>
<%--                                Kod pocztowy <input type="text" name="postcode" />--%>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input path="telephoneNumber"  type="phone" />
                                <form:errors path="telephoneNumber" cssClass="help is-danger"/>
<%--                                Numer telefonu <input type="phone" name="phone" />--%>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                           <label> Data <from:input path="pickUpDate" cssClass="date" type="date" requaired="true"/><form:errors path="pickUpDate"/></label>
<%--                            <label> Data <input type="date" name="data" /> </label>--%>
                        </div>

                        <div class="form-group form-group--inline">
                           <label> Godzina <form:input path="pickUpTime" type="time" />
                               <form:errors path="pickUpTime"/>
                           </label>
<%--                            <label> Godzina <input type="time" name="time" /> </label>--%>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="pickUpComment" rows="5" /> <form:errors path="pickUpComment"/>
<%--                                <textarea name="more_info" rows="5"></textarea>--%>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text"
                                >4 worki ubrań w dobrym stanie dla dzieci</span
                                >
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla fundacji "Mam marzenie" w Warszawie</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>Prosta 51</li>
                                <li>Warszawa</li>
                                <li>99-098</li>
                                <li>123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>13/12/2018</li>
                                <li>15:40</li>
                                <li>Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
<%--        </form>--%>
        </form:form>
    </div>
</section>
<%--footer--%>
<jsp:include page="/WEB-INF/views/elements/footer.jsp"/>
<%--footer--%>
</body>
</html>
