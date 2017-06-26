<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="manager_grid"></div>

<%--分配角色弹窗--%>
<div id="main_manger_role_alert" class="easyui-window" data-options="closed:true,modal:true">
    <h3 id="main_manger_role_msg">请选择要分配的角色</h3>
    <div id="main_manager_role_grid"></div>
    <button class="btn btn-success btn-block" onclick="rolesave()">提交</button>
</div>
<!-- 添加账号弹窗 -->
<div id="main_manger_alert" class="easyui-window" data-options="closed:true,modal:true">
    <form id="main_manger_form" class="form-group" style="margin: 10px;">
        <input id="main_manger_mid" type="hidden" name="mid" class="form-control">
        <div class="input-group">
            <span class="input-group-addon">昵称：</span>
            <input id="main_manger_nick_name" type="text" name="nick_name" class="form-control">
        </div>
        <div class="input-group">
            <span class="input-group-addon">账号：</span>
            <input id="main_manger_account" type="text" name="account" class="form-control">
        </div>
        <div class="input-group">
            <span class="input-group-addon">密码：</span>
            <input id="main_manger_pwd" type="password" name="pwd" class="form-control">
        </div>
        <div class="input-group">
            <span class="input-group-addon">电话：</span>
            <input id="main_manger_phone" type="text" name="phone" class="form-control">
        </div>
        <div class="input-group">
            <span class="input-group-addon">身份证：</span>
            <input id="main_manger_id_code" type="text" name="id_code" class="form-control">
        </div>
    </form>
        <a class="btn btn-success btn-block" href="javascript:managersave()">保存</a>

</div>



<script type="text/javascript">
    function managerinit() {
        //表格
        $("#manager_grid").datagrid({
            //请求数据，加载数据
            //url:"/manager.do",
            //表格的列
            columns:[[
                {field:"mid",title:"",width:100,checkbox:true},//添加选择框
                {field:"nick_name",title:"昵称",width:100},
                {field:"account",title:"账号",width:100},
                {field:"pwd",title:"密码",width:100},
                {field:"phone",title:"电话",width:200},
                {field:"id_code",title:"身份证号",width:250}
            ]],
            //工具栏
            toolbar:[
                {text:"添加",iconCls:"icon-add",handler:function(){addmanager();}},
                {text:"修改",iconCls:"icon-edit",handler:function(){editmanager();}},
                {text:"删除",iconCls:"icon-remove",handler:function(){removemanager();}},
                {text:"分配角色",iconCls:"icon-search",handler:function(){powermanager();}}
            ]

        });
        //加载管理员数据
        loadmanager();
        //角色表格初始化
        roleinit();
    }
    //角色表格初始化
    function roleinit() {
        //表格
        $("#main_manager_role_grid").datagrid({
            //请求数据，加载数据
            //url:"/findAllRole.do",
            //表格的列
            columns:[[
                {field:"rid",title:"",width:100,checkbox:true},//添加选择框
                {field:"name",title:"名称",width:100}
            ]]
        });
    }
    //加载角色数据
    function loadRole() {
        $.getJSON("/findAllRole.do",function(data){
            $("#main_manager_role_grid").datagrid("loadData",data);
        });
    }
    //异步请求数据，并加载数据
    function loadmanager(){
        $.getJSON("/manager.do",function(data){
            $("#manager_grid").datagrid("loadData",data);
        });
    }
    //弹窗输入框初始化
    function alertinit() {
        $("#main_manger_nick_name").val("");
        $("#main_manger_mid").val("");
        $("#main_manger_account").val("");
        $("#main_manger_pwd").val("");
        $("#main_manger_phone").val("");
        $("#main_manger_id_code").val("");
    }
    //添加管理员
    function addmanager() {
        alertinit();//输入框初始化
        $("#main_manger_mid").val(0);//给mid输入框赋值
        $("#main_manger_alert").window("open");//让弹窗显示
    }
    //修改管理员
    function editmanager() {
        var a=$("#manager_grid").datagrid("getSelected");//获取选中的数据
        if(a){
            $("#main_manger_nick_name").val(a.nick_name);//给昵称赋值
            $("#main_manger_mid").val(a.mid);//给mid输入框赋值
            $("#main_manger_account").val(a.account);//给账号输入框赋值
            $("#main_manger_pwd").val(a.pwd);//给密码输入框赋值
            $("#main_manger_phone").val(a.phone);//给电话赋值
            $("#main_manger_id_code").val(a.id_code);//给身份证赋值
            $("#main_manger_alert").window("open");//让弹窗显示

        }else{
            $.messager.alert("系统提示","请只选择一条数据！");
        }
    }
    //删除管理员
    function removemanager() {

        //获取要删除的数据
        var rows=$("#manager_grid").datagrid("getSelections");
        if(rows!=""){
            alert(rows);
            //定义mid数组
            var mids=[];
            //循环封装mid
            for(var i in rows){
                mids[i]=rows[i].mid
            }
            //转换成JSON数据
            var a=JSON.stringify(mids);
            alert(a);
            //异步请求
            $.ajax({
                url:"/removemanager.do",
                method:"post",
                data:a,
                contentType:"application/json",
                success:function(data){
                    //重新加载数据
                    loadmanager();
                }
            });
        }else{
            $.messager.alert("系统提示","请至少选择一条数据！");
        }
    }

    //分配角色
    function powermanager() {
        var a=$("#manager_grid").datagrid("getSelections");//获取选中的数据
        if(a.length==1){
            loadRole();
            $("#main_manger_role_alert").window("open");
        }else{
            $.messager.alert("系统提示","请选择一个用户");
        }
    }
    //保存或更新
    function managersave() {
        var a=$("#main_manger_form").serialize();//序列化form表单中的数据
        $.get("/saveOrUpdateManager.do",a,function(d){//异步请求
            $("#main_manger_alert").window("close");//关闭弹窗
            //重新加载数据
            loadmanager();
        });
    }
    //分配角色提交
    function rolesave() {
        alert("可以");
    }
    $(managerinit);
</script>