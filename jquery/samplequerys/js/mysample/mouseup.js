$(function(){
	var flag = false;
	$('img')
		.mousedown(function(){
			flag=true;
			return false;
		})
		.mouseup(function(){
			flag=false;
		})
		.mousemove(function(e){
			if(flag){
				$(this).css({
					top:e.pageY - 30,
					left:e.pageX - 70
				});
			}
		});
});