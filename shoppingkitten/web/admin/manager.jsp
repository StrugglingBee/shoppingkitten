<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div  class="easyui-layout" data-options="fit:true">
    <%--搜索栏--%>
    <div id="main_manager_searchbox" style="height: 80px;padding: 10px;" data-options="region:'north',collapsed:false,title:'检索栏'">
        <input id="main_manager_search" style="width:300px;" class="easyui-searchbox" data-options="searcher:search,prompt:'请输入搜索关键词',menu:'#main_manager_choice'"></input>
        <div id="main_manager_choice" style="width:120px;" >
            <div data-options="name:'account',iconCls:'icon-ok'">账号</div>
            <div data-options="name:'nick_name'">昵称</div>
            <div data-options="name:'phone'">电话</div>
            <div data-options="name:'id_code'">身份证号</div>

        </div>
    </div>
        <%--数据栏--%>
    <div data-options="region:'center'">
        <div id="manager_grid" data-options="title:'数据栏'"></div>
    </div>

</div>

<%--分配角色弹窗--%>
<div id="main_manger_role_alert" class="easyui-window" data-options="closed:true,modal:true">
    <h3 id="main_manger_role_msg">请选择要分配的角色</h3>
    <div id="main_manager_role_grid"></div>
    <button id="main_manager_role_btn" class="btn btn-success" onclick="rolesave()">提交</button>
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
    var select_roles;

    function managerinit() {
        //表格
        $("#manager_grid").datagrid({
            //请求数据，加载数据
            //url:"/manager.do",
            //表格的列
            pagination: true,//显示分页属性
            columns: [[
                {field: "mid", title: "", width: 100, checkbox: true},//添加选择框
                {field: "nick_name", title: "昵称", width: 100},
                {field: "account", title: "账号", width: 100},
                {field: "pwd", title: "密码", width: 100},
                {field: "phone", title: "电话", width: 200},
                {field: "id_code", title: "身份证号", width: 250}
            ]],
            //工具栏
            toolbar: [
                {
                    text: "添加", iconCls: "icon-add", handler: function () {
                    addmanager();
                }
                },
                {
                    text: "修改", iconCls: "icon-edit", handler: function () {
                    editmanager();
                }
                },
                {
                    text: "删除", iconCls: "icon-remove", handler: function () {
                    removemanager();
                }
                },
                {
                    text: "分配角色", iconCls: "icon-search", handler: function () {
                    powermanager();
                }
                }
            ]

        });
        //加载管理员数据
        loadmanager(1, 5);
        //角色表格初始化
        roleinit();
        //加载所有的角色数据
//        loadRole();
    }
    //角色表格初始化
    function roleinit() {
        //表格
        $("#main_manager_role_grid").datagrid({
            //请求数据，加载数据
//            url:"/findAllRole.do",
            //表格的列
            columns: [[
                {field: "rid", title: "", width: 100, checkbox: true},//添加选择框
                {field: "name", title: "名称", width: 100}
            ]],
            onLoadSuccess: function (row) {//当表格成功加载时执行
                var rowData = row.rows;//获取数据
                $.each(rowData, function (idx, val) {//遍历JSON
                    $.each(select_roles, function (srid, sval) {
                        if (val.rid == sval.rid) {//判断条件
                            $("#main_manager_role_grid").datagrid("selectRow", idx);//如果数据行为已选中则选中改行
                        }
                        ;
                    });
                });
            }
        });
    }
    //加载角色数据
    function loadRole() {

        $.getJSON("/findAllRole.do", function (data) {
            $("#main_manager_role_grid").datagrid("loadData", data);
        });

    }
    //加载账号数据
    function loadmanager(p, z) {
        //异步获取对象
        $.getJSON("/manager.do", {page: p, size: z}, function (data) {
            //把数据加载到表格中
            $("#manager_grid").datagrid("loadData", data);
            //获取分页器
            var pager = $("#manager_grid").datagrid("getPager");
            pager.pagination({
                total: data[0].total,//一共显示多少条数据
                pageNumber: p,//设置当前页码
                pageSize: z,//设置显示信息条数
                pageList: [5, 10, 15],//设置页面尺寸，显示多少条信息
                //获取分页控制器事件page：当前页码，size:显示数据数量
                onSelectPage: function (page, size) {
                    loadmanager(page, size);//加载信息
                }
            });
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
        var a = $("#manager_grid").datagrid("getSelected");//获取选中的数据
        if (a) {
            $("#main_manger_nick_name").val(a.nick_name);//给昵称赋值
            $("#main_manger_mid").val(a.mid);//给mid输入框赋值
            $("#main_manger_account").val(a.account);//给账号输入框赋值
            $("#main_manger_pwd").val(a.pwd);//给密码输入框赋值
            $("#main_manger_phone").val(a.phone);//给电话赋值
            $("#main_manger_id_code").val(a.id_code);//给身份证赋值
            $("#main_manger_alert").window("open");//让弹窗显示

        } else {
            $.messager.alert("系统提示", "请只选择一条数据！");
        }
    }
    //删除管理员
    function removemanager() {

        //获取要删除的数据
        var rows = $("#manager_grid").datagrid("getSelections");
        if (rows != "") {
            alert(rows);
            //定义mid数组
            var mids = [];
            //循环封装mid
            for (var i in rows) {
                mids[i] = rows[i].mid
            }
            //转换成JSON数据
            var a = JSON.stringify(mids);
            //异步请求
            $.ajax({
                url: "/removemanager.do",
                method: "post",
                data: a,
                contentType: "application/json",
                success: function (data) {
                    //重新加载数据
                    loadmanager();
                }
            });
        } else {
            $.messager.alert("系统提示", "请至少选择一条数据！");
        }
    }

    //分配角色
    function powermanager() {
        var a = $("#manager_grid").datagrid("getSelections");//获取选中的数据
        if (a.length == 1) {
            findRoleByManagerID(a[0].mid);
            $("#main_manger_role_alert").window("open");
        } else {
            $.messager.alert("系统提示", "请选择一个用户");
        }
    }
    //保存或更新管理员
    function managersave() {
        var a = $("#main_manger_form").serialize();//序列化form表单中的数据
        $.get("/saveOrUpdateManager.do", a, function (d) {//异步请求
            $("#main_manger_alert").window("close");//关闭弹窗
            //重新加载数据
            loadmanager();
        });
    }
    //分配角色提交
    function rolesave() {
        //获取账号
        var manager = $("#manager_grid").datagrid("getSelected");
        //获取选择的角色
        var roles = $("#main_manager_role_grid").datagrid("getSelections");
        //定义数组
        var manager_roles = [];
        //封装
        for (var i in roles) {
            var manager_role = {mid: manager.mid, rid: roles[i].rid}
            manager_roles[i] = manager_role;
        }
        var json = JSON.stringify(manager_roles);
        alert(json);
        $.ajax({
            url: "/insertRoleByManagerID.do",
            method: "post",
            data: json,
            contentType: "application/json",
            success: function (data) {
                $("#main_manger_role_alert").window("close");
            }
        });

    }
    //根据选择的账号查找拥有的所有角色
    function findRoleByManagerID(mid) {
        $.post("/findRoleByManagerID.do", {mid: mid}, function (data) {
            select_roles = JSON.parse(data);
            loadRole();
        });
    }
    //搜索功能
    function search(value, name) {
        $.getJSON("/searchManager.do",{type:name,value:value},function (data) {
            $("#manager_grid").datagrid("loadData",data);
        });
    }

    $(managerinit);
</script>