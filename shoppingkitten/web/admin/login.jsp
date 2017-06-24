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
            border: 1px solid #bce8f1;
            background-color: #bce8f1;
            padding-left: 50px;
            width: 350px;
            margin:190px auto;
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
            position: relative;
            bottom: 40px;
            width:240px;
            background-color:orange ;
            border: 0px;
            height: 40px;
            font-size: 25px;
        }
        #code_input2{
            padding-top: 15px;
            position: relative;
            left: 140px;
            bottom: 56px;
            width: 100px;
            height: 40px;
        }
        #msg{
            color: red;
        }
    </style>
    <script type="text/javascript">
        //初始化
        function  init() {
            //产生验证码
            var verifyCode=new GVerify("code_input2");
            $("#code_input2").val(verifyCode);
            //验证码输入框失去焦点开始验证
            $("#code").blur(function () {
                checkCode();
            });
        }
        //检查验证码
        function checkCode(){
            //获取验证码
            verifyCode=$("#code_input2").val();
            //验证验证码
            var res=verifyCode.validate(document.getElementById("code").value);
            if (res) {
                check2=true;
            } else {
                check2=false;
            }
            checkAll();
        }
        //循环检查输入框是否为空
        function check() {
            //循环检查输入框
            var es = $("input[type='text'],input[type='password']");
            es.blur(function() {
                $.each(es, function(i, e) {
                    //检查输入框是否为空
                    if ($(e).val()) {
                        check1=true;
                    } else {
                        check1=false;
                        return false;
                    }
                });
                    checkAll();
            });
        }
        //检查所有
        function checkAll() {
            if(check1&&check2){
                $("#but1").removeClass("disabled");
            }else {
                $("#but1").addClass("disabled");
            }
        }
        function login() {
            var data=$("#f1").serialize();
            $.post("/mangerlogin.do",data,function (data) {
                var x=JSON.parse(data);
                if(x=="success"){
                    location.href="/admin/main.jsp";
                }else {
                    $("#msg").html("登录失败，请检查账号和密码");
                }
            });
        }
        $(init);
        $(check);
    </script>
</head>
<body>
    <div id="div1" >
    <h2>管理员登录系统</h2>
        <div id="msg"></div>
    <form action="#" method="post" id="f1">
        <input id="acc" type="text" name="account" placeholder="用户名"/><br>
        <input id="pas" type="password" name="pwd" placeholder="密码"><br>
        <input  id="code"  type="text"  placeholder="验证码">
        <div id="code_input2"></div>
        <br>
    </form>
        <a id="but1" class="btn btn-success btn-block disabled" href="javascript:login()">登录</a><br>
    </div>
</body>
</html>
