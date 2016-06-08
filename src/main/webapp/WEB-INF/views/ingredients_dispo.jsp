<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:forEach items="${ingredientsDispo}" var="ingredient">
        <img  id="dropper" draggable="true" src="${ingredient.skin}"/>
    </c:forEach>