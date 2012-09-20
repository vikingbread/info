<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link href="css/rightFrame.css" rel="stylesheet" />
		<style type="text/css">
A:link {
	COLOR: #111111;
	TEXT-DECORATION: none
}

A:visited {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: #333333;
	TEXT-DECORATION: underline
}

A:active {
	COLOR: #666666
}
</style>
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/rightFrame.js" type="text/javascript"></script>
		<script src="js/kissy.js"></script>
		<script src="js/util/core.js"></script>
		<script type="text/javascript">
		KISSY.ready(function(S) {
			S.use("updateBalance", function() {
				updateBalance.init();
			});

		});
		</script>
	</head>
	<body>
		<p>
			欢迎使用本信息系统!
		</p>
		<div id="infoPanel">
			现在是:
			<span id='now'>loading...</span>
			<br />
			<p>
				上次登录时间:
				<span>${ sessionScope.user.recentlyLoginTime }</span>
			</p>
			<div class="item">
				上次登录ip:${ sessionScope.user.recentlyLoginIp }
			</div>
			<p>
				你的账户余额为:<span id="balance">${ sessionScope.user.balance }</span>&nbsp;
				<a id="update" href="#"
					url="queryBalance?user.id=${sessionScope.user.id }">刷新</a>
			</p>
		</div>
	</body>
</html>
