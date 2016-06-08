<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${partieEnCours.numProchainJoueur == sorciereCo.numero}">
        C'est a moi de jouer
        <input type="button" id="bouton" value="Piocher une carte" onclick="piocher()"/>
        <input type="button" id="bouton" value="Lancer Sort" onclick="sort()"/>
    </c:when>
    <c:otherwise>
        c'est au joueur ${partieEnCours.numProchainJoueur} de jouer. toi t'es le joueur ${sorciereCo.numero} connard
    </c:otherwise>
</c:choose>