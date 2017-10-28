function validate(val){
	var userName = val;
	$.ajax({
		type : "post",
		url : "validate",
		dataType : 'JSON',
		async : false,
		timeout : 30000,
		data: {
			userName : userName
		},
		success : function(result){
			if(result.result > 0){
				$("#check").html("<font color='red'><i class='fa fa-close'></i></font>");
			}else{
				$("#check").html("<font color='green'><i class='fa fa-check'></i></font>");
			}
			
	}
	});
}

function doSubmit(){
	var result;
	$.ajax({
		type : "post",
		url : "addUser",
		dataType : 'JSON',
		async : false,
		timeout : 30000,
		data: $("#addUser").serialize(),
		success : function(resp){
		result=resp;
	}
	});
	
	return result;
}