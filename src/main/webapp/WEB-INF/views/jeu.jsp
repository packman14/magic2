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
    <div>
        <div id="ingredients_dispo">
            <c:forEach items="${sorciereCo.ingredients}" var="ingredient">
                <img id="${ingredient.id}" onclick="carteCliquee(${ingredient.id})" src="${ingredient.skin}" />
            </c:forEach>
        </div>
        <div id="actionJoueur">
            <c:choose>
                <c:when test="${partieEnCours.numProchainJoueur == sorciereCo.numero}">
                    C'est à moi de jouer
                    <input type="button" id="bouton" value="Piocher une carte" onclick="piocher()"/>
                    <input type="button" id="bouton" value="Lancer Sort" onclick="sort()"/>
                </c:when>
                <c:otherwise>
                    c'est pas à moi de jouer
                </c:otherwise>
            </c:choose>
        </div>
        <c:forEach items="${partieEnCours.sorcieresEnJeu}" var="sorciere">
            <c:if test="${sorciere.id != sorciereCo.id}">
                <div id="visuAdv">
                    <img id="${sorciere.id}" onclick="carteCliquee(${sorciere.id})" src="${sorciere.skin}"/><br>
                    ${sorciere.pseudo}<br>
                    ${sorciere.dateCo}
                    <div id="nbCarte">
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<div class="pied">
    <c:import url="_PIED.jsp"/>
</div>
</body>
</html>