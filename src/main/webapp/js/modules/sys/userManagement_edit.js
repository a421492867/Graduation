$(function(){
	var thisRoleId = $("#thisRole").val();
	document.getElementById("role").value = thisRoleId;
	
});

function doEdit() {debugger;
var result;
$.ajax({
	type : "post",
	url : "editUserByRoot",
	dataType : 'JSON',
	async : false,
	timeout : 30000,
	data: $("#editUser").serialize(),
	success : function(resp){
	result=resp;
}
});

return result;
}