<%--
    Created by guillaume.vandecasteele on 17/12/2015 at 14:28.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <v:head title="welkom"/>
    </head>
    <body>
        <v:menu/>
        <div class="contentWrapper">
            <h1><spring:message code="welcomemessage"/></h1>
            <div class="indexlogo"></div>
            <%--@elvariable id="count" type="java.lang.Long"--%>
            <fmt:formatNumber value="${count}" var="amount" groupingUsed="false"/>
            <p><spring:message code="amountofbeers" arguments="${amount}"/></p>
        </div>
    </body>
</html>
