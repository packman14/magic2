<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${sorciereCo.ingredients}" var="ingredient">
    <img id="${ingredient.id}" onclick="carteCliquee(${ingredient.id})" src="${ingredient.skin}" />
</c:forEach>