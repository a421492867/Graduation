function reform(){
	var ids = $("#grid-table").jqGrid("getDataIDs");
	for (var i = 0; i < ids.length; i++) {
		/*btn_edit = '<button type="button" onclick="jQuery.fn.fmatter.rowactions.call(this,\'edit\');" class="btn btn-xs btn-edit" id="editBtn_'
				+ ids[i] + '">' + '修改' + '</button>' + '</div>';*/
		
		btn_edit = '<a type="button" class="fa fa-pencil"  id="editBtn_'+ids[i]+'" onclick="edit(\''+ids[i]+'\')">';
		btn_check = '<a type="button" class="fa fa-search"  id="checkBtn_'+ids[i]+'" style="padding-left:15px" onclick="showLocation(\''+ids[i]+'\')">';

		jQuery("#grid-table").jqGrid('setRowData', ids[i], {
			operation : btn_edit + btn_check
		});

	}

}

function search(){
	var location = $('#location').val();
	//alert(location);
	$("#grid-table").jqGrid("setGridParam",{url:'info/search',postData: {'location':location}}).trigger('reloadGrid');
}

function openAdd(){debugger;
	var url = "info/getAddModal";
	layer.open({
	    type: 2,  
	    area: ['800px', '500px'],
	    title: '增加',
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['提交', '取消'],
	    yes: function(index, layero){
	    	 var body = layer.getChildFrame('body', index);
	         var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	         if(iframeWin.contentWindow.doSubmit()){
	        	 layer.msg('增加成功');
	        	 layer.close(index);
	        	 
	        	 $('#grid-table').trigger('reloadGrid');
	         } else {
	        	 layer.msg('增加失败');
	         }
		  },
		  cancel: function(index){ 
	   
		  }
	}); 
}

function edit(id){
	var url = "info/getEditModal?id="+id;
	layer.open({
	    type: 2,  
	    area: ['800px', '500px'],
	    title: '修改',
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['提交', '取消'],
	    yes: function(index, layero){
	    	 var body = layer.getChildFrame('body', index);
	         var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	         if(iframeWin.contentWindow.doEdit()){
	        	 layer.msg('修改成功');
	        	 layer.close(index);
	        	 
	        	 $('#grid-table').trigger('reloadGrid');
	         } else {
	        	 layer.msg('修改失败');
	         }
		  },
		  cancel: function(index){ 
	   
		  }
	}); 
}
/**
 * 显示地图上所在位置
 * @param id
 * @returns
 */
function showLocation(id){
	var url = "info/getLocation?id="+id;
	layer.open({
	    type: 2,  
	    area: ['800px', '500px'],
	    title: '位置',
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	}); 
}

/**
 * 刷新JqGrid
 * @returns
 */
function refreshGrid(){
	$('#grid-table').trigger('reloadGrid');
}