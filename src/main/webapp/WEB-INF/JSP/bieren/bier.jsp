<%--suppress XmlDuplicatedId --%>
<%--@elvariable id="bestelbonLijn" type="be.vdab.valueobjects.BestelbonLijn"--%>
<%--
    Created by guillaume.vandecasteele on 17/12/2015 at 17:28.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <v:head title="bier"/>
    </head>
    <body>
        <v:menu/>
        <div class="contentWrapper">
            <h1>${bestelbonLijn.bier.naam}</h1>
            <dl>
                <dt><spring:message code="alcohol"/></dt>
                <dd>${bestelbonLijn.bier.alcohol}</dd>
                <dt><spring:message code="prijs"/></dt>
                <dd>${bestelbonLijn.bier.prijs}</dd>
                <dt><spring:message code="soort"/></dt>
                <dd>${bestelbonLijn.bier.soort.naam}</dd>
                <dt><spring:message code="brouwer"/></dt>
                <dd>${bestelbonLijn.bier.brouwer.naam}</dd>
            </dl>
            <c:url value="/basket" var="basketURL"/>
            <form:form action="${basketURL}" commandName="bestelbonLijn" method="post">
                <form:hidden path="bier"/><form:errors path="bier" cssClass="error"/>
                <form:label path="aantal"><spring:message code="aantal"/></form:label>
                <form:input path="aantal" required="required" autofocus="autofocus" placeholder="2" maxlength="4" min="2" type="number"/>
                <form:errors path="aantal" cssClass="error"/>
                <input type="submit" value="<spring:message code="add"/>">
            </form:form>
        </div>
    </body>
</html>
