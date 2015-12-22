<%--
    Created by guillaume.vandecasteele on 22/12/2015 at 02:30.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <v:head title="confirm"/>
</head>
<body>
<v:menu/>
<div class="contentWrapper">
    <h1><%--@elvariable id="id" type="java.lang.Long"--%>
    <spring:message code="confirmation" arguments="${id}"/></h1>
</div>
</body>
</html>