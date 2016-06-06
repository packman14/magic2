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
        <div id="joueursCo"></div>
        <c:when test="${sorciereCo==null}">
            <input type="sumbit" value="Commencer la partie"/>
        </c:when>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>