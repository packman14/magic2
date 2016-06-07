<%-- 
    Document   : _HEAD
    Created on : 25 mai 2016, 15:46:44
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="CSS/style.css" rel="stylesheet" type="text/css"/>
<c:choose>
    <c:when test="${sorciereCo.pseudo==null}">
        <c:set var="maRoute"><c:url value="/connex"/></c:set>
        <form:form modelAttribute="sorciereCo" method="post" action="${maRoute}">
            <label>Pseudo</label>
            <input type="text" name="pseudo"/>
            <input type="submit" value="Connexion"/>
        </form:form>
    </c:when>
    <c:otherwise>
        <a  href="<c:url value="/deconnex"/>">
            <input type="button" value="Déconnexion"/>
        </a>

    </c:otherwise>
</c:choose>