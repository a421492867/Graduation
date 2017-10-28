$(function(){
	//用户评价统计
	var messageChart = echarts.init(document.getElementById('messageCount'));
	messageChart.setOption({

		title : {
			text : '用户评价统计',
	        x:'center',
	        y : 'bottom'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        x : 'center',
	        y : 'top',
	        data:[]
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    series : [
	        
	        {
	            name:'比例',
	            type:'pie',
	            radius : [30, 110],
	            center : ['50%', '50%'],
	            roseType : 'area',
	            data:[]
	            
	        }
	    ]

	});
	messageChart.showLoading();
	var names = [];
	var datas = [];
	$.ajax({
		type:"post",
		async : "true",
		url : "statistics/getUserMessage",
		data : {},
		dataType : "json",
		success : function(result){
			if(result){
				for(var i in result){
					var json = {name: null,value:0};
					names.push(i);
					json.name = i;
					json.value = result[i];
					datas.push(json);
				}
				messageChart.hideLoading();
				messageChart.setOption({
					legend:{
						data : names
					},
					series:[{
						data : datas
					}]
				});
			}
		},
		error : function(){
			layer.msg("图表请求失败");
			messageChart.hideLoading();
		}
	})
	
	
	//维修次数统计
	var repairChart = echarts.init(document.getElementById('repairCount'));
	repairChart.setOption({
			title : {
				text : '维修次数统计',
				x : 'center',
				y : 'bottom'
		    },
			tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross',
		            crossStyle: {
		                color: '#999'
		            }
		        }
		    },
		    toolbox: {
		    	show : true,
		        feature : {
		            mark : {show: true},
		            saveAsImage : {show: true}
		        }

		    },
		    legend: {
		        data:['维修次数']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '次数',
		            min: 0,
		            max: 250,
		            interval: 50,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'次数',
		            type:'bar',
		            data:[]
		        }
		        
		    ]
});
	
	repairChart.showLoading();
	var datasForRepair = [];
	$.ajax({
		type:"post",
		async : "true",
		url : "statistics/getRepairCount",
		data : {},
		dataType : "json",
		success : function(result){debugger
			var keys =['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'];
			
			if(result){
				for(var i in keys){
					datasForRepair.push(result[keys[i]]);
				}
				repairChart.hideLoading();
				repairChart.setOption({
					series:[{
						data : datasForRepair
					}]
				});
			}
		},
		error : function(){
			layer.msg("图表请求失败");
			repairChart.hideLoading();
		}
	})
	
	
	
	
	
	//租用次数统计
	var rentChart = echarts.init(document.getElementById('rentCount'));
	rentChart.setOption({
			title : {
				text : '租用次数统计',
				x : 'center',
				y : 'bottom'
		    },
			tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'cross',
		            crossStyle: {
		                color: '#999'
		            }
		        }
		    },
		    toolbox: {
		    	show : true,
		        feature : {
		            mark : {show: true},
		            saveAsImage : {show: true}
		        }

		    },
		    legend: {
		        data:['租用次数']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		            axisPointer: {
		                type: 'shadow'
		            }
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '次数',
		            min: 0,
		            max: 250,
		            interval: 50,
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'次数',
		            type:'bar',
		            data:[]
		        }
		        
		    ]
});
	rentChart.showLoading();
	var datasForRent = [];
	$.ajax({
		type:"post",
		async : "true",
		url : "statistics/getRentCount",
		data : {},
		dataType : "json",
		success : function(result){debugger
			var keys =['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'];
			
			if(result){
				for(var i in keys){
					datasForRent.push(result[keys[i]]);
				}
				rentChart.hideLoading();
				rentChart.setOption({
					series:[{
						data : datasForRent
					}]
				});
			}
		},
		error : function(){
			layer.msg("图表请求失败");
			rentChart.hideLoading();
		}
	})

})
	