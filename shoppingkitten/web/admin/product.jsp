<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<%--显示商品全部分类的tree--%>
<div>
    <ul id="main_product_type_alltypes" class="easyui-tree" data-options="url:'/findTypes.do'">
   </ul>
</div>
<%--点击商品分类显示该分类有哪些商品--%>
<div id="product_detaillist">

</div>
<%--添加商品的弹窗--%>
<div id="product_alert" class="easyui-window" data-options="closed:true,modal:true" style="width: 600px;height:800px;">

    <div >
        <h6>添加商品</h6>
    </div>
    <div >
        <form class="form-group" id="product_form">
            <div class="input-group">
                <span class="input-group-addon">名称</span> <input type="text" class="form-control" name="product_name">
            </div>
            <div class="input-group">
                <span class="input-group-addon">售价</span> <input type="number" class="form-control" name="productsale_price">
            </div>
            <div class="input-group">
                <span class="input-group-addon">进价</span> <input type="number" class="form-control" name="product_price">
            </div>

            <div class="input-group">
                <span class="input-group-addon">库存</span> <input type="number" class="form-control" name="product_stock">
            </div>

            <div class="input-group">
                <span class="input-group-addon">类别</span>
                <select id="abcd" class="form-control" name="producted_type">
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon">描述</span>
                <textarea rows="2" cols="2" name="product_descripe" id="product_descripe" class="ckeditor"></textarea>
            </div>
            <div class="input-group">
                <span class="input-group-addon">图片</span> <input type="file" name="product_face" onchange="face_pre(this)" />
            </div>
        </form>
        <span id="product_face_pre"></span>
    </div>
    <div >
        <button class="btn btn-success" onclick="productaddsave()">保存</button>
    </div>
</div>
<script type="text/javascript">
        //选择商品封面
        function face_pre(path){
            //获得文件对象:Object File
            var first = path.files[0];
            //为图片创建一个路径
            var x =URL.createObjectURL(first);
            alert(x);
            //写出图片标签
            var img = "<image src='" + x + "' style='width: 100px;height: 100px;' />"
            //将标签添加入<span>中
            $("#product_face_pre").html(img);
        }

        function init() {
            $("#main_product_type_alltypes").tree({
                onClick: function (node) {
                    var dd = node.id;
                    $.getJSON("/findProduct.do", {tid: dd}, function (d) {
                        init2();
                        $("#product_detaillist").datagrid("loadData", d);
                    });
                }
            });
        }
        $(init);
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
            $.getJSON("/findTypes2.do",function (d) {
                var option;
                for(var i in d){
                var a="<option  name='tid' value="+d[i].id+">"+d[i].text+"</option>"
                option=option+a;
                }
                    $("#abcd").html(option);
//                $("#product_alert").modal("show");
                $("#product_alert").window("open");
            });
        }
        //保存添加的商品
        function productaddsave(){
            //获取textarea内的值
            var x = CKEDITOR.instances.product_descripe.getData();
            //封装表单内所有<input>输入框的值
            var formdata = new FormData($("form")[0]);
            //textarea内的值追加进formdata
            formdata.append("product_descripe", x);
            alert(formdata);
            $.ajax({
                url:"/addProduct.do",
                method:"post",
                data:formdata,
                //contentType: "application/x-www-form-urlencoded; charset=utf-8",
                contentType:false,//不指定数据类型
                processData:false,//不进行格式化
                success:function(d){
                    location.reload(true);
                }
            });
        }
        //根据商品id删除商品信息
        function deleteProduct() {
            //获取选择的数据
            var x=  $("#product_detaillist").treegrid("getSelected");
            //x非空,就是选择了要删除的数据
            if(x){
                $.get("/deleteproduct.do",{id:x.id},function(d){
                    location.reload(true);
                });
            }else{
                $.messager.alert("系统提示","请选择要删除的商品");
            }
        }
        //修改商品信息
        function editProduct() {
            //获取选择的数据
            var x=  $("#product_detaillist").treegrid("getSelected");
            //x非空
            if(x){

                $("#product_alert").window("open");
            }else{
                $.messager.alert("系统提示","请选择要修改的商品");
            }
        }
    </script>



