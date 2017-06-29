<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div  class="easyui-layout" data-options="fit:true">
    <%--搜索栏--%>
    <div id="main_role_searchbox" style="height: 80px;padding: 10px;" data-options="region:'north',collapsed:false,title:'检索栏'">
        <input id="main_role_search" style="width:300px;" class="easyui-searchbox" data-options="searcher:searchrole,prompt:'请输入关键词',menu:'#main_role_choice'"></input>
        <div id="main_role_choice" style="width:120px;">
            <div data-options="name:'name',iconCls:'icon-ok'">名称</div>
        </div>
    </div>
    <%--数据栏--%>
    <div data-options="region:'center'">
        <div id="role_grid" data-options="title:'数据栏'"></div>
    </div>
</div>


<%--分配权限弹窗--%>
<div id="main_role_privilege_alert" class="easyui-window" data-options="closed:true,modal:true">
    <h3 id="main_role_privilege_msg">请选择要分配的权限</h3>
    <div id="main_role_privilege_grid"></div>
    <button id="main_role_privilege_btn" class="btn btn-success" onclick="privilegesave()">提交</button>
</div>

<%--分配资源弹窗--%>
<div id="main_role_resource_alert" style="width: 300px;height: 500px;" class="easyui-window" data-options="closed:true,modal:true">
    <h3 id="main_role_resource_msg" style="width: 250px;text-align: center;color: orangered;margin: 10px auto;">请选择要分配的资源</h3>
    <div id="main_role_resource_grid"></div>
    <div style="display:flex;justify-content:center;margin-top: 10px;">
        <a class="easyui-linkbutton" href="javascript:resourcesave()" style="display: inline-block; width: 200px;height: 35px;">保 存</a>
    </div>
</div>


<%--分配资源弹窗（只显示一个树，放弃）--%>
<%--<div id="main_role_resource_alert" class="easyui-window" data-options="closed:true,modal:true" style="width: 300px;height: 400px;">--%>
    <%--<ul id="main_role_resource_tree" class="easyui-tree" style="margin-bottom: 30px;"></ul>--%>
    <%--<div style="display:flex;justify-content:center">--%>
        <%--<a class="easyui-linkbutton" href="javascript:resourcesave()" style="display: inline-block; width: 200px;height: 35px;">保 存</a>--%>
    <%--</div>--%>
<%--</div>--%>

<!-- 添加角色弹窗 -->
<div id="main_role_alert" class="easyui-window" data-options="closed:true,modal:true">
    <form id="main_role_form" class="form-group" style="margin: 10px;">
        <input id="main_role_rid" type="hidden" name="rid" class="form-control">
        <div class="input-group">
            <span class="input-group-addon">名称：</span>
            <input id="main_role_name" type="text" name="name" class="form-control">
        </div>
    </form>
    <a class="btn btn-success btn-block" href="javascript:rolesave()">保存</a>

</div>

<script type="text/javascript">
    var select_privileges;

    function roleinit() {
        //表格
        $("#role_grid").datagrid({
            //请求数据，加载数据
            //url:"/manager.do",
            //表格的列
            pagination: true,//显示分页属性
            columns: [[
                {field: "rid", title: "", width: 100, checkbox: true},//添加选择框
                {field: "name", title: "名称", width: 100}
            ]],
            //工具栏
            toolbar: [
                {
                    text: "添加", iconCls: "icon-add", handler: function () {
                    addrole();
                }
                },
                {
                    text: "修改", iconCls: "icon-edit", handler: function () {
                    editrole();
                }
                },
                {
                    text: "删除", iconCls: "icon-remove", handler: function () {
                    removerole();
                }
                },
                {
                    text: "分配权限", iconCls: "icon-man", handler: function () {
                    powerprivilege();
                }
                },
                {
                    text: "分配资源", iconCls: "icon-lock", handler: function () {
                    powerresource();
                }
                }
            ]

        });
        //加载角色数据
        loadrole(1,5);
        //分配权限表格初始化
        role_privilegeinit();
        role_resourceinit();
    }
    //加载账号数据
    function loadrole(p, z) {
        //异步获取对象
        $.getJSON("/role.do", {page: p, size: z}, function (data) {
            //把数据加载到表格中
            $("#role_grid").datagrid("loadData", data);
            //获取分页器
            var pager = $("#role_grid").datagrid("getPager");
            pager.pagination({
                total: data[0].total,//一共显示多少条数据
                pageNumber: p,//设置当前页码
                pageSize: z,//设置显示信息条数
                pageList: [5, 10, 15],//设置页面尺寸，显示多少条信息
                //获取分页控制器事件page：当前页码，size:显示数据数量
                onSelectPage: function (page, size) {
                    loadrole(page, size);//加载信息
                }
            });
        });
    }
    //角色弹窗输入框初始化
    function main_role_alert_init() {
        $("#main_role_name").val("");
        $("#main_role_rid").val("");
    }
    //添加角色
    function addrole() {
        main_role_alert_init();//初始化弹窗
        $("#main_role_rid").val(0);//给mid输入框赋值
        $("#main_role_alert").window("open");//让弹窗显示
    }
    //保存或更新角色
    function rolesave(){
        var a = $("#main_role_form").serialize();//序列化form表单中的数据
        $.get("/saveOrUpdateRole.do", a, function (d) {//异步请求
            $("#main_role_alert").window("close");//关闭弹窗
            //重新加载数据
            loadrole(1,5);
        });
    }
    function editrole() {
        var a = $("#role_grid").datagrid("getSelected");//获取选中的数据
        if (a) {
            $("#main_role_name").val(a.name);//给名称赋值
            $("#main_role_rid").val(a.rid);//给rid输入框赋值
            $("#main_role_alert").window("open");//让弹窗显示
        } else {
            $.messager.alert("系统提示", "请只选择一条数据！");
        }
    }
    function removerole() {
        //获取要删除的数据
        var rows = $("#role_grid").datagrid("getSelections");
        if (rows != "") {
            //定义rid数组
            var rids = [];
            //循环封装rid
            for (var i in rows) {
                rids[i] = rows[i].rid
            }
            //转换成JSON数据
            var a = JSON.stringify(rids);
            //异步请求
            $.ajax({
                url: "/removerole.do",
                method: "post",
                data: a,
                contentType: "application/json",
                success: function (data) {
                    //重新加载数据
                    loadrole(1,5);
                }
            });
        } else {
            $.messager.alert("系统提示", "请至少选择一条数据！");
        }
    }
    //分配权限
    function powerprivilege() {
        var a = $("#role_grid").datagrid("getSelections");//获取选中的数据
        if (a.length == 1) {
            //通过角色ID查找拥有的权限
            findPrivilegeByRoleID(a[0].rid);
            $("#main_role_privilege_alert").window("open");
        } else {
            $.messager.alert("系统提示", "请选择一个角色");
        }
    }
    //根据选择的角色查找拥有的所有权限
    function findPrivilegeByRoleID(rid) {
        $.post("/findPrivilegeByRoleID.do", {rid: rid}, function (data) {
            select_privileges = JSON.parse(data);
            loadRole_privilege();
        });
    }
    //权限表格初始化
    function role_privilegeinit() {
        //表格
        $("#main_role_privilege_grid").datagrid({
            //请求数据，加载数据
//            url:"/findAllRole.do",
            //表格的列
            columns: [[
                {field: "pid", title: "", width: 100, checkbox: true},//添加选择框
                {field: "p_name", title: "名称", width: 100},
                {field: "p_remark", title: "说明", width: 300}
            ]],
            onLoadSuccess: function (row) {//当表格成功加载时执行
                var rowData = row.rows;//获取数据
                $.each(rowData, function (idx, val) {//遍历JSON
                    $.each(select_privileges, function (sidx, sval) {
                        if (val.pid == sval.pid) {//判断条件
                            $("#main_role_privilege_grid").datagrid("selectRow", idx);//如果数据行为已选中则选中改行
                        }
                        ;
                    });
                });
            }
        });
    }
    //加载权限数据
    function loadRole_privilege() {
        $.getJSON("/findAllPrivilege.do", function (data) {
            $("#main_role_privilege_grid").datagrid("loadData", data);
        });
    }
    //分配权限保存
    function privilegesave() {
        //获取角色
        var role = $("#role_grid").datagrid("getSelected");
        //获取选择的权限
        var privileges = $("#main_role_privilege_grid").datagrid("getSelections");
        //定义数组
        var role_privileges = [];
        //判断是否有选择
        if (privileges.length>0){
            //封装
            for (var i in privileges) {
                var role_privilege = {rid: role.rid, pid: privileges[i].pid}
                role_privileges[i] = role_privilege;
            }
        }else {
            var role_privilege = {rid: role.rid, pid: 0}
            role_privileges[0] = role_privilege;
        }

        var json = JSON.stringify(role_privileges);
        $.ajax({
            url: "/insertPrivilegeByRoleID.do",
            method: "post",
            data: json,
            contentType: "application/json",
            success: function (data) {
                $("#main_role_privilege_alert").window("close");
                $.messager.alert("系统提示", "分配权限成功！");
            }
        });
    }
    function powerresource() {
        var a = $("#role_grid").datagrid("getSelections");//获取选中的数据
        if (a.length == 1) {
            //请求数据并加载
            loadrole_resource(a[0].rid);
//            只显示一棵树
//            $("#main_role_resource_tree").tree({
//                url:"/findResourceByRoleID.do?rid="+a[0].rid,
//                checkbox:true,
//                cascadeCheck:false
//            });
//            $("#main_role_resource_alert").window("open");
        } else {
            $.messager.alert("系统提示", "请选择一个角色");
        }
    }
    //资源弹窗初始化
    function role_resourceinit() {
        //初始化
        $("#main_role_resource_grid").treegrid({
            title:"资源信息",
//            url:"/findResourceByRoleID.do?rid=1",//请求资源
            idField:"resource_id",
            treeField:"text",
            rownumbers:false,//行号
            singleSelect:false,//多选,设置成true为多选
            columns:[[
                {field:"resource_id",title:"",width:100,checkbox:true},
                {field:"text",title:"资源名称",width:200}
            ]],
            onLoadSuccess:function (rows,data) {//数据加载成功触发
                $.each(data,function (idex,val) {//循环遍历根节点
                    //判断是否拥有该节点资源
                    if(val.biaoji==1){
                        $("#main_role_resource_grid").treegrid("select", val.resource_id);//选中
                    }else {
                        $("#main_role_resource_grid").treegrid("unselect", val.resource_id);//取消选中
                    }
                    var child=val.children;//获取所有的孩子节点数组
                    var length=child.length;//获取数组长度
                    if(length>1){//判断数组不为空
                        $.each(child,function (idex, val) {//循环数组
                            //判断是否拥有该节点资源
                            if(val.biaoji==1){
                                $("#main_role_resource_grid").treegrid("select", val.resource_id);//选中
                            }else {
                                $("#main_role_resource_grid").treegrid("unselect", val.resource_id);//取消选中
                            }
                        })
                    }

                })
            }
        });
    }
    //加载资源信息
    function loadrole_resource(rid) {
        $.getJSON("/findResourceByRoleID.do?rid="+rid, function (data) {
            $("#main_role_resource_grid").treegrid("loadData", data);
            $("#main_role_resource_alert").window("open");
        });
    }
    //分配资源保存
    function resourcesave() {
        //获取角色
        var role = $("#role_grid").datagrid("getSelected");
        //获取选择的资源
        var resources = $("#main_role_resource_grid").treegrid("getSelections");
        //定义数组
        var role_resources = [];
        //判断是否有选择
        if(resources.length>0){
            //封装
            for (var i in resources) {
                var role_resource = {rid: role.rid, resource_id: resources[i].resource_id}
                role_resources[i] = role_resource;
            }
        }else {
            var role_resource = {rid: role.rid, resource_id: 0};
            role_resources[0] = role_resource;
        }
        //转化成JSON字符串
        var json = JSON.stringify(role_resources);
        $.ajax({
            url: "/insertResourceByRoleID.do",//请求地址
            method: "post",//方式
            data: json,//数据
            contentType: "application/json",//格式
            success: function (data) {//请求成功返回
                $("#main_role_resource_alert").window("close");
                $.messager.alert("系统提示", "分配资源成功！");
            }
        });
    }
    //搜索功能
    function searchrole(value, name) {
        $.getJSON("/searchRole.do",{type:name,value:value},function (data) {
            $("#role_grid").datagrid("loadData",data);
        });
    }
    $(roleinit);
</script>