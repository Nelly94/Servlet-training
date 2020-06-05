<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Detail</title>
</head>
<body>
    <h1>Hello, ${user.fullName}! Your current salary is ${user.salary}</h1>
</body>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</html>
