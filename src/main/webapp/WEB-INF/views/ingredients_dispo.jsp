<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${ingredientsDispo}" var="ingredient">
    <img src="${ingredient.skin}" />
</c:forEach>
