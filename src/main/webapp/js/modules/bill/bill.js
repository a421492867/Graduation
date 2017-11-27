function typeFormat(cellvalue,options,rowObject){
	var result;
	if(cellvalue == "0" ) {
		result = "进账";
	} else {
		result = "出账";
	}
	return result;
}