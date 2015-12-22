<%--suppress XmlDuplicatedId --%>
<%--suppress XmlPathReference --%>
<%--
    Created by guillaume.vandecasteele on 21/12/2015 at 22:22.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <v:head title="basket"/>
    </head>
    <body>
        <v:menu/>
        <div class="contentWrapper">
            <h1><spring:message code="basket"/></h1>
            <c:choose>
                <%--@elvariable id="bestelbon" type="be.vdab.entities.Bestelbon"--%>
                <c:when test="${bestelbon.lijnen ne null}">
                    <table>
                        <thead>
                            <tr>
                                <th><spring:message code="bier"/></th>
                                <th><spring:message code="prijs"/></th>
                                <th><spring:message code="aantal"/></th>
                                <th><spring:message code="amountDue"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${bestelbon.lijnen}" var="lijn">
                                <tr>
                                    <td>${lijn.bier.naam}</td>
                                    <td>${lijn.bier.prijs}</td>
                                    <td>${lijn.aantal}</td>
                                    <td>${lijn.total}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="3"></td>
                                <td><spring:message code="total"/>: ${bestelbon.total}</td>
                            </tr>
                        </tfoot>
                    </table>
                    <form:form commandName="bestelbon" method="post">
                        <form:label path="naam"><spring:message code="name"/><form:errors path="naam"/></form:label>
                        <form:input path="naam" autofocus="autofocus" required="required" maxlength="50"/>
                        <form:label path="adres.straat"><spring:message code="straat"/><form:errors path="adres.straat"/></form:label>
                        <form:input path="adres.straat" required="required" maxlength="50"/>
                        <form:label path="adres.huisNr"><spring:message code="huisnr"/><form:errors path="adres.huisNr"/></form:label>
                        <form:input path="adres.huisNr" required="required" maxlength="50"/>
                        <form:label path="adres.postcode"><spring:message code="pcode"/><form:errors path="adres.postcode"/></form:label>
                        <form:input path="adres.postcode" required="required" type="number" min="1000" max="9999"/>
                        <form:label path="adres.gemeente"><spring:message code="gemeente"/><form:errors path="adres.gemeente"/></form:label>
                        <form:input path="adres.gemeente" required="required"/>
                        <input type="submit" value="<spring:message code="bevestigen"/>">
                    </form:form>
                </c:when>
                <c:otherwise>
                    <h1><spring:message code="empty"/></h1>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
