<%--
    Created by guillaume.vandecasteele on 17/12/2015 at 15:50.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <v:head title="bierenperbrouwer"/>
    </head>
    <body>
        <v:menu/>
        <h1>${brouwer.naam} (${brouwer.adres.gemeente})</h1>
        <table>
            <tbody>
                <c:forEach items="${brouwer.bieren}" var="bier">
                    <tr>
                        <spring:url value="/bieren/{id}" var="bierURL">
                            <spring:param name="id" value="${bier.id}"/>
                        </spring:url>
                        <td><a href="${bierURL}">${bier.naam}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
