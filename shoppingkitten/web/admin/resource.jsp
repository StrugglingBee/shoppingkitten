<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div  class="easyui-layout" data-options="fit:true">
    <%--搜索栏--%>
    <div id="main_resource_searchbox" style="height: 80px;padding: 10px;" data-options="region:'north',collapsed:false,title:'检索栏'">
        <input id="main_resource_search" style="width:300px;" class="easyui-searchbox" data-options="searcher:searchresource,prompt:'请输入关键词',menu:'#main_resource_choice'"></input>
        <div id="main_resource_choice" style="width:120px;">
            <div data-options="name:'p_name',iconCls:'icon-ok'">名称</div>
            <div data-options="name:'p_remark'">备注</div>
        </div>
    </div>
    <%--数据栏--%>
    <div data-options="region:'center'">
        <div id="resource_grid" data-options="title:'数据栏'"></div>
    </div>
</div>

<!-- 添加角色弹窗 -->
<div id="main_resource_alert" class="easyui-window" data-options="closed:true,modal:true">
    <form id="main_resource_form" class="form-group" style="margin: 10px;">
        <input id="main_resource_resourceid" type="hidden" name="resourceid" class="form-control">
        <div class="input-group">
            <span class="input-group-addon">名称：</span>
            <input id="main_resource_text" type="text" name="text" class="form-control">
        </div>
        <div class="input-group">
            <span class="input-group-addon">URL：</span>
            <input id="main_resource_url" type="text" name="url" class="form-control">
        </div>
        <div class="input-group">
            <span class="input-group-addon">上级：</span>
            <input id="main_resource_parent_id" type="text" name="parent_id" class="form-control">
        </div>
    </form>
    <a class="btn btn-success btn-block" href="javascript:resourcesave()">保存</a>

</div>

<script type="text/javascript">
    function resourceinit() {
        //表格
        $("#resource_grid").datagrid({
            //请求数据，加载数据
            //url:"/manager.do",
            //表格的列
            pagination: true,//显示分页属性
            columns: [[
                {field: "resourceid", title: "", width: 100, checkbox: true},//添加选择框
                {field: "text", title: "名称", width: 100},
                {field: "url", title: "URL", width: 100},
                {field: "parent_id", title: "父ID", width: 100}
            ]],
            //工具栏
            toolbar: [
                {
                    text: "添加", iconCls: "icon-add", handler: function () {
                    addresource();
                }
                },
                {
                    text: "修改", iconCls: "icon-edit", handler: function () {
                    editresource();
                }
                },
                {
                    text: "删除", iconCls: "icon-remove", handler: function () {
                    removeresource();
                }
                }
            ]

        });
//        loadprivilege(1,5);
    }
    //加载账号数据
    //    function loadrole(p, z) {
    //        //异步获取对象
    //        $.getJSON("/privilege.do", {page: p, size: z}, function (data) {
    //            //把数据加载到表格中
    //            $("#role_grid").datagrid("loadData", data);
    //            //获取分页器
    //            var pager = $("#role_grid").datagrid("getPager");
    //            pager.pagination({
    //                total: data[0].total,//一共显示多少条数据
    //                pageNumber: p,//设置当前页码
    //                pageSize: z,//设置显示信息条数
    //                pageList: [5, 10, 15],//设置页面尺寸，显示多少条信息
    //                //获取分页控制器事件page：当前页码，size:显示数据数量
    //                onSelectPage: function (page, size) {
    //                    loadrole(page, size);//加载信息
    //                }
    //            });
    //        });
    //    }
    //    //角色弹窗输入框初始化
    //    function main_role_alert_init() {
    //        $("#main_role_name").val("");
    //        $("#main_role_rid").val("");
    //    }
    //    //添加角色
    //    function addrole() {
    //        main_role_alert_init();//初始化弹窗
    //        $("#main_role_rid").val(0);//给mid输入框赋值
    //        $("#main_role_alert").window("open");//让弹窗显示
    //    }
    //    //保存或更新角色
    //    function rolesave(){
    //        var a = $("#main_role_form").serialize();//序列化form表单中的数据
    //        $.get("/saveOrUpdateRole.do", a, function (d) {//异步请求
    //            $("#main_role_alert").window("close");//关闭弹窗
    //            //重新加载数据
    //            loadrole(1,5);
    //        });
    //    }
    //    function editrole() {
    //        var a = $("#role_grid").datagrid("getSelected");//获取选中的数据
    //        if (a) {
    //            $("#main_role_name").val(a.name);//给名称赋值
    //            $("#main_role_rid").val(a.rid);//给rid输入框赋值
    //            $("#main_role_alert").window("open");//让弹窗显示
    //        } else {
    //            $.messager.alert("系统提示", "请只选择一条数据！");
    //        }
    //    }
    //    function removerole() {
    //        //获取要删除的数据
    //        var rows = $("#role_grid").datagrid("getSelections");
    //        if (rows != "") {
    //            //定义rid数组
    //            var rids = [];
    //            //循环封装rid
    //            for (var i in rows) {
    //                rids[i] = rows[i].rid
    //            }
    //            //转换成JSON数据
    //            var a = JSON.stringify(rids);
    //            //异步请求
    //            $.ajax({
    //                url: "/removerole.do",
    //                method: "post",
    //                data: a,
    //                contentType: "application/json",
    //                success: function (data) {
    //                    //重新加载数据
    //                    loadrole(1,5);
    //                }
    //            });
    //        } else {
    //            $.messager.alert("系统提示", "请至少选择一条数据！");
    //        }
    //    }
    //    function powerrole() {
    //        alert("分配权限");
    //    }
    //    function powerresource() {
    //        alert("分配资源");
    //    }
    //搜索功能
    function searchresource(value, name) {
//        $.getJSON("/searchRole.do",{type:name,value:value},function (data) {
//            $("#role_grid").datagrid("loadData",data);
//        });
    }
    $(resourceinit);
</script>