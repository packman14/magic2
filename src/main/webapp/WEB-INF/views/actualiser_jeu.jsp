<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <br>
        <img src="${sorciereCo.skin}"/>
        <a  href="<c:url value="/debut"/>">
            <input type="button" value="Commencer la partie"/>
        </a>
    </c:when>
    <c:otherwise>
        <a  href="<c:url value="/jeu"/>">
            <input type="button" value="Rejoindre la partie"/>
        </a>
        <c:choose>
            <c:when test="${partieEnCours.numProchainJoueur == sorciereCo.numero}">
                C'est a moi de jouer
            </c:when>
            <c:otherwise>
                ${partieEnCours.numProchainJoueur}
                C'est pas à moi de jouer
            </c:otherwise>
        </c:choose>

    </c:otherwise>
</c:choose>
