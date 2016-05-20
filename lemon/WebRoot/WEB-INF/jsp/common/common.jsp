<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="resource-type" content="document" />
<link rel="shortcut icon" href="${base}/img/favicon.ico">
<link rel="stylesheet" href="${base}/css/base.css">
<link rel="stylesheet" href="${base}/css/common.css">
<link rel="stylesheet" href="${base}/css/style.css">
<link rel="stylesheet" href="${base}/css/u-style.css">

<script type="text/javascript" src="${base}/js/jquery.js" charset="UTF-8"></script>
<script type="text/javascript" src="${base}/js/jqueryUI/jquery-ui.js" charset="UTF-8"></script>
<script type="text/javascript" src="${base}/js/jqueryUI/jquery-ui.css" charset="UTF-8"></script>
<script type="text/javascript" src="${base}/js/jquery.row-grid.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var height = $(document).height();
		
		$(".container").css("height",height-60-30-30-60-50-16-5) ;
		
	});
</script>