layui.config({
    base: $config.resUrl+"js/" //定义基目录
}).extend({
    ajaxExtention:'ajaxExtention', //加载自定义扩展
    $tool:'tool',
    $api:'api',
}).use(['form','layer','$tool','$api'],function() {
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        $tool = layui.$tool,
        $api = layui.$api;

    //GPS转百度
    function gpsToBaidu(x, y) {

        var ggPoint = new BMap.Point(x, y);
        var convertor = new BMap.Convertor();
        var pointArr = [];
            pointArr.push(ggPoint);
        var point = convertor.translate(pointArr, 1, 5, function (data) {
                if (data.status === 0) {
                    return data.points[0];
                }
            });
            return point;
    }




})