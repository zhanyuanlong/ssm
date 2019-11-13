<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="message/findAll">测试查询</a>

    <h3>测试包</h3>

    <form action="message/save" method="post">
        用户名：<input type="text" name="username" /><br/>
        留言：<input type="text" name="msg" /><br/>
        时间：<input type="text" name="time" /><br/>
        <input type="submit" value="保存"/><br/>
    </form>

    <a href="message/testModel">测试model</a>

</body>
</html>
