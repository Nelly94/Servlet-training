<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <c:url var="postUserUrl" value="/user"/>
    <ul>
        <li>PageScope: ${pageScope.postUserUrl}</li>
        <li>PageScope: ${pageScope.postUserUrl}</li>
        <li>PageScope: ${pageScope.postUserUrl}</li>
        <li>PageScope: ${pageScope.postUserUrl}</li>
    </ul>

    <form action="${postUserUrl}" method="post">
        <label>First name:</label>
        <input type="text" name="firstname">
        <br>

        <label>Last name:</label>
        <input type="text" name="lastname">
        <br>

        <label>Salary:</label>
        <input type="text" name="salary">
        <br>

        <button type="submit">OK</button>
    </form>
</body>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</html>
