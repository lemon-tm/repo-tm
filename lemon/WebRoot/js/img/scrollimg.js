//真相文章曝光图片切换
(function(){
	$(function(){
		var len,num,count = 1;
		var $obj = $(".box_img ul>li");
		len = parseInt($obj.width()) + parseInt($obj.css("marginLeft"))*2;
		num = $obj.length;
		$(".box_img a.prev").click(function(){
			count=count<=1?1:--count;
			showImg();	
		});

		$(".box_img a.next").click(function(){
			count=count>=num?num:++count;
			showImg();
		});

		$obj.each(function(i){
			$(this).click(function(){
				count=i+1;
				showImg();
			});
		});

		function getlen(count){
			$obj.each(function(i){
				if(count==(i+1)){
					len = parseInt($(this).width()) + parseInt($(this).css("marginLeft"))*2;
				}
			});
		}
		function showImg(){
			len = getlen(count) ;
			$obj.removeClass("current").eq(count-1).addClass("current");
			$(".cur_img img").attr("src" , $obj.eq(count-1).find("img").attr("src") );
			if(num>6 && count>=3 && count<=num-3){
				$(".box_img ul").parent().find("ul").css("left",(3-count)*len);
			}
			if(count<4){
				$(".box_img ul").parent().find("ul").css("left", 0 );
			}
			if(count>num-3){
				$(".box_img ul").parent().find("ul").css("right", 0 );
			}
		}
	});
})();