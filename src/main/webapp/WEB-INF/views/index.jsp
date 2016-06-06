<%-- 
    Document   : index
    Created on : 3 juin 2016, 11:48:24
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<!--        <div id="ressource">coucou</div>
        <div id ="plateau">Plateau</div>-->
    </body>
</html>
