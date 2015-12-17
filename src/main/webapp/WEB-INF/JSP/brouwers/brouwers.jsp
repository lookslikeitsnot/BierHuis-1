<%--
    Created by guillaume.vandecasteele on 17/12/2015 at 15:17.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <v:head title="allebrouwers"/>
    </head>
    <body>
        <v:menu/>
        <div class="contentWrapper">
            <h1><spring:message code="brouwers"/></h1>
            <table>
                <tbody>
                    <%--@elvariable id="brouwers" type="java.util.List"--%>
                    <c:forEach items="${brouwers}" var="brouwer">
                        <tr>
                            <spring:url var="brouwerURL" value="/brouwers/{id}">
                                <spring:param name="id" value="${brouwer.id}"/>
                            </spring:url>
                            <td><a href="${brouwerURL}">${brouwer.naam} (${brouwer.adres.gemeente})</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
