<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>图片上传页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include  page="./common/common.jsp"/>
</head>

<body>


<form action="<%=basePath%>saveimg.jspx" method="post">

<div class="">
	<div id="showimgsm" class="message-publish-upload clearfix">
		<div style="float:left;width:110px;height:100px;margin-bottom:10px;">
			<div id="mfc" style="position:relative; left:0;display:block;">
				<input onchange="javascript:uploadMedia('sm');" size="30" type="file" name="mediaFile" id="mediaFile"  class="" value="">
			</div>
		</div>
	</div>
</div>
<input type="submit" />

</form>

<script type="text/javascript">
$(document).on("click",".abc", function(){
   	$(this).parents(".div-img").remove();
});


//上传附件
function uploadMedia(mark) {

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

<form id="mediaForm" action="<%=basePath%>upload.jspx" method="post" enctype="multipart/form-data" target="media_iframe">
<span id="mediaContent"></span>
</form>
<iframe name="media_iframe" id="media_iframe" frameborder="0" name="media_iframe" border="0" width="0" height="0" ></iframe>

<script>
$("#media_iframe").load(function() {
    var uploadResultJson = $(this).contents().find("*").first().text();
    var uploadResult = $.parseJSON(uploadResultJson);
    if (uploadResult && uploadResult.success ) {
        $("#showimgsm").append('<div style="float:left;padding-top:10px;padding-left:10px;" class="div-img">'+'<div class="showimg">'+
						'<img src="'+uploadResult.msg+'" />'+
						'<input name="imgurl" type="hidden" value="'+uploadResult.msg+'"/>'+
						'<a class="abc" href="javascript:;" title="删除">删除</a>'+
						'</div>'+'</div>') ;
		
    }
});

</script>
</body>
</html>
