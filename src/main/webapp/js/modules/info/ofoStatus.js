
function statusFormat(cellvalue,options,rowObject){
	var status = "";
	if(cellvalue == 1){
		status += "正常";
	}
	else if(cellvalue == 2){
		status += "故障";
	}
	else{
		status += "报废";
	}
	return status;
}

function search(){
	var options = $("#ofoStatus option:selected");
	var ofoStatus = options.val();
	//alert(status);
	$("#grid-table").jqGrid("setGridParam",{url:'status/search',postData: {'ofoStatus':ofoStatus}}).trigger('reloadGrid');
}