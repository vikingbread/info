<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/jquery.accordion.js"></script>
<script type="text/javascript">
	jQuery().ready(function(){
		jQuery('#navigation').accordion({
			header: '.head',
			navigation1: true, 
			event: 'click',
			fillSpace: true,
			animated: 'bounceslide'
		});
	});
</script>
<style type="text/css">
<!--
body {
	margin:0px;
	padding:0px;
	font-size: 12px;
}
#navigation {
	margin:0px;
	padding:0px;
	width:147px;
}
#navigation a.head {
	cursor:pointer;
	background:url(images/main_34.gif) no-repeat scroll;
	display:block;
	font-weight:bold;
	margin:0px;
	padding:5px 0 5px;
	text-align:center;
	font-size:12px;
	text-decoration:none;
}
#navigation ul {
	border-width:0px;
	margin:0px;
	padding:0px;
	text-indent:0px;
}
#navigation li {
	list-style:none; display:inline;
}
#navigation li li a {
	display:block;
	font-size:12px;
	text-decoration: none;
	text-align:center;
	padding:3px;
}
#navigation li li a:hover {
	background:url(images/tab_bg.gif) repeat-x;
		border:solid 1px #adb9c2;
}
-->
</style>
</head>
<body>
<div  style="height:100%;">
  <ul id="navigation">
    <li> <a class="head">基本信息</a>
      <ul>
        <li><a href="queryAllRecordsByPage?user.id=${sessionScope.user.id }" target="rightFrame">账户记录</a></li>
      </ul>
    </li>   
    <li> <a class="head">数据统计</a>
      <ul>
        <li><a href="right.jsp" target="rightFrame">历史记录</a></li>
        <li><a href="queryAllLoginRecords?loginRecord.user.id=${user.id }&page.pageNow=1" target="rightFrame">登陆记录</a></li>
         <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="queryAllLoginRecords?loginRecord.user.id=-1" target="rightFrame">所有用户登陆记录</a></li>
        </sec:authorize>
      </ul>
    </li>   
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <li> <a class="head">管理</a>
      <ul>
        <li><a href="queryAllUsersByPage" target="rightFrame">用户列表</a></li>
        <li><a href="admin/addUser.jsp" target="rightFrame">添加用户</a></li>
        <li><a href="admin/charge.jsp" target="rightFrame">充值</a></li>
      </ul>
    </li>   
    </sec:authorize>
  </ul>
</div>
</body>
</html>
