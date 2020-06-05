<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<c:if test = "${sessionScope.login == null}">
    <form method="post">
        <label>Email:</label>
        <input type="email" name="email">
        <br>

        <label>Password:</label>
        <input type="password" name="password">
        <br>

        <button type="submit">OK</button>
    </form>
</c:if>

<c:if test = "${sessionScope.login != null}">
    <p>You are logged as: ${sessionScope.login.email}</p>
    <a href="?action=logout">Logout</a>
</c:if>

</body>
</html>
