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

        <div id="actionJoueur">
            <c:choose>
                <c:when test="${partieEnCours.numProchainJoueur == sorciereCo.numero}">
                    C'est a moi de jouer
                    <c:set var="maRoute"><c:url value="/jeu"/></c:set>
                    <form:form id="lancerSort" modelAttribute="formActionDTO" method="post" action="${maRoute}">

                        
                        
                        <div id="ingredientsDispo">
                            <c:forEach items="${sorciereCo.ingredients}" var="ingredient">
                                <img src="${ingredient.skin}"/>
                                <form:checkbox path="ingredients" value="ingredient" />
                            </c:forEach>
                        </div>

                        


                        <label>Piocher une carte</label>
                        <form:radiobutton path="action" value="piocher"/><br>

                        <label>Lancer un sort</label>
                        <form:radiobutton path="action" value="lancerSort"/><br>
                        
                        <input type="button" id="bouton" value="Lancer le sort" onclick="lancerSort()"/>
                        
                    </form:form>
                </c:when>
                <c:otherwise>
                    c'est pas à moi de jouer
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>