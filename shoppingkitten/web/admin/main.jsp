<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理页面</title>
    <link rel="stylesheet" href="/css/bootstrap.css" />
    <link rel="stylesheet" href="/css/icon.css" />
    <link rel="stylesheet" href="/css/easyui.css" />
    <%--自己写的CSS样式--%>
    <link rel="stylesheet" href="/css/main.css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/easyui.js"></script>
    <script type="text/javascript">
        function init() {
            //根据权限查找拥有的资源
            $.getJSON("/findResourceByPrivilege.do",{pid:${privileges.get(0).pid}},function (data) {
                for(var i in data){
                   $("#main_left").accordion("add",{
                        //添加
                       title:data[i].text,
                       content:"<ul class='easyui-tree' data-options=\"url:'/findResourceByPid.do?parent_id="+data[i].resource_id+"'\"></ul>"
                   });
                };
                //给所有的树添加点击检测事件
                $(".easyui-tree").tree({
                    onClick:function(node){
                        //判断是工作区是否存在该节点
                        var isExists=$("#main_work").tabs("exists",node.text);
                        if(isExists){
                            //如果存在，就选择该节点
                            $("#main_work").tabs("select",node.text);
                        }else{
                            //如果不存在，就添加该节点
                            $("#main_work").tabs("add",{
                                title:node.text,
                                closable:true,
                                href:node.url
                            });
                        }
                    }
                });
            });

        }
        function test() {

            alert(a);
        }
        $(init);
        
    </script>
</head>
<body>
<!-- 布局:把页面分为上下左右中 -->
<div id="main" class="easyui-layout">
    <div id="main_header" data-options="region:'north'">
        欢迎使用商城后台管理系统
    </div>
    <div id="main_left" class="easyui-accordion" data-options="region:'west'">

    </div>
    <div id="main_work" class="easyui-tabs" data-options="region:'center'">

    </div>
</div>
</body>
</html>
