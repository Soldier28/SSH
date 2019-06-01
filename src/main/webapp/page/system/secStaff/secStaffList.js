layui.config({
    base: $config.resUrl+"js/" //定义基目录
}).extend({
    ajaxExtention:'ajaxExtention', //加载自定义扩展
    $tool:'tool',
    $api:'api',
}).use(['form','layer','table','laytpl','$tool','$api'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table,
        $tool=layui.$tool,
        $api = layui.$api;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : $tool.getResUrl() + 'sysJson/staff_selectAllSecStaff.action',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'secStaffCode', title: '编号', align:'center'},
            {field: 'secStaffName', title: '用户名', minWidth:100, align:"center"},
            {field: 'secStaffPhone', title: '联系电话', minWidth:200, align:'center'},
            {field: 'secStaffSex', title: '性别', align:'center',templet:function (d) {return d.secStaffSex == 0 ? '男' : '女';}},
            {field: 'area', title: '所属区域', align:'center', align:'center',templet:function (d) {
                return d.area!=null?d.area.areaName:'暂未分配';
                }},
            {field: 'secStaffStatus', title: '用户状态',  align:'center',templet:function(d){return d.secStaffStatus == 0 ? "正常使用" : "限制使用";}},
            // {field: 'userEndTime', title: '最后登录时间', align:'center',minWidth:150},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            var index = layer.msg('查询中,请稍候...',{icon: 16,time:false,shade:0})
            setTimeout(function(){
                table.reload("userListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            });
            layer.close(index);
        },800)
        } else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加
    function addUser(edit){
        var index = layui.layer.open({
            title : "添加",
            type : 2,
            content : "secStaffAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);

                if(edit){
                    body.find(".Id").val(edit.secStaffId);
                    body.find(".secStaffCode").val(edit.secStaffCode);  //登录名
                    body.find(".secStaffName").val(edit.secStaffName);  //邮箱
                    body.find(".secStaffSex input[value="+edit.secStaffSex+"]").prop("checked","checked");  //性别
                    body.find(".secStaffPhone").val(edit.secStaffPhone);  //联系电话
                    body.find(".areaOfSceStaffId option[value="+edit.area.areaId+"]").prop("selected",true); //地区
                    body.find(".secStaffStatus option[value="+edit.secStaffStatus+"]").prop("selected",true); //状态
                    body.find(".secStaffSex").val(edit.secStaffSex);    //用户状态
                    body.find(".secStaffDesc").text(edit.secStaffDesc!=null?edit.secStaffDesc:'');    //用户简介
                    body.find(".updateFlag").val(1);//更新标识
                    form.render();
                }

            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].secStaffId);
            }
            console.log(newsId)
            layer.confirm('确定删除选中的保安人员？', {icon: 3, title: '提示信息'}, function (index) {
                $.post($tool.getResUrl()+"sysJson/staff_deleteAllSecStaff.action",{
                    secStaffIds : newsId.join(',') //将需要删除的newsId作为参数传入
                },function(data){
                    if (data===0){
                        layer.msg("删除成功");
                    }
                tableIns.reload();
                layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此保安人员？',{icon:3, title:'提示信息'},function(index){
                $.get($tool.getResUrl()+"sysJson/staff_deleteSecStaff.action",{
                    secStaffId : data.secStaffId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.code === 0){
                        layer.msg("删除成功");
                    }
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
    });

})
