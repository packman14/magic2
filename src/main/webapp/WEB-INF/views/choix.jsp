<%-- 
    Document   : choix
    Created on : 6 juin 2016, 14:11:48
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--        indique le nom de la feuille de style css utilisée-->
<!DOCTYPE html>
<html>
    <head>
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
    <div class="contenu">
        <!--        affichage des skins avec bouton de sélection-->
        <c:forEach items="${mesSkins}" var="monSkin" varStatus="ntm">
            <div>
                <a  href="<c:url value="/choix/"/>${ntm.index}">
                    <input type="submit" value="Selectionner">
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>