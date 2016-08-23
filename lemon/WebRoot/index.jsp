<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>意见汇总</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  1、照片可以设置为私人
  2、登录账号密码错误，不可以直接跳转到注册上，有个提示--已修改
  3、上传图片时，有个等待的信息给客户 --已修改
  4、我上传的图片，还没有审核，是可以删除的，审核通过后不予以删除。前期先做成这样，后期再调整。--已修改
  5、账户名称用于登录，应有提醒。
  6、上传图片分开传，不能传一条 6张
  
  7、在用户中心，session过期时登录页面会在iframe里显示
  
  8、产品应该注重的是用户体验而不是功能怎么实现。
  
  9、分类点进去，有问题，分也是整个照片列表的 分页--分析参数没有带全--已修改
  
  10、优化--前台图片最终显示页面应该可以图片滚动
  
  
  
  
灵光：
	1、可以发文章，但是作为图片类网站，怎么给用户看这些文章，显示问题
  
	2、如果用户都是摄影师，该怎么展示图片
  
	3、用户空间，都能做什么？
		1）看这个用户的作品，应该包括文章和图片
		作为娱乐，应该能看到多少人点赞了，，还有留言
  		看用户的一些信息，如：姓名、 生日、谁关注了她，她关注了谁
  
  
  实名点赞 前五名上首页5张图
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>
