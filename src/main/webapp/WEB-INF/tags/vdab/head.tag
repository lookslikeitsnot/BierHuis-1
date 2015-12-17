<%--
    Created by guillaume.vandecasteele on 17/12/2015 at 14:14.
 --%>
<%@ tag description='contents of head tag' pageEncoding='UTF-8' %>
<%@ attribute name="title" required="true" description="title for use in head tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<title><spring:message code="${title}"/></title>
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="<c:url value="/css/default.css"/>"/>
