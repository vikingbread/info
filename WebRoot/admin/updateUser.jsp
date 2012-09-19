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
		<script src="js/ui/jquery-1.6.2.js" type="text/javascript"></script>
		<script type="text/javascript">
	$(document).ready(function() {

		// 使用 jQuery 异步提交表单

		$('#updateForm').submit(function() {

			jQuery.ajax({

				url : 'updateUser',

				data : $('#updateForm').serialize(),

				type : "POST",

				beforeSend : function()

				{

				//	$('#submitButton').hide();

				//	$('#editRealMsgImg').show();

				},

				success : function(data)

				{
					if(data.success){
						alert("操作成功");
						$("#update").attr("disabled","disabled")
					}else{
						alert("操作失败");
					}
				}

			});

			return false;

		});
	});
</script>
	</head>

	<body>
		<form action="updateUser" method="post" id="updateForm">
			<table>
				<tr>
					<td>
						卡号
					</td>
					<td>
						<input type="text" " name="user.id" readonly="readonly"
							value="${user.id }" />
					</td>
				</tr>
				<tr>
					<td>
						用户名
					</td>
					<td>
						<input type="text" name="user.name" readonly="readonly"
							value="${user.name }" />
						<span id="nameIfo"></span>
					</td>
				</tr>
				<tr>
					<td>
						性别
					</td>
					<td>
						男：
						<input type="radio" disabled="disabled"
							<c:if test="${user.sex ==' 男'}">checked="checked"</c:if>
							name="user.sex" value="男" />
						&nbsp;女
						<input type="radio" disabled="disabled"
							<c:if test="${user.sex == '女'}">checked="checked"</c:if>
							name="user.sex" value="女" />
					</td>
				</tr>
				<tr>
					<td>
						班级
					</td>
					<td>
						<input type="text" name="user.sclass" value="${user.sclass }" />
					</td>
				</tr>
				<tr>
					<td>
						学号
					</td>
					<td>
						<input type="text" name="user.sno" value="${user.sno }" />
					</td>
				</tr>
				<tr>
					<td>
						Email
					</td>
					<td>
						<input type="text" name="user.email" value="${user.email }" />
					</td>
				</tr>
				<tr>
					<td>
						权限
					</td>
					<td>
						<select name="user.authority">
							<c:if test="${user.authority == 'ROLE_USER'}">
								<option value="ROLE_USER">
									用户
								</option>
								<option value="ROLE_ADMIN">
									管理员
								<option />
							</c:if>
							<c:if test="${user.authority == 'ROLE_ADMIN'}">
								<option value="ROLE_ADMIN">
									管理员
								<option />
								<option value="ROLE_USER">
									用户
								</option>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input id="update" type="submit" value="更新" />
					</td>
					<td>
						<input id="reset" type="reset" onclick="javascript:$('#update').removeAttr('disabled')" value="重填" />
					</td>
				</tr>

			</table>
		</form>
	</body>
</html>
