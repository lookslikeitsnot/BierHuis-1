<%--
    Created by guillaume.vandecasteele on 22/12/2015 at 02:30.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <v:head title="confirm"/>
</head>
<body>
<v:menu/>
<div class="contentWrapper">
    <h1>
        <%--@elvariable id="bestelbon" type="be.vdab.entities.Bestelbon"--%>
        <spring:message code="confirmation" arguments="${bestelbon.id}"/></h1>
    <c:if test="${bestelbon.lijnen ne null}">
        <table>
            <thead>
            <tr>
                <th><spring:message code="bier"/></th>
                <th><spring:message code="prijs"/></th>
                <th><spring:message code="aantal"/></th>
                <th><spring:message code="amountDue"/></th>
            </tr>
            </thead>
            <tbody class="basket">
            <c:forEach items="${bestelbon.lijnen}" var="lijn">
                <spring:url value="/bieren/{id}" var="bierURL">
                    <spring:param name="id" value="${lijn.bier.id}"/>
                </spring:url>
                <tr>
                    <td><a href="${bierURL}">${lijn.bier.naam}</a></td>
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
        <dl>
            <dt><spring:message code="name"/></dt>
            <dd>${bestelbon.naam}</dd>
            <dt><spring:message code="adres"/></dt>
            <dd>${bestelbon.adres.straat} ${bestelbon.adres.huisNr},
                    ${bestelbon.adres.postcode} ${bestelbon.adres.gemeente}</dd>
        </dl>
    </c:if>
</div>
</body>
</html>