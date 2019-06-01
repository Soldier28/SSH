layui.use(['form','layer'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
        //弹出loading
        // var index = top.layer.msg('数据请求中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        // $.post(updateFlag==='0'?"../../../sysJson/staff_addSecStaff.action":"../../../sysJson/staff_updateSecStaff.action",{//
        //     secStaffId : updateFlag==='0'?null:$(".Id").val(),//id
        //     secStaffName : $(".secStaffName").val(),  //登录名
        //     secStaffPhone : $(".secStaffPhone").val(),  //邮箱
        //     secStaffSex : data.field.sex,  //性别
        //     secStaffStatus : data.field.userStatus,    //用户状态
        //     newsTime : submitTime,    //添加时间
        //     secStaffCode : $(".secStaffCode").val(),  //邮箱
        //     secStaffDesc : $(".secStaffDesc").text(),    //用户简介
        // },function(res){
        //     if (res.code === 0){
        //         top.layer.close(index);
        //         layer.closeAll("iframe");
        //         //刷新父页面
        //         parent.location.reload();
        //     }else {
        //         top.layer.close(index);
        //         top.layer.msg("获取数据失败！");
        //     }
        // })
    // var myChart = echarts.init(document.getElementById('main'));
    //
    // option = {
    //     legend: {},
    //     tooltip: {},
    //     dataset: {
    //         source: [
    //             ['product', '2012', '2013', '2014', '2015'],
    //             ['Matcha Latte', 41.1, 30.4, 65.1, 53.3],
    //             ['Milk Tea', 86.5, 92.1, 85.7, 83.1],
    //             ['Cheese Cocoa', 24.1, 67.2, 79.5, 86.4]
    //         ]
    //     },
    //     xAxis: [
    //         {type: 'category', gridIndex: 0},
    //         {type: 'category', gridIndex: 1}
    //     ],
    //     yAxis: [
    //         {gridIndex: 0},
    //         {gridIndex: 1}
    //     ],
    //     grid: [
    //         {bottom: '55%'},
    //         {top: '55%'}
    //     ],
    //     series: [
    //         // These series are in the first grid.
    //         {type: 'bar', seriesLayoutBy: 'row'},
    //         {type: 'bar', seriesLayoutBy: 'row'},
    //         {type: 'bar', seriesLayoutBy: 'row'},
    //         // These series are in the second grid.
    //         {type: 'bar', xAxisIndex: 1, yAxisIndex: 1},
    //         {type: 'bar', xAxisIndex: 1, yAxisIndex: 1},
    //         {type: 'bar', xAxisIndex: 1, yAxisIndex: 1},
    //         {type: 'bar', xAxisIndex: 1, yAxisIndex: 1}
    //     ]
    // };
        return false;
    // })
})