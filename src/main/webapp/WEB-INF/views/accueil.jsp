<%-- 
    Document   : accueil
    Created on : 6 juin 2016, 11:09:40
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--        indique le nom de la feuille de style css utilisée-->
<link href="CSS/style.css" rel="stylesheet" type="text/css"/>

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
        <c:set var="maRoute"><c:url value="/accueil"/></c:set>
                <form:form modelAttribute="util" method="post" action="${maRoute}">
                    <label>Pseudo</label>
                    <input type="text" name="pseudo"/>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>
