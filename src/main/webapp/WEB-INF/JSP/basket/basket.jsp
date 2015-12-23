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
            <form:form commandName="bestelbon" method="post" id="addForm">
                <form:label path="naam"><spring:message code="name"/></form:label>
                <form:input path="naam" autofocus="autofocus" required="required" maxlength="50"/><form:errors
                    path="naam" cssClass="error"/>
                <form:label path="adres.straat"><spring:message code="straat"/></form:label>
                <form:input path="adres.straat" required="required" maxlength="50"/><form:errors
                    path="adres.straat" cssClass="error"/>
                <form:label path="adres.huisNr"><spring:message code="huisnr"/></form:label>
                <form:input path="adres.huisNr" required="required" maxlength="50"/><form:errors
                    path="adres.huisNr" cssClass="error"/>
                <form:label path="adres.postcode"><spring:message code="pcode"/></form:label>
                <form:input path="adres.postcode" required="required" type="number" min="1000" max="9999"
                            placeholder="1000"/><form:errors path="adres.postcode" cssClass="error"/>
                <form:label path="adres.gemeente"><spring:message code="gemeente"/></form:label>
                <form:input path="adres.gemeente" required="required"/><form:errors path="adres.gemeente"
                                                                                    cssClass="error"/>
                <input type="submit" value="<spring:message code="bevestigen"/>" id="addButton">
            </form:form>
            <script>
                document.getElementById("addForm").onsubmit = function () {
                    document.getElementById("addButton").disabled = true;
                };
            </script>
        </c:when>
        <c:otherwise>
            <h2><spring:message code="empty"/></h2>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
