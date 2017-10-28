function doEdit() {debugger;
	var result;
	$.ajax({
		type : "post",
		url : "editInfo",
		dataType : 'JSON',
		async : false,
		timeout : 30000,
		data: $("#editInfo").serialize(),
		success : function(resp){
		result=resp;
	}
	});
	
	return result;
}