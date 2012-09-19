<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>欢迎登陆</title>
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<script>
	var cnt = 2;
	function load() {
	//	if (cnt <= 1) {
			//window.location.href = "http://www.baidu.com";
			document.getElementById("form").submit();
	//	} else {
	//		cnt--;
	//	}
	}
//	setTimeout("lod()", 500);
</script>
	<body onload="load()">
		<div id="showTime">
			登陆成功，正在跳转！
		</div>
		<form action="/info/j_spring_security_check" id="form" method="post">
			<input type="hidden" name="j_username" value="${user.name }" />
			<input type="hidden" name="j_password" value="${user.passwd}" />
		</form>
	</body>
</html>
