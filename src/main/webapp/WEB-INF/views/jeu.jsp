<%-- 
    Document   : _TEMPLATE
    Created on : 25 mai 2016, 15:51:42
    Author     : ajc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div class="contenu">
        <div id="ingredientsDispo">
            <c:forEach items="${sorciereCo.ingredients}" var="ingredient">
                <img src="${ingredient.skin}"/>
                <form:checkbox path="ingredients" value="ingredient" />
            </c:forEach>
        </div>
        <div id="actionJoueur">
            <c:choose>
                <c:when test="${partieEnCours.numProchainJoueur == sorciereCo.numero}">
                    C'est a moi de jouer
                    <input type="button" id="bouton" value="Piocher une carte" onclick="piocher()"/>
                </c:when>
                <c:otherwise>
                    c'est pas � moi de jouer
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>