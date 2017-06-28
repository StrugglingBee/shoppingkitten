<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <script>
        function user_init(){

            $("#user_datagrid").datagrid(
                //请求加载页面
                //url:user.do
                //列表的列
                {
                    pagination:true,
                    columns:[[
                        {field:"",title:"",width:100,checkbox:true},//添加选择框
                        {field:"id",title:"id",width:100},
                        {field:"account",title:"账号",width:130},
                        {field:"pwd",title:"密码",width:200},
                        {field:"email",title:"邮箱",width:150 },
                        {field:"phone",title:"电话",width:150},
                        {field:"create_time",title:"创建时间",width:150},
                        {field:"login_count",title:"登录次数",width:100},
                        {field:"login_error",title:"登录错误次数",width:100},
                        {field:"create_ip",title:"注册ip地址",width:150},
//                        {field:"id_code",title:"身份证号",width:250}
                    ]],
                    //工具栏
                    toolbar:[
                        {text:"添加",iconCls:"icon-add",handler:function(){adduser();}},
                        {text:"修改",iconCls:"icon-edit",handler:function(){edituser();}},
                        {text:"删除",iconCls:"icon-remove",handler:function(){removeuser();}},
                        {text:"查找",iconCls:"icon-search",handler:function(){searchuser();}}
                    ],


                });
//            findalluser(1,5);
            findUserByPage(1,5);

        }
        $(user_init);


        function findUserByPage(p,z) {
            $.get("/findUserByPage.do", {page: p, size: z}, function (data) {
//                alert(data);
                var d = $.parseJSON(data); //jQuery.parseJSON(jsonstr)
                $("#user_datagrid").datagrid("loadData", d);
                //获取分页对象
                console.log(d[0].counts);
                var pager = $("#user_datagrid").datagrid("getPager");
                pager.pagination({

                    total: d[0].counts,
                    pageList: [5, 10, 15],
                    pageNumber: p,
                    pageSize: z,
                    beforePageText: '第',//页数文本框前显示的汉字
                    afterPageText: '页    共 {pages} 页',
                    displayMsg: '共{total}条数据',
                    onSelectPage: function (p, z) {
                        $(this).pagination('loading');
                        findUserByPage(p,z)
                        $(this).pagination('loaded');
                    }
                });
            });

        }


//        function findalluser() {
//            $.get("/findalluser.do",function (data) {
////                alert(data);
//                var d= $.parseJSON( data ); //jQuery.parseJSON(jsonstr)
////                $("#user_datagrid").datagrid("loadData",d);
//
//            });
//        }


        //shanchu
        function removeuser(){
            var list= $("#user_datagrid").datagrid("getSelected");
//            var list1=$.toString(list);
            alert(list);
            $.get("/removeUser.do",list,function(){
                alert("删除成功");
            });
        }

        //修改用户
        function edituser(){
            var s=$("#user_datagrid").datagrid("getSelected");
            if(s){
                console.log(s);
                $("#account").val(s.account);
                $("#pwd").val(s.pwd);
                $("#email").val(s.email);
                $("#phone").val(s.phone);
                //隐藏
                $("#id").val(s.id);
                $("#user_window").window('open');
            }
          window.alert("妈的智障，请您选择一条数据！")
        }
        function searchuser(){
            $("#user_window").window('open');
        }
        function adduser() {
            $("#user_window").window('open');
            $("#id").val(0);
        }
        function saveUser(){
            var a=$("#user_window_form").serialize();
//            var id=$("#id").val();
            alert(a);
            $.post("/saveUser.do",a,function () {
                $("#user_window").window('close');

            })
        }
    </script>



<div id="user_datagrid"></div>
<div id="madezhizhang" style="height: 100px"></div>
<div id="user_window" class="easyui-window " style="width: 300px ;padding:10px;" data-options="modal:true,closed:true" title="用户信息管理">
    <form id="user_window_form" method="post">
           <input id="id"type="text" name="id" style="display: none">

           账号：<input id="account" type="text" name="account" style="width:100%;height:30px;padding-left:5px"/>
            <br>
           密码： <input id="pwd" type="text" name="pwd" style="width:100%;height:30px";padding-left:5px />
             <br>
          邮箱：  <input id="email" type="text" name="email" style="width:100%;height:30px"; padding-left:5px/>
            <br>
           电话： <input id="phone" type="text" name="phone" style="width:100%;height:30px";padding-left:5px/>
            <br>
            <a href="javascript:saveUser()" class="easyui-linkbutton" >保存</a> <a href="#" class="easyui-linkbutton" >取消</a>
    </form>
    <%--<div id="id" style="display: none;"></div>--%>
</div>



