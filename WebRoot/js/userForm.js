$(document).ready(function() {
//function validateForm(){
	
	$("#signupForm").validate({
		rules : {

			"user.id" : {
				required : true,
				number:true
			},

			"user.name" : {
				required : true,
				minlength : 4,
				maxlength : 10
			},

			"user.passwd" : {

				required : true,

				minlength : 4,

				maxlength : 15

			},

			confirm_password : {

				required : true,

				equalTo : "#password"

			},

			"user.sclass" : "required",
			"user.sno" : "required",
			"user.balance" : {
				number : true
			},

			email : {
				minlength : 1,

				required : true,

				email : true

			}

		},

		messages : {

			"user.id" : {
				required:"必填项",
				number: " 请输入数字"
				
			},

			"user.name" : {
				required : " 必填项",

				minlength : jQuery.format(" 密码长度不少于 {0} 位 "),
				
				maxlength : jQuery.format(" 密码长度不超过 {0} 位 ")
			},

			"user.passwd" : {

				required : " 必填项",

				minlength : jQuery.format(" 密码长度不少于 {0} 位 "),

				maxlength : jQuery.format(" 密码长度不超过 {0} 位 ")

			},

			confirm_password : {

				minlength : jQuery.format(" 密码长度不少于 {0} 位 "),

				required : " 必填项",

				equalTo : " 密码不一致"

			},

			"user.sclass" : " 必填项",

			"user.sno" : " 必填项",

			"user.balance" : " 请输入数字",

			email : {

				required : " 必填项",

				email : " 格式有误"

			}  

		}
		
	});

});
$(document).ready(function() {

	$("#signupForm").validate({
		event : "keyup" || "blur"
	});
});
$(document).ready(function() {
	// 使用 jQuery 异步提交表单

	$('#signupForm').submit(function() {
		if(!$("#signupForm").valid()){
			return false;
		}
		jQuery.ajax({

			url : 'addUser',

			data : $('#signupForm').serialize(),

			type : "POST",

			success : function(data)

			{
				if (data.success) {
					alert("添加成功");
					$("#submit").attr("disabled","disabled");
				} else if (data.errorMsg) {
					alert(data.errorMsg);
				} else {

					alert("添加失败");
				}
			}

		});

		return false;

	});
	$("#reset").click(function(){
		$("#submit").removeAttr("disabled");
	});
});