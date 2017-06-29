<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/easyui.css">
    <link rel="stylesheet" href="css/icon.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        //初始化
        function init() {
            $("#main_product_type_alltypes").tree({
            });
            $("#main_product_type_any").treegrid({
                title:"商品分类管理",
                url:"findTypes.do",
                idField:"id",
                treeField:"text",
                columns:
                    [[
                        {field:"id",title:"",width:100,checkbox:true},
                        {field:"text",title:"类别",width:100},
                        {field:"pid",title:"pid",width:100}
                    ]],
                toolbar:[
                    {text:"添加",iconCls:"icon-add",handler:function(){addType();}},
                    {text:"修改",iconCls:"icon-edit",handler:function(){editType();}},
                    {text:"删除",iconCls:"icon-remove",handler:function(){deleteType();}}
                ]
            });
        }
        $(init);
        //删除商品分类
        function deleteType(){
            //获取选择的数据
            var x=  $("#main_product_type_any").treegrid("getSelected");
            //x非空,就是选择了要删除的数据
            if(x){
                $.get("deletePtype.do",{id:x.id},function(d){
                    location.reload(true);
                });
            }else{
                //提示框
                $.messager.alert("系统提示","请选择要删除的数据");
            }
        }
        //添加商品分类
        function addType() {
            //获取选择的数据
            var x=  $("#main_product_type_any").treegrid("getSelected");
            //x非空,就是选择了要添加分类
            if(x){
                var z=x.id;
                $("#main_product_type_id").val(z);
                //显示window
                $("#type_window").window("open");
            }else{
                //提示框
                $.messager.alert("系统提示","请选择要添加的分类");
            }
        }
        //添加保存商品分类
       function typeSave(){
           $("#type_window").window("close");
         var y= $("#ptbd").serialize();
           $.post("addType.do",y,function(d){
               location.reload(true);
           });
       }
       //修改商品分类
        function editType() {
            //获取选择的数据
            var x=  $("#main_product_type_any").treegrid("getSelected");
            //x非空,选择修改
            if(x){
                var z=x.id;
                //给id赋值给隐藏的输入框的id
                $("#main_product_type_edid").val(z);
                //显示window
                $("#edittype_window").window("open");
            }else{
                //提示框
                $.messager.alert("系统提示","请选择要修改的分类");
            }
        }
        //修改保存商品分类
      function typeEdit() {
          $("#edittype_window").window("close");
          var y= $("#edptbd").serialize();
          $.post("editType.do",y,function (d) {
              location.reload(true);
          });
      }
      //加载商品信息
        function init2(){
            $("#product_detaillist").datagrid({
                title:"商品信息",
                columns:[[
                    {field:"id",title:"",width:100,checkbox:true},
                    {field:"name",title:"商品名称",width:100},
                    {field:"sale_price",title:"售价",width:100},
                    {field:"price",title:"进价",width:100},
                    {field:"stock",title:"库存",width:100},
                    {field:"sale_total",title:"已售",width:100},
                    {field:"create_time",title:"上架时间",width:100}
                ]],
                toolbar:[
                    {text:"添加",iconCls:"icon-add",handler:function(){addProduct();}},
                    {text:"修改",iconCls:"icon-edit",handler:function(){editProduct();}},
                    {text:"删除",iconCls:"icon-remove",handler:function(){deleteProduct();}}
                ]
            });
        }
        //添加商品
        function addProduct(){
            $.getJSON("findTypes2.do"),function(d){
                alert(d);
            };
        $("#product_alert").modal("show");
        }
    </script>
</head>
<body>
<%--显示商品全部分类的tree--%>
<div>
    <ul id="main_product_type_alltypes" class="easyui-tree" data-options="url:'findTypes.do'">
    </ul>
</div>
<%--treegrid形式的商品分类可以进行增删改查--%>
<div id="main_product_type_any">
</div>
<%--添加商品分类弹窗--%>
<div id="type_window" class="easyui-window" data-options="closed:true,modal:true" style="width:300px;height:400px" title="添加分类">
    <div style="width:100%;height:90%;padding:30px 30px">
        <form id="ptbd">
            <input id="main_product_type_id" type="hidden" name="id">
       <input id="atype" type="text" name="text">
        </form>
    </div>
    <div style="display:flex;justify-content:center">
        <a class="easyui-linkbutton" onclick="typeSave()">保 &nbsp;&nbsp;&nbsp;存</a>
    </div>
</div>
<%--修改商品分类的弹窗--%>
<div id="edittype_window" class="easyui-window" data-options="closed:true,modal:true" style="width:300px;height:400px" title="修改分类">
    <div style="width:100%;height:90%;padding:30px 30px">
        <form id="edptbd">
            <input id="main_product_type_edid" type="hidden" name="id">
           请输入要修改成的分类 <input id="etype" type="text" name="text">
        </form>
    </div>
    <div style="display:flex;justify-content:center">
        <a class="easyui-linkbutton" onclick="typeEdit()">保 &nbsp;&nbsp;&nbsp;存</a>
    </div>
</div>
</body>
</html>
