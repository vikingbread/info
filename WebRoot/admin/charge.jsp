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

		<title>充值中心</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="css/error.css">
		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/jquery.validate.js" type="text/javascript"></script>
		<script src="js/kissy.js"></script>
		<script src="js/util/core.js"></script>
		<script>
	KISSY.ready(function(S) {
		S.use("getId", function() {
			getId.init();
		});
	});
	$(document).ready(function() {

		$("#chargeForm").validate({

			rules : {

				"user.id" : {

					required : true,

					minlength : 4,

					maxlength : 15,
					
					number : true

				},

				"user.balance" : {

					required : true,

					number : true

				}

			},

			messages : {

				"user.id" : {

					required : " 必填项",

					minlength : jQuery.format(" 卡号长度不少于 {0} 位 "),

					maxlength : jQuery.format(" 卡号长度不超过 {0} 位 "),
					number:		"请输入数字"

				},
				"user.balance" : {

					required : " 必填项",

					number:		"请输入数字"

				}

			}

		});

	});
	$(document).ready(function() {

		$("#chargeForm").validate({
			event : "keyup" || "blur"
		});
	});
	$(document).ready(function() {

		$("#chargeForm").submit(function() {

			if (!$("#chargeForm").valid()) {
				return false;
			}
			jQuery.ajax({

				url : "abc",

				data : $('#chargeForm').serialize(),

				type : "POST",

				success : function(data)

				{
					if (data.success) {
						alert("充值成功");
						$("#chongzhi").attr("disabled", "disabled");
					} else if (data.errorMsg) {
						alert(data.error.Msg);
					} else
						alert("充值失败");

				}

			});
			return false;

		});
	});
</script>
	</head>

	<body>
		<fieldset>
			<legend>
				账户充值
			</legend>
			<form id="chargeForm" action="" method="post">
				<table>
					<tr>
						<td>
							<label for="idNumber">
								卡&nbsp;&nbsp;号
							</label>
						</td>
						<td>
							<input id="idNumber" name="user.id" />
							<a href="#" id="getId">自动获取</a>
						</td>
					</tr>
					<tr>
						<td>
							金&nbsp;&nbsp;额
						</td>
						<td>
							<input type="text" name="user.balance"  />
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" id="chongzhi" value="确认充值" />
						</td>
						<td>
							<input type="reset" value="重新输入" onclick="javascript:$('#chongzhi').removeAttr('disabled')" />
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</body>
</html>
