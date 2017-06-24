<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/easyui.css">
    <link rel="stylesheet" href="css/icon.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <div>
        <div id="msg"></div>
        <form action="login.do" method="post">
            账号：<input type="text" name="account"><br>
            密码：<input type="password" name="pwd"><br>
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
