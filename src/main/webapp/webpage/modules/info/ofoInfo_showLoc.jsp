<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
 <script type="text/javascript" src="${ctxStatic}/jquery/jquery-3.1.1.min.js"></script>
 <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=b13d7bac875a4735b1b41ab984ec42c0&plugin=AMap.Geocoder"></script>
 <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<title>Insert title here</title>
</head>
<body onload="regeocoder()">
<div id="container"></div>
<input id="lng" value="${info.lng }" style="display:none">
<input id="lat" value="${info.lat}" style="display:none">
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true,
		zoom: 18
    });   debugger;
    var lng = $("#lng").val();
    var lat = $("#lat").val();
    lnglatXY = [lng, lat]; //已知点坐标
    function regeocoder() {  //逆地理编码
        var geocoder = new AMap.Geocoder({
            radius: 1000,
            extensions: "all"
        });              
        var marker = new AMap.Marker({  //加点
            map: map,
            position: lnglatXY
        });
        map.setFitView();
    }
   
</script>
</body>
</html>