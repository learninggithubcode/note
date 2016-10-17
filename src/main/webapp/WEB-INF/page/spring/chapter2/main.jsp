<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    ${user.userName}，欢迎您进入首页，您当前积分为${user.credits}。
</body>
</html>