<%-- 
    Document   : attente
    Created on : 6 juin 2016, 16:06:38
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
Joueurs connectés: 
<c:forEach items="${partieEnCours.sorciereEnJeu}" var="sorciere">
    <c:if test="${sorciere.id != sorciereCo.id}">
        ${sorciere.pseudo}
        <img src="${sorciere.skin}"/>
        ${sorciere.dateCo}
    </c:if>
    <img src="${sorciereCo.skin}"/>
</c:forEach>