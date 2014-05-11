$(function(){
	$('#big').attr('src', $('#list img:last').attr('src'));
});
$(function(){		
	$('#list img')
		.mouseover(function(){
			var img = $(this).attr('src');
			$('#big')
				.hide(500,function(){$(this).attr('src',img);
			})
			.show(1000);
	});
});
