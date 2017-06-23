<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商城后台登录</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/icon.css" />
    <link rel="stylesheet" href="/css/easyui.css" />
    <script src="/js/gVerify.js"></script>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/easyui.js"></script>
    <style>
        #f1 input{
            margin-top: 8px;
            border-radius: 5px;

        }
        body{ 
          background-image: url("/images/login.jpg");
            background-size:1370px 660px ;
          background-repeat: no-repeat;
        }
        #div1{
            border: 1px solid black;
            background-color: #000079;
            padding-left: 50px;
        }
        #acc,#pas{
            margin-top: 15px;
            border-radius: 5px;
            width: 240px;
            height: 40px;
            padding-left: 10px;
        }
        #code{
            margin-top: 15px;
            border-radius: 5px;
            width: 130px;
            height: 40px;
            padding-left: 10px;
        }
        h2{
            font-family: "微软雅黑";
            color: white;
        }
        #but1{
            margin-top: 15px;
            position: relative;
            bottom: 50px;
        }
        #code_input2{
            padding-top: 15px;
            position: relative;
            left: 140px;
            bottom: 56px;
        }
    </style>
    <script>
        function  init() {
            var verifyCode=new GVerify("code_input2");
            $("#code_input2").val(verifyCode);
        }
        $(init);
    </script>
</head>
<body>
    <div id="div1" style="width: 350px;margin:190px auto;" >
    <h2>管理员登录系统</h2>
    <form action="login.do" method="post" id="f1">
        <input id="acc" type="text" name="account" placeholder="用户名"/><br>
        <input id="pas" type="password" name="pwd" placeholder="密码"><br>
        <input  id="code"  type="text"  placeholder="验证码">
        <div id="code_input2" style="width: 100px;height: 40px;"></div>
        <br>
    </form>
        <button id="but1" style="width:240px;background-color:goldenrod ;" class="btn btn-success " onclick="login()">登录</button><br>
    </div>
</body>
</html>
