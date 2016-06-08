<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${partieEnCours.sorcieresEnJeu}" var="sorciere">
    <c:if test="${sorciere.id != sorciereCo.id}">
            <b>Nb cartes: ${sorciere.ingredients.size()}</b>
    </c:if>
</c:forEach>