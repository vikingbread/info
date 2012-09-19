<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<fieldset>
			<legend>详细信息</legend>
			<table>
			
				<tr>
					<td>
						卡号
					</td>
					<td><label>${user.id }</label>
					</td>
				</tr>
				<tr>
					<td>
						用户名
					</td>
					<td><label>${user.name }</label>
					</td>
				</tr>
				<tr>
					<td>
						性别
					</td>
					<td><label>
						<c:if test="${user.sex =='男'}">男</c:if>
						<c:if test="${user.sex == '女'}">女</c:if>
					</label>
					</td>
				</tr>
				<tr>
					<td>
						班级
					</td>
					<td><label>${user.sclass }</label>
					</td>
				</tr>
				<tr>
					<td>
						学号
					</td>
					<td><label>${user.sno}</label>
					</td>
				</tr>
				<tr>
					<td>
						Email
					</td>
					<td>
						<label><c:if test="${user.email==null }">无</c:if>${user.email }</label>
					</td>
				</tr>
				<tr>
					<td>
						账户余额
					</td>
					<td>
						<label>${user.balance }</label>
						</td>
				</tr>
				<tr>
					<td>
						权限
					</td>
					<td><label>
					<c:if test="${user.authority == 'ROLE_USER'}">
									用户
							</c:if>
							<c:if test="${user.authority == 'ROLE_ADMIN'}">
									管理员
							</c:if>
					</label>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="返回" onclick="javascript:history.go(-1);" />
					</td>
				</tr>

			</table>
			</fieldset>
	</body>
</html>
