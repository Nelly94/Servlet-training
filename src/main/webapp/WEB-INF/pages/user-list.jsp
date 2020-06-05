<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>Hello, I will be a list</h1>
    <ul>
    <c:forEach items="${usersList}" var="user">
        <li><a href="?action=detail&id=${user.firstname}">${user.firstname}</a></li>
        <c:choose>
            <c:when test="${user.salary > 2000}">Above 2000</c:when>
            <c:when test="${user.salary < 2000}">Under 2000</c:when>
            <c:otherwise>Equal 2000</c:otherwise>
        </c:choose>
    </c:forEach>
    </ul>
</body>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</html>

