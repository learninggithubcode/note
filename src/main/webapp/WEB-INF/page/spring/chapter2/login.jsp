<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"></c:out> </font>
</c:if>
<form action="<c:url value="/loginCheck.html"/>" method="post">
    用户名：
    <input name="userName" />
    <br />
    密码：
    <input name="password" />
    <br />
    <input type="submit" value="登录" />
</form>
</body>
</html>