//菜单点击事件
$(function(){
	$(".J_menuItem").on('click',function(){
		var url= $(this).attr('href');
		$("#J_iframe").attr('src',url);
		return false;
	})
})