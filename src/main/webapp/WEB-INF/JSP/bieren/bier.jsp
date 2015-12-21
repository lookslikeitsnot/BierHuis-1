<%--
    Created by guillaume.vandecasteele on 17/12/2015 at 17:28.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <v:head title="bier"/>
    </head>
    <body>
        <v:menu/>
        <div class="contentWrapper">
            <h1>${bier.naam}</h1>
            <dl>
                <dt><spring:message code="alcohol"/></dt>
                <dd>${bier.alcohol}</dd>
                <dt><spring:message code="prijs"/></dt>
                <dd>${bier.prijs}</dd>
                <dt><spring:message code="soort"/></dt>
                <dd>${bier.soort.naam}</dd>
                <dt><spring:message code="brouwer"/></dt>
            </dl>
        </div>
    </body>
</html>
