//jqGrid初始化函数
function initJqgridForTag(gridId,pagerId,colNamesStr,colModelStr,multiselectStr,url,editUrl,loadui,extendFun) {
	if (gridId == "") {
		gridId = "grid-table";
	}
	var grid_selector = "#" + gridId;
	if (pagerId == "") {
		pagerId = "grid-pager";
	}
    var pager_selector = "#" + pagerId;
    var colNames = colNamesStr.split(",");
    colNames.push(" ");
    var colModel = colModelStr/*.replace(/;/g, ",")*/;
    colModel = eval("[" + colModel + ",{name:\"aa\", editable:false, width:1,resizable:false, sortable:false}" + "]");
    var multiselect = false;
    if (multiselectStr != null && multiselectStr != "" ) {
    	if (multiselectStr == "true") {
    		multiselect = true;
    	} else if (multiselectStr == "false") {
    		multiselect = false;
    	}
    }
    jQuery(grid_selector).jqGrid({
    	url:url,
        datatype:"json",
        editurl:editUrl,
        // 设置为auto，使pager贴合table，否则pager在页面最下方
        height: "auto",
        // 不使用比例宽度
        shrinkToFit: false,
        // 使jqGrid宽度等于页面总宽度
        autowidth: true,
		loadui: loadui,
		rownumbers: false,
		multiselect: multiselect,
        multiboxonly: false,
        colNames: colNames,
        colModel: colModel,
        viewrecords : false,
        //altRows: true,
        rowList: [10, 30, 50],
        pager: pager_selector,
        rowNum: 10,
        jsonReader: {
            repeatitems: false,
            page: "page",  
        	total: "total",  
        	records: "records"
        },
        beforeRequest : function() {
        	var table = this;
        	jqgridFixFun(table);
        },
        loadComplete : function() {
        	var table = this;
        	jqgridFixFun(table);
            if (extendFun != "" && extendFun != null) {
           	    var  func = eval(extendFun);
                new func();
           }
        }
    });
}

//添加行标签的保存函数
function tagRowSave(table, rowid, url, successFun, failFun) {
	/**
	 * rowid：要保存的数据行id
	 * successfunc：配置过，那么将在成功请求后触发（200状态，动态页没有发生错误）。事件参数为XHR对象，需要返回true/false（返回true会使用修改后的数据填充当前行，否则使用修改前的数据填充，同时关闭编辑模式。可以通过XHR.responseText得到服务器的返回值判断是否修改成功，在返回true/false，不会ajax可以参考这个：ajax对象）
	 * url：定义此项，将会替代jqGrid配置中的editurl，如果设置为 'clientArray'，仅保存数据到grid中，不会向服务器提交数据（如果不想更改一行就提交一次，配置为这个值比较有用，可以点击页面上某个按钮将所有数据用ajax一次提交）
	 * extraparam：提交到服务器的其他附加数据
	 * aftersavefunc：数据保存到服务器返回客户端后触发。此事件参数为rowid和xhr对象，url设置为clientArray也会触发此事件
	 * errorfunc：动态页出错时触发，。此事件参数为rowid和xhr对象
	 * afterrestorefunc：调用restoreRow还原数据行原始信息（数据行保存不成功）时触发，参数有rowid
	 */
	//jQuery("#grid_id").jqGrid('saveRow',rowid, successfunc, url, extraparam, aftersavefunc,errorfunc, afterrestorefunc);
	$('#' + table).jqGrid('saveRow',rowid, function(rowid, xhr){
			    if(xhr == "true") {
			    	layer.msg('添加成功');
			     	if (successFun != "" && successFun != null) {
			         	var func = eval(successFun);
			            new func();
			        }
					hiddenFunIcon(table);
			      	var $newoper = $('tr[id="' + rowid + '"]').children('td[aria-describedby="grid-table_aa"]');
			        $newoper.empty().append("");
			        return true;
			    } else {
			    	return false;
			    }
			}, url, null, null,function (rowid, xhr) {
				layer.msg('添加失败');
				// 设置grid单元格可编辑
	        	if (failFun != "" && failFun != null) {
	                var func = eval(failFun);
	                new func();
	            }
		    },function (rowid) {
				$('#' + table).jqGrid('editRow', rowid, false);
		    }
	);
}

//添加行标签的取消函数
function tagRowCancel(table, rowid) {
	hiddenFunIcon(table);
    $('#' + table).jqGrid('delRowData', rowid);
}

//添加行标签的保存、取消按钮隐藏函数
function hiddenFunIcon(table) {
	$("#gview_"+table).find("thead tr:first th:visible:last").css("width", '1px');
	var th = $("#gview_"+table).find("thead tr:first th:visible");
    $(th[th.length-2]).css("border-right", "0px none");
    var thOfTable = $("#" + table).find("thead tr:first th:visible");
    $(thOfTable[thOfTable.length-2]).addClass('transparent');
    $(thOfTable[thOfTable.length-2]).css("border-right-color", "transparent");
    $("#" + table).find("tbody tr:first td:visible:last").css("width", '1px');
    $("#" + table).find("tbody tr:first td:visible:last").css("border-left", "0px none");
    $("#" + table).find("tbody tr").each(function() {
		var td = $(this).find("td:visible");
	    $(td[td.length-2]).css("border-right", "0px none");
	})
}

//设置jqgrid最后的aa及aa前一个表格宽度和边框
function jqgridFixFun(table) {
    setTimeout(function(){                            
        updatePagerIcons(table);
        // 去掉横向滚动条
        forceLastColumnWidthMinusOne(table);
        // 使jqGrid的table可以自适应宽度
        jqGridWidthFix(table);
        $("#gview_"+$(table).attr('id')).find("thead tr:first th:visible:last").css("width", '1px');
        var th = $("#gview_"+$(table).attr('id')).find("thead tr:first th:visible");
        $(th[th.length-2]).css("border-right", "0px none");
        var thOfTable = $(table).find("thead tr:first th:visible");
        $(thOfTable[thOfTable.length-2]).addClass('transparent');
        $(thOfTable[thOfTable.length-2]).css("border-right-color", "transparent");
        $(table).find("tbody tr:first td:visible:last").css("width", '1px');
        $(table).find("tbody tr:first td:visible:last").css("border-left", "0px none");
        $(table).find("tbody tr").each(function() {
			var td = $(this).find("td:visible");
		    $(td[td.length-2]).css("border-right", "0px none");
		})
    }, 0);
}

//设置jqgrid宽度，实现自适应
function jqGridWidthFix(table){
    var id_base = $(table).attr('id');
    $('#' + id_base).css('width', '100%');
    $('#gbox_' + id_base).css('width', '100%');
    $('#gview_' + id_base).css('width', '100%');
    $('.ui-jqgrid-hdiv').css('width', '100%');
    $('.ui-jqgrid-hbox').css('padding-right', '0');
    $('.ui-jqgrid-hbox').css('width', '100%');
    $('.ui-jqgrid-htable').css('width', '100%');
    $('.ui-jqgrid-bdiv').css('width', '100%');
    $('.ui-jqgrid-pager').css('width', '100%');
    $('[id^=jqgh_grid-table_]').css({'padding-top': '12px'});
    $('.ui-jqgrid-labels').css('height', '42px');
}

//用FontAwesome图标替换分页按钮
function updatePagerIcons(table) {
    var replacement = {
        'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
        'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
        'ui-icon-seek-next' : 'icon-angle-right bigger-140',
        'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
        
        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    });
}

// 将最后一个列的宽度-1像素
function forceLastColumnWidthMinusOne(table) {
    var originalWidth = $(table).find("tbody tr:first td:visible:last").css("width");
    originalWidth = originalWidth.replace("px","");
    originalWidth = Number(originalWidth);
    var targetWidth = (originalWidth-1)+"px";
    //alert("originalWidth="+originalWidth+"px -> "+targetWidth);
    // 表体最后一个宽度-1
    $(table).find("tbody tr:first td:visible:last").css("width", targetWidth);
    // 表头最后一个宽度-1
    $(table).closest("#gview_"+$(table).attr('id')).find("thead tr:first th:visible:last").css("width", targetWidth);
}

//grid 添加新的一行
function addRowOfJqgrid(gridId,saveUrl,successFun,failFun) {
	var newrowid;
	if (gridId == "") {
		gridId = "grid-table";
	}
	var grid_selector = "#" + gridId;
	//判断新增列是否保存
	var havaAddFlag = false;
	$(grid_selector).find('tbody tr td[aria-describedby="grid-table_aa"]').each(function() {
		if ($(this).html() != "&nbsp;" && $(this).html() != "" && $(this).html().trim() != "") {
			layer.msg('请先保存新增数据');
			havaAddFlag = true;
		}
	});
	
	if (havaAddFlag) {
		return;
	}
	
	var ids = jQuery(grid_selector).jqGrid('getDataIDs');
	if (ids == null || ids == "") {
		ids = [0];
	}
    var rowid = jQuery(grid_selector).jqGrid('getGridParam','selrow');
    var rowData = jQuery(grid_selector).jqGrid('getRowData',rowid);
    //获得当前最大行号（数据编号）  
    var maxid = Math.max.apply(Math,ids); 
    newrowid = maxid+1 ;
    var colModel = jQuery(grid_selector).jqGrid("getGridParam", "colModel");
    var dataRow = {};
    for (var colModelLength = 0; colModelLength < colModel.length; colModelLength++) {
    	dataRow[colModel[colModelLength].name] = "";
    }

	// 设置grid单元格不可编辑
	$(grid_selector).setGridParam({
		cellEdit : false
	});
	// 将新添加的行插入到选中行下方
	jQuery(grid_selector).jqGrid("addRowData", newrowid, dataRow, "first");
	// 设置grid单元格可编辑
	$(grid_selector).jqGrid('editRow', newrowid, false);

    var str = "<div style=\"margin-left: 8px;\">";
	str += "<div title=\"\" style=\"float: left;\"";
	str += "class=\"ui-pg-div ui-inline-save\" id=\"jSaveButton_" + newrowid
			+ "\"";
	str += "onclick=\"tagRowSave('" + gridId + "'," + newrowid + ", '" + saveUrl + "', '" + successFun + "', '" + failFun + "');\"";
	str += "onmouseover=\"jQuery(this).addClass('ui-state-hover');\"";
	str += "onmouseout=\"jQuery(this).removeClass('ui-state-hover');\"";
	str += "data-original-title=\"Submit\">";
	str += "<span class=\"fa fa-save\"></span>";
	str += "</div>";
	str += "<div title=\"\" style=\"float: left;margin-left: 1px;\" ";
	str += " class=\"ui-pg-div ui-inline-cancel\" id=\"jCloseButton_" + newrowid
			+ "\"";
	str += " onclick=\"tagRowCancel('" + gridId + "'," + newrowid + ");\"";
	str += " onmouseover=\"jQuery(this).addClass('ui-state-hover');\"";
	str += " onmouseout=\"jQuery(this).removeClass('ui-state-hover');\"";
	str += " data-original-title=\"Cancel\">";
	str += "<span class=\"fa fa-close\"></span>";
	str += "</div>";
	str += "</div>";

	// 给添加的列加选择按钮
	var $newoper = $('tr[id="' + newrowid + '"]').children(
			'td[aria-describedby="grid-table_aa"]');
	$newoper.empty().append(str);
	//显示按钮栏
	$("#gview_"+gridId).find("thead tr:first th:visible:last").css("width", '100px');
	var th = $("#gview_"+gridId).find("thead tr:first th:visible");
    $(th[th.length-2]).css("border-right", '1px solid rgb(225, 225, 225)');
    $(grid_selector).find("tbody tr:first td:visible:last").css("width", '100px');
    var td = $(grid_selector).find("tbody tr td:visible");
    $(td[td.length-2]).css("border-right", "1px solid rgb(225, 225, 225)");
};

//添加列弹出框
function addColOfJqgrid(gridId, url,preFun,successFun,failFun) {
	if (gridId == "") {
		gridId = "grid-table";
	}
	var grid_selector = "#" + gridId;
	//判断新增列是否保存
	var havaAddFlag = false;
	$(grid_selector).find('tbody tr td[aria-describedby="grid-table_aa"]').each(function() {
		if ($(this).html() != "&nbsp;" && $(this).html() != "" && $(this).html().trim() != "") {
			layer.msg('请先保存新增数据');
			havaAddFlag = true;
		}
	});
	
	if (havaAddFlag) {
		return;
	}
	
	var colHtml = "</br>" +
    "<div class=\"wrapper addColDiv\">" +
        "<div class=\"form-group\">" +
		    "<div class=\"input-group col-md-8 col-md-offset-2\">" +
			  "<span class=\"input-group-addon\">名称</span>" +
			  "<input id=\"jqgridColDisName\" type=\"text\" class=\"form-control\" name=\"eventName\" placeholder=\"名称\">" +
			"</div>" +
		"</div>" +
		"<div class=\"form-group\">" +
			"<div class=\"input-group col-md-8 col-md-offset-2\">" +
			  "<span class=\"input-group-addon\">属性名</span>" +
			  "<input id=\"jqgridColName\" type=\"text\" class=\"form-control\" name=\"eventKey\" placeholder=\"属性名\">" +
			"</div>" +
		"</div>" +
		"<div class=\"form-group\">" +
			"<div class=\"input-group col-md-8 col-md-offset-2\">" +
				"<span class=\"input-group-addon\">能否编辑</span>" +
				"<select id=\"jqgridColEdit\" name=\"editable\" class=\"form-control\">" +
					"<option value=\"01\">可编辑</option>" +
					"<option value=\"02\">不可编辑</option>" +
				"</select>" +
			"</div>" +
		"</div>" +
		"<div class=\"form-group\">" +
			"<div class=\"input-group col-md-8 col-md-offset-2\">" +
			"<span class=\"input-group-addon\">是否显示</span>" +
				"<select id=\"jqgridColDisplay\" name=\"hidden\" class=\"form-control\">" +
					"<option value=\"02\">显示</option>" +
					"<option value=\"01\">隐藏</option>" +
				"</select>" +
			"</div>" +
		"</div>" +
	"</div>";

	if (preFun != "" && preFun != null) {
   	    var func = eval(preFun);
   	    var isRun = new func();
   	    if (!isRun.returnValue) {
   	    	return false;
   	    }
    }
	
	//页面层
	var index = layer.open({
	  type: 1,
	  title: "新增列",
	  skin: 'layui-layer-rim', //加上边框
	  area: ['600px', '350px'], //宽高
	  content: colHtml,
	  btn: ["确定", "取消"],
	  yes: function(index, layero){
		    saveColDataOfJqGrid(gridId,url,successFun,failFun);
		    layer.close(index);
		  },
      cancel: function(){ 
		    //右上角关闭回调
		  }
	});
	
}

//添加列后台提交保存函数
function saveColDataOfJqGrid (gridId,url,successFun,failFun) {
	var disName = $("#jqgridColDisName").val();
	var name = $("#jqgridColName").val();
	var editable; 
	if ($("#jqgridColEdit").val() == "01") {
		editable = true;
	} else if ($("#jqgridColEdit").val() == "02") {
		editable = false;
	}
	var hidden;
	if ($("#jqgridColDisplay").val() == "01") {
		hidden = true;
	} else if ($("#jqgridColDisplay").val() == "02") {
		hidden = false;
	}
	if (disName != null && name != null && editable != null  && hidden != null ) {
		if (url != "") {
			$.ajax({
	            type: 'POST',
	            url: url,
	            async: false,
	            cache: false,
	            data: {"disName":disName, "name":name, "editable":editable, "hidden":hidden},
	            dataType: 'JSON',
	            success: function(resp) {
	            	if(resp){
	            		 saveColOfJqgrid(disName, name, editable, hidden);
		   	        	 layer.msg('添加成功');
		   	        	 layer.close(index);
		   	        	 if (successFun != "" && successFun != null) {
		   	            	 var func = eval(successFun);
		   	                 new func();
		   	             }
		   	         } else {
		   	        	 layer.msg('添加失败');
		   	        	 if (failFun != "" && failFun != null) {
		   	            	 var func = eval(failFun);
		   	                 new func();
		   	             }
		   	         }
	            }
	        });
		} else {
			layer.msg('添加成功');
			saveColOfJqgrid(gridId,disName, name, editable, hidden);
		}
	}
	
}

//添加列jqgrid显示变更，显示新增的列
function saveColOfJqgrid(gridId,disName, name, editable, hidden) {
	if (gridId == "") {
		gridId = "grid-table";
	}
	var grid_selector = "#" + gridId;
	var pager_selector = jQuery(grid_selector).jqGrid("getGridParam", "pager");
	var colNames = jQuery(grid_selector).jqGrid("getGridParam", "colNames");
	var colModel = jQuery(grid_selector).jqGrid("getGridParam", "colModel");
	var url = jQuery(grid_selector).jqGrid("getGridParam", "url");
	var editurl = jQuery(grid_selector).jqGrid("getGridParam", "editurl");
	var loadui = jQuery(grid_selector).jqGrid("getGridParam", "loadui");
	var multiselect = jQuery(grid_selector).jqGrid('getGridParam','multiselect');
	var beforeRequest = jQuery(grid_selector).jqGrid("getGridParam", "beforeRequest");
	var loadComplete = jQuery(grid_selector).jqGrid("getGridParam", "loadComplete");
	colNames.shift();
	var aaName = colNames.pop();
	colNames.push(disName);
	colNames.push(aaName);
	
	if (disName != null && name != null && editable != null  && hidden != null ) {
		var colMap = {};
		colMap["name"] = disName;
		colMap["editable"] = editable;
		colMap["hidden"] = hidden;
		colModel.shift();
		var aa= colModel.pop();
		colModel.push(colMap);
		colModel.push(aa);
	}
	jQuery(grid_selector).GridUnload();
	jQuery(grid_selector).jqGrid({  
	    url: url,
        datatype:"json",
        editurl: editurl,
        // 设置为auto，使pager贴合table，否则pager在页面最下方
        height: "auto",
        // 不使用比例宽度
        shrinkToFit: false,
        // 使jqGrid宽度等于页面总宽度
        autowidth: true,
		loadui: loadui,
		rownumbers: true,
		multiselect: multiselect,
        multiboxonly: false,
        colNames: colNames,  
	    colModel: colModel,
        viewrecords : false,
        altRows: true,
        rowList: [10, 30, 50],
        pager: pager_selector,
        rowNum: 10,
        jsonReader: {
            repeatitems: false,
            page: "page",  
        	total: "total",  
        	records: "records"
        },
        beforeRequest : beforeRequest,
        loadComplete : loadComplete 
	});
}

//grid 删除一行
function deleteRowOfJqgrid(gridId,dataFun,preFun,saveUrl,successFun,failFun) {
	if (preFun != "" && preFun != null) {
   	    var func = eval(preFun);
   	    var isRun = new func();
   	    if (!isRun.returnValue) {
   	    	return false;
   	    }
    }
	
	if (dataFun != "" && dataFun != null) {
   	    var func = eval(dataFun);
   	    var data = new func();
	   	if (data != null && data != "") {
	   		saveUrl += "?";
	 		for (var key in data) {
	 			saveUrl += key + "=" + data[key] + "&"
	 		}
	 		saveUrl = saveUrl.substring(0, saveUrl.length-1);
	 	}
    }
	if (gridId == "") {
		gridId = "grid-table";
	}
	var grid_selector = "#" + gridId;
	var multiselect = $(grid_selector).jqGrid('getGridParam','multiselect');
	var delRowIds;
	if (multiselect) {
		delRowIds = $(grid_selector).jqGrid('getGridParam','selarrrow');
	} else {
		delRowIds = $(grid_selector).jqGrid('getGridParam','selrow');
	}
	if (delRowIds == null || delRowIds.length == 0) {
		layer.msg('请先选择要删除的行');
	} else {
		if (saveUrl != null && saveUrl != "") {
			$.ajax({
	            type: 'POST',
	            url: saveUrl,
	            async: false,
	            cache: false,
	            data: {"delRowIds":delRowIds},
	            dataType: 'JSON',
	            success: function(resp) {
	            	//后台必须返回true才能显示删除成功
	            	if(resp){
		   	            layer.msg('删除成功');
		   	        	var len = delRowIds.length;  
		   				for(var i = 0;i < len ;i ++) {  
		   					$(grid_selector).jqGrid("delRowData", delRowIds[0]);  
		   				}
		   	        	if (successFun != "" && successFun != null) {
		   	            	var func = eval(successFun);
		   	                new func();
		   	            }
		   	         } else {
		   	        	 layer.msg('删除失败');
		   	        	 if (failFun != "" && failFun != null) {
		   	            	 var func = eval(failFun);
		   	                 new func();
		   	             }
		   	         }
	            }
	        });
		} else {
			var len = delRowIds.length;  
			for(var i = 0;i < len ;i ++) {  
				$(grid_selector).jqGrid("delRowData", delRowIds[0]);  
			}  
		}
	}
};

//调用列视图跳出层
function viewColOfJqgrid(gridId,url,preFun,successFun,failFun) {
	if (gridId == "") {
		gridId = "grid-table";
	}
	var grid_selector = "#" + gridId;
	//判断新增列是否保存
	var havaAddFlag = false;
	$(grid_selector).find('tbody tr td[aria-describedby="grid-table_aa"]').each(function() {
		if ($(this).html() != "&nbsp;" && $(this).html() != "" && $(this).html().trim() != "") {
			layer.msg('请先保存新增数据');
			havaAddFlag = true;
		}
	});
	
	if (havaAddFlag) {
		return;
	}
	
	if (preFun != "" && preFun != null) {
   	    var func = eval(preFun);
   	    var isRun = new func();
   	    if (!isRun.returnValue) {
   	    	return false;
   	    }
    }
	
	var colNames = jQuery(grid_selector).jqGrid("getGridParam", "colNames");
	var colModel = jQuery(grid_selector).jqGrid("getGridParam", "colModel");
	var idName = colNames.shift();
	var aaName = colNames.pop();
	
	var idModel = colModel.shift();
	var aa= colModel.pop();
	var colHtml = "<div id=\"viewEditFor"+gridId+"\" class=\"colViewEditDiv\"></br>";
	for (var i = 0; i < colNames.length; i++) {
		colHtml += "<div class=\"checkbox checkbox-info\">" +
					    "<input id=\"checkbox"+ i +"\" class=\"styled\" type=\"checkbox\"";
						if (colModel[i]['hidden'] == false || colModel[i]['hidden'] == null) {
							colHtml += " checked"
						}		    
						colHtml +=">" +
					    "<label for=\"checkbox"+ i +"\" value=\"" + i + "\">" +
					        colNames[i] +
					    "</label>" +
					"</div>";
	}
	colHtml += "</div>";
	//页面层
	var index = layer.open({
	  type: 1,
	  title: "列试图编辑",
	  skin: 'layui-layer-rim', //加上边框
	  area: ['600px', '350px'], //宽高
	  content: colHtml,
	  btn: ["确定", "取消"],
	  yes: function(index, layero){
		    $("#viewEditFor"+gridId).find('input:checkbox').each(function() {
				if($(this).prop("checked")) {
					colModel[parseInt($(this).next('label').attr("value"))]['hidden'] = false;
				} else {
					colModel[parseInt($(this).next('label').attr("value"))]['hidden'] = true;
				}
			});
		    colNames.push(aaName);
		    colModel.push(aa);
		    saveColViewOfJqgrid(grid_selector,colNames, colModel)
		    layer.close(index);
		  },
	  btn2:   function(){ 
		    //取消按钮回调
		    colNames.unshift(idName);
		    colNames.push(aaName);
		    colModel.unshift(idModel);
		    colModel.push(aa);
		    jQuery(grid_selector).jqGrid("setGridParam", "colNames");
			jQuery(grid_selector).jqGrid("setGridParam", "colModel");
	  },
      cancel: function(){ 
		    //右上角关闭回调
    	    colNames.unshift(idName);
    	    colNames.push(aaName);
    	    colModel.unshift(idModel);
    	    colModel.push(aa);
    	    jQuery(grid_selector).jqGrid("setGridParam", "colNames");
    		jQuery(grid_selector).jqGrid("setGridParam", "colModel");
		  }
	});
	
}

//保存列视图数据到jqgrid
function saveColViewOfJqgrid(grid_selector,colNames, colModel) {
	var url = jQuery(grid_selector).jqGrid("getGridParam", "url");
	var editurl = jQuery(grid_selector).jqGrid("getGridParam", "editurl");
	var loadui = jQuery(grid_selector).jqGrid("getGridParam", "loadui");
	var multiselect = jQuery(grid_selector).jqGrid('getGridParam','multiselect');
	var beforeRequest = jQuery(grid_selector).jqGrid("getGridParam", "beforeRequest");
	var loadComplete = jQuery(grid_selector).jqGrid("getGridParam", "loadComplete");
	var pager_selector = jQuery(grid_selector).jqGrid("getGridParam", "pager");
	jQuery(grid_selector).GridUnload();
	jQuery(grid_selector).jqGrid({  
	    url: url,
        datatype:"json",
        editurl: editurl,
        // 设置为auto，使pager贴合table，否则pager在页面最下方
        height: "auto",
        // 不使用比例宽度
        shrinkToFit: false,
        // 使jqGrid宽度等于页面总宽度
        autowidth: true,
		loadui: loadui,
		rownumbers: true,
		multiselect: multiselect,
        multiboxonly: false,
        colNames: colNames,  
	    colModel: colModel,
        viewrecords : false,
        altRows: true,
        rowList: [10, 30, 50],
        pager: pager_selector,
        rowNum: 10,
        jsonReader: {
            repeatitems: false,
            page: "page",  
        	total: "total",  
        	records: "records"
        },
        beforeRequest : beforeRequest,
        loadComplete : loadComplete 
	});
}