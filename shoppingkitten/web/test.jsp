<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/easyui.css">
    <link rel="stylesheet" href="css/icon.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript">
        function code() {
            alert("aa");
            $.get("createCheckCode.do",function (date) {
                alert(date);
               if (date){
                 var a=JSON.parse(date);
                 $("#code").html(a);

               }
            });
        }
    </script>
</head>
<body>
    <div>
        <form action="createUser.do" method="post">
            账号：<input type="text" name="account"><br>
            密码：<input type="password" name="pwd"><br>
            电话：<input type="text" name="phone"><br>
            验证码：<input type="number" name="checkCode">
            <div id="code"></div>
            <input type="submit" value="注册">
        </form>
            <button onclick="code()">产生验证码</button>

    </div>
</body>
</html>
