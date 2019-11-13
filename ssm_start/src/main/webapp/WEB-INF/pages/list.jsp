<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有的帐户</h3>

    <c:forEach items="${list}" var="msg">
        <h5>${msg.username}</h5>
    </c:forEach>
    <hr/>
    <h3>t_msg=${t_msg}</h3>
    <hr/>
<%--    <h3>req_msg=${req_msg}</h3>--%>
    <hr/>
    <h3>sess_msg=${sess_msg}</h3>

</body>
</html>
