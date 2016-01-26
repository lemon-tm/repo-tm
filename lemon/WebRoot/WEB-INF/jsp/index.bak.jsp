<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>utf8-jsp/lang/zh-cn/zh-cn.js"></script>
	<jsp:include  page="./common/common.jsp"/>
	<link rel="stylesheet" type="text/css" href="${base}/css/img-style.css" media="screen"/>
 
</head>

<script type="text/javascript">
$(function(){
	$(".center").rowGrid({itemSelector: ".center ul li", minMargin: 5, maxMargin: 5, firstItemClass: "first-item"});
});
</script>

<script type="text/javascript">
window._bd_share_config={
//此处添加分享具体设置
	"common":{//此处放置通用设置
		"bdSnsKey":{},
		"bdText":"",
		"bdMini":"2",
		"bdPic":"",
		"bdStyle":"0",
		"bdSize":"16"
	},
	"share":{//此处放置分享按钮设置
	},
	"slide":{//此处放置浮窗分享设置
	},
	"image":{//此处放置图片分享设置
		"viewList":["qzone","tsina","tqq","renren","weixin"],
		"viewText":"分享到：",
		"viewSize":"16"
	},
	"selectShare":{//此处放置划词分享设置
		"bdContainerClass":null,
		"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]
	}
};

with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
</script>

<body>
<div class="top">
	<div class="top-l">18601253417</div>
	<div class="top-r">微微一笑</div>
</div>
<div class="navigation-box">
	<ul>
		<li>首页</li>
		<li>照片</li>
	</ul>
</div>
<div class="center">
	<ul style="display:block;">
		<li><img src="${base}/image/img/1.jpg" /></li>
		<li><img src="${base}/image/img/2.jpg" /></li>
		<li><img src="${base}/image/img/3.jpg" /></li>
		<li><img src="${base}/image/img/4.jpg" /></li>
		<li><img src="${base}/image/img/5.jpg" /></li>
		<li><img src="${base}/image/img/6.jpg" /></li>
		<li><img src="${base}/image/img/7.jpg" /></li>
		<li><img src="${base}/image/img/8.jpg" /></li>
		<li><img src="${base}/image/img/9.jpg" /></li>
		<li><img src="${base}/image/img/01.jpg" /></li>
		<li><img src="${base}/image/img/02.jpg" /></li>
		<li><img src="${base}/image/img/03.jpg" /></li>
		<li><img src="${base}/image/img/04.jpg" /></li>
		<li><img src="${base}/image/img/05.jpg" /></li>
		<li><img src="${base}/image/img/06.jpg" /></li>
		<li><img src="${base}/image/img/07.jpg" /></li>
		<li><img src="${base}/image/img/08.jpg" /></li>
		<li><img src="${base}/image/img/09.jpg" /></li>
		<li><img src="${base}/image/img/10.jpg" /></li>
		<li><img src="${base}/image/img/11.jpg" /></li>
		<li><img src="${base}/image/img/12.jpg" /></li>
		<li><img src="${base}/image/img/13.jpg" /></li>
		<li><img src="${base}/image/img/14.jpg" /></li>
		<li><img src="${base}/image/img/15.jpg" /></li>
	<div class="clear"></div>
	</ul>
</div>

<div style="display:none;">
<a href="<%=basePath%>tupload.jspx">发布图片</a>

<div>分享功能：</div>

<div>
<div class="bdsharebuttonbox" data-tag="share_1">
	<a class="bds_mshare" data-cmd="mshare"></a>
	<a class="bds_weixin" data-cmd="weixin"></a>
	<a class="bds_sqq" data-cmd="sqq"></a>
	<a class="bds_tsina" data-cmd="tsina"></a>
	<a class="bds_tqq" data-cmd="tqq"></a>
	<a class="bds_douban" data-cmd="douban"></a>
	<a class="bds_more" data-cmd="more">更多</a>
	<a class="bds_count" data-cmd="count"></a>
</div>
<div>富文本框</div>

<div>
    <h1>完整demo</h1>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<div id="btns">
    <div>
        <button onclick="getAllHtml()">获得整个html的内容</button>
        <button onclick="getContent()">获得内容</button>
        <button onclick="setContent()">写入内容</button>
        <button onclick="setContent(true)">追加内容</button>
        <button onclick="getContentTxt()">获得纯文本</button>
        <button onclick="getPlainTxt()">获得带格式的纯文本</button>
        <button onclick="hasContent()">判断是否有内容</button>
        <button onclick="setFocus()">使编辑器获得焦点</button>
        <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
        <button onmousedown="setblur(event)" >编辑器失去焦点</button>

    </div>
    <div>
        <button onclick="getText()">获得当前选中的文本</button>
        <button onclick="insertHtml()">插入给定的内容</button>
        <button id="enable" onclick="setEnabled()">可以编辑</button>
        <button onclick="setDisabled()">不可编辑</button>
        <button onclick=" UE.getEditor('editor').setHide()">隐藏编辑器</button>
        <button onclick=" UE.getEditor('editor').setShow()">显示编辑器</button>
        <button onclick=" UE.getEditor('editor').setHeight(300)">设置高度为300默认关闭了自动长高</button>
    </div>

    <div>
        <button onclick="getLocalData()" >获取草稿箱内容</button>
        <button onclick="clearLocalData()" >清空草稿箱</button>
    </div>

</div>
<div>
    <button onclick="createEditor()">
    创建编辑器</button>
    <button onclick="deleteEditor()">
    删除编辑器</button>
</div>

<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
</script>
</div>
</div>

<div class="footer">
	<div class="footer_1">
		服务热线
	</div>
	<div class="footer_2">
	版权声明：所有图片均受著作权保护，未经许可不得使用，不得转载、摘编。 版权所有 北京全景视觉网络科技股份有限公司&nbsp;<a style="color: rgb(153, 153, 153);" href="http://www.miibeian.gov.cn" target="_blank">沪ICP备15042614号</a>
	</div>

</div>
	
</body>
</html>
