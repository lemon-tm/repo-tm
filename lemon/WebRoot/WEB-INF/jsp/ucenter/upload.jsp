<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传图片页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="./../common/common.jsp" %>
  </head>
  
<body>

	<div class="container-frame">
		
		<form name="saveimgf" action="${base}/saveimg.jspx" method="post">
			<!-- 
			<div class="textareafbox">
				<span class="blue2 fl">描述：</span><textarea name="describes" class="textareaf fl"></textarea>
			</div> -->
			<div class="imgud" >
				<div class="fl" style="display:block;">
					<a class="btn-blue" onClick="imgSubmit()" href="javascript:void(0);">开始上传</a>
				</div>
				<!-- 
				<div class="fl">
					<a class="btn-blue" onClick="showd()" href="javascript:void(0);">描述一下</a>
				</div> -->
				<div id="mfc" class="fl fileinputbox" >
					<div id="likefile" class="likefile bg-blue2">选择图片</div>
					<input onchange="javascript:uploadMedia();" size="30" type="file" name="mediaFile" id="mediaFile"  class="fileinput" value="">
				</div>
				
			</div>
			<div id="showimgsm" class="showimgsm"></div>
		</form>
	<div class="clear"></div>
	</div>

	
	
	
	
<script type="text/javascript">
function showd(){
	$(".textareafbox").css("display","block") ;
}
$(function(){
	var img = $("#showimgsm").find(".showimg") ;
	if(img.length<=0){
		$(".btn-blue").css("display","none");
	}
});
$(document).on("click",".delimg", function(){
   	$(this).parents(".div-img").remove();
});

function imgSubmit(){
	saveimgf.submit() ;
}

//上传附件
function uploadMedia() {

	var mf = $("#mediaFile");
    if(!isPicture(mf.val())){alert("请选择图片上传...") ;
    	return null ;
    }//验证上传文件格式
	//检查是否选择了文件
	if(mf.val()=="") {
		$.alert("提示","请选择要上传的文件");
		return;
	}
	//将file移动至上传表单
	$("#mediaContent").empty();
	$("#mediaContent").append(mf);
	//复制一个file放至原处
	$("#mfc").append(mf.clone().attr('value',''));
	//修改属性
	mf.attr("id","");

	$("#mediaForm").submit();

}

function isPicture(fileName){
	if(fileName!=null && fileName !=""){
	   //lastIndexOf如果没有搜索到则返回为-1
	   	if (fileName.lastIndexOf(".")!=-1) {
			var fileType = (fileName.substring(fileName.lastIndexOf(".")+1,fileName.length)).toLowerCase();
			var suppotFile = new Array();
			suppotFile[0] = "jpg";
			suppotFile[1] = "gif";
			suppotFile[2] = "bmp";
			suppotFile[3] = "png";
			suppotFile[4] = "jpeg";
		 	for (var i =0;i<suppotFile.length;i++) {
		 		if (suppotFile[i]==fileType) {
		 		return true;
		 		} else{
		  		continue;
		 	}
		}
			//alert("文件类型不合法,只能是jpg、gif、bmp、png、jpeg类型！");
			return false;
		} else{
			//alert("文件类型不合法,只能是 jpg、gif、bmp、png、jpeg 类型！");
			return false;
		 }
	 }
 } 
</script>

<form id="mediaForm" action="${base}/upload.jspx" method="post" enctype="multipart/form-data" target="media_iframe" style="display:none;">
<span id="mediaContent" style="position:relative;"></span>
</form>
<iframe name="media_iframe" id="media_iframe" frameborder="0" name="media_iframe" border="0" width="0" height="0" ></iframe>

<script>
$("#media_iframe").load(function() {
    var uploadResultJson = $(this).contents().find("*").first().text();
    var uploadResult = $.parseJSON(uploadResultJson);
    if (uploadResult && uploadResult.success ) {
    	$("#likefile").removeAttr("class");
    	$("#likefile").attr("class","likefile bj-grey2");
		$(".btn-blue").css("display","");
        $("#showimgsm").append(
        				'<div style="float:left;padding-top:10px;padding-left:10px;" class="div-img">'+
        				'<div class="showimg">'+
						'<img width="110px" src="${base}'+uploadResult.msg+'" />'+
						'<input name="imgurl" type="hidden" value="'+uploadResult.msg+'"/>'+
						'<a class="delimg" href="javascript:;" title="删除">删除</a>'+
						'</div>'+'</div>'
						) ;
		
    }
});

</script>
</body>
</html>
