<%-- 
    Document   : plateau
    Created on : 3 juin 2016, 12:10:59
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--        indique le nom de la feuille de style css utilisée-->
<!DOCTYPE html>
<html>
    <head>
        <script src="JS/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="JS/mesScripts.js" type="text/javascript"></script>
    <div class="head">
        <c:import url="_HEAD.jsp"/>
    </div>
</head>
<body>
    <div class="title">
        <c:import url="_TITLE.jsp"/>
    </div>
    <div class="menu">
        <c:import url="_MENU.jsp"/>
    </div>
    <div class="contenu" id="contenu">
        <c:choose>
            <c:when test="${partieEnCours.partieEnCours==false}">
                Joueurs connectés: 
                <c:forEach items="${partieEnCours.sorcieresEnJeu}" var="sorciere">
                    <c:if test="${sorciere.id != sorciereCo.id}">
                        ${sorciere.pseudo}
                        <img src="${sorciere.skin}"/>
                        ${sorciere.dateCo}
                    </c:if>
                </c:forEach>
                <br>
                <a  href="<c:url value="/debut"/>">
                    <input type="button" value="Commencer la partie"/>
                </a>
                <br>
                <img src="${sorciereCo.skin}"/>
            </c:when>
            <c:otherwise>
                
            </c:otherwise>
        </c:choose>

    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>