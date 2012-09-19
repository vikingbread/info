<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新密码页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/error.css">
	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="js/jquery.validate.js" type="text/javascript"></script>
	<script src="js/changePW.js" type="text/javascript"></script>
  </head>
  
  <body>
		<fieldset>
			<legend>
				修改密码
			</legend>
			<form id="updateForm">
				<input type="hidden" value="${user.name}" name="user.name">
				<table>
					<tr>
						<td>
							旧密码
						</td>
						<td><input type="password"" name="user.passwd"></td>
					</tr>
					<tr>
						<td>
							新密码
						</td>
						<td><input type="password" id="password" name="newPasswd"></td>
					</tr>
					<tr>
						<td>
							确认密码
						</td>
						<td><input type="password" name="confirmPasswd" id="confirmPasswd"></td>
					</tr>
					<tr>
						<td><input id="update" type="submit" value="修改"></td>
						<td><input type="reset" value="重填" onclick="javascript:$('#update').removeAttr('disabled')"></td>
					</tr>
				</table>
		</form>
		</fieldset>
  </body>
</html>
