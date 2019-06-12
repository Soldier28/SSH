<%--
  Created by IntelliJ IDEA.
  program: SSH
  Author: soldier
  Email： 583403411@qq.com
  Date: 6/3/19
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="./images/favicon.ico">
    <link rel="stylesheet" href="./layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="./css/public.css" media="all"/>
</head>
<body class="loginBody">
<h1 class="" align="center" style="margin-top: 10%">
    青年志愿者信息管理系统
</h1>
<form class="layui-form">

    <div class="login_face"><img src="./images/head.png" class="userAvatar"></div>
    <div class="layui-form-item input-item">
        <label for="loginAccount">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" id="loginAccount" class="layui-input loginAccount"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="loginPassword">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" id="loginPassword"
               class="layui-input loginPassword" lay-verify="required">
    </div>
    <div class="layui-form-item input-item layui-inline layui-row" id="imgCode">
        <div class="layui-col-md8 layui-col-sm6 layui-col-xs6">
            <label for="code">验证码</label>
            <input type="text" placeholder="请输入验证码" autocomplete="off" id="code" class="layui-input"
                   lay-verify="required">
        </div>
        <div class="layui-col-md4 layui-col-sm6 layui-col-xs6">
            <canvas id="canvas" width="100" height="38"></canvas>
            <!--<img src="./images/code.jpg">-->
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
    </div>
    <div class="layui-form-item layui-row">
    </div>
</form>
<script type="text/javascript" src="./layui/layui.js"></script>
<script type="text/javascript" src="./js/login.js"></script>
<script type="text/javascript" src="./js/cache.js"></script>
</body>
</html>
