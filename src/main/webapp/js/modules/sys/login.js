
/**
 * 判断后台是否传来error，若传来则证明登录过但是用户名／密码错误
 * 提示 用户名／密码错误
 */
window.onload = function(){
	var error = $("#error").val() ;
    if(error != ""){
    	layer.msg(error);
    }
}

