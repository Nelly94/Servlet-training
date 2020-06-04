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
        <li><a href="?action=detail&id=${user}">${user}</a></li>
    </c:forEach>
    </ul>
</body>
</html>
