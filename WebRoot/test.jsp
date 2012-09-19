<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'test.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="js/jquery.validate.js" type="text/javascript"></script>
	<script src="js/test.js" type="text/javascript"></script>
	
	<script src="js/kissy.js"></script>
	<script src="js/util/core.js"></script>
	<script>
	KISSY.ready(function(S) {
		S.use("getId", function() {
			getId.init();
		});
	});
	</script>
	<style type="text/css"> 

		#signupForm label.error { 
		
		padding-left: 16px; 
		
		margin-left: 2px; 
		
		color:red; 
		
		background: url(img/unchecked.gif) no-repeat 0px 0px; 
		
		} 
		
		</style> 
	</head>

	<body>
		<form id="signupForm" method="post" action="addUser">
			<fieldset>
					
				<legend>
					请填写信息
				</legend>
				<table>
					<tr>
						<td><label for="idNumber">卡&nbsp;&nbsp;号</label>
					</td>
						<td><input id="idNumber" name="user.id"/><a href="#" id="getId">自动获取</a></td>
					</tr>
					<tr>
						<td><label for="username">用户名&nbsp;</label>
						</td>
						<td><input id="username" name="user.name"/></td>
					</tr>
					<tr>
    					<td>性别</td>
    					<td>男：<input type="radio" checked="checked" name="user.sex" value="男"/>&nbsp;女<input type="radio" name="user.sex" value="女"/></td>
    				</tr>
					<tr>
						<td><label for="password">密&nbsp;&nbsp;码</label></td>
						<td><input id="password" name="user.passwd" type="password" /></td>
					</tr>
					<tr>
						<td><label for="confirm_password">确认密码</label></td>
						<td><input id="confirm_password" name="confirm_password"type="password" /></td>
					</tr>
					<tr>
		    			<td>班级</td><td><input type="text" name="user.sclass" /></td>
		    		</tr>
		    		<tr>
		    			<td>学号</td><td><input type="text" name="user.sno" /></td>
		    		</tr>
		    		<tr>
		    			<td>开户金额</td><td><input type="text" name="user.balance" id="balance"/><span class="error" id="balanceTip"></span></td>
		    		</tr>
					<tr>
						<td><label for="email">Email</label></td>
						<td><input id="email" name="email" /></td>
					</tr>
					<tr>
		    			<td>权限</td><td><select name="user.authority" >
		    				<option value="ROLE_USER">用户</option>
		    				<option value="ROLE_ADMIN">管理员<option/>
		    			</select></td>
		    		</tr>
					<tr>
						<td><input class="submit" type="submit" value="提交" /></td>
						<td><input class="reset" type="reset" value="重置" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>
