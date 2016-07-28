//真相文章曝光图片切换
(function(){
	$(function(){
		var state = $("#state").val() ;
		$("#stateshow").html(state) ;
		
		var index = $("#indexfs").val() ;
		
		var len,num,count = 1;
		
		if(index){
			count = parseInt(index)+1 ;
		}
		var $obj = $(".box_img ul>li");
		len = parseInt($obj.width()) + parseInt($obj.css("marginLeft"))*2;
		totolen = 0 ;
		num = $obj.length;
		
		showImg() ;
		
		$(".box_img a.prev").click(function(){
			count=count<=1?1:--count;
			showImg();	
		});

		$(".box_img a.next").click(function(){
			count=count>=num?num:++count;
			showImg();
		});

		var temp= 0;//临时变量用于设置ul总长度
		$obj.each(function(i){
			temp+= parseInt(3 + $(this).width()) + parseInt($(this).css("marginLeft"))*2;
			
			$(this).click(function(){
				count=i+1;
				showImg($(this));
			});
		});
		//设置总长度ul
		if(totolen==0){
			totolen=temp ;
			$(".box_img ul").parent().find("ul").css("width",totolen+"px");
		}
		
		function getlen(count){
			$obj.each(function(i){
				if(count==(i+1)){
					//---------------------------------------
					var index = $(this).find($(".index")).val() ;
					$("#index").val(index) ;
					
					var imgId = $(this).find($(".imgId")).val() ;
					$("#imgId").val(imgId) ;
					
					state = $(this).find($(".state")).val() ;
					$("#stateshow").html(state) ;
					
					len = parseInt($(this).width()) + parseInt($(this).css("marginLeft"))*2;
					
				}
			});
		}
		function showImg(the){
			//alert("len="+len+";num="+num+";count="+count) ;
			getlen(count) ;
			
			$obj.removeClass("current").eq(count-1).addClass("current");
			
			$(".cur_img img").attr("src" , $obj.eq(count-1).find("img").attr("src") );
			
			if(num>4 && count>=4 && count<=num-4){
				$(".box_img ul").parent().find("ul").css("left",(4-count)*len);
			}else if(count<4){
				$(".box_img ul").parent().find("ul").css("left", 0 );
			}else if(count>num-4){
				$(".box_img ul").parent().find("ul").css('left','') ;
				$(".box_img ul").parent().find("ul").css("right", 0 );
			}
		}
	});
})();