function reform(){
	var ids = $("#grid-table").jqGrid("getDataIDs");
	for (var i = 0; i < ids.length; i++) {
		/*btn_edit = '<button type="button" onclick="jQuery.fn.fmatter.rowactions.call(this,\'edit\');" class="btn btn-xs btn-edit" id="editBtn_'
				+ ids[i] + '">' + '修改' + '</button>' + '</div>';*/
		
		btn_edit = '<a type="button" class="fa fa-wrench"  id="editBtn_'+ids[i]+'" onclick="edit(\''+ids[i]+'\')">';

		jQuery("#grid-table").jqGrid('setRowData', ids[i], {
			operation : btn_edit
		});

	}

}


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
	var location = $('#location').val();
	$("#grid-table").jqGrid("setGridParam",{url:'repair/search',postData: {'location':location}}).trigger('reloadGrid');
}

function edit(id){

	var url = "repair/getEditModal?id="+id;
	layer.open({
	    type: 2,  
	    area: ['800px', '500px'],
	    title: '派单',
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['提交', '取消'],
	    yes: function(index, layero){
	    	 var body = layer.getChildFrame('body', index);
	         var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	         if(iframeWin.contentWindow.doEdit()){
	        	 layer.msg('派单成功');
	        	 layer.close(index);
	        	 
	        	 $('#grid-table').trigger('reloadGrid');
	         } else {
	        	 layer.msg('派单失败');
	         }
		  },
		  cancel: function(index){ 
	   
		  }
	}); 

}