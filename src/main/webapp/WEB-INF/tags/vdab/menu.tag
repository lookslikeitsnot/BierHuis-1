<%--suppress XmlPathReference --%>
<%--
    Created by Guillaume on 17/12/2015 at 14:16.
 --%>
<%@ tag description='Menu at top of page' pageEncoding='UTF-8' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <li><a href="<c:url value="/"/>"><spring:message code="welkom"/></a></li>
        <li><a href="<c:url value="/brouwers"/>"><spring:message code="brouwers"/></a></li>
        <li><a href="<c:url value="/basket"/>"><spring:message code="basket"/></a></li>
    </ul>
</nav>