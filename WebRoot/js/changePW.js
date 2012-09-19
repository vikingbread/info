$(document).ready(function() {

	$("#updateForm").validate({

		rules : {

			"user.passwd" : {

				required : true,

				minlength : 4,

				maxlength : 15

			},
			
			"newPasswd" : {
				
				required : true,
				
				minlength : 4,
				
				maxlength : 15
				
			},

			confirmPasswd : {

				required : true,

				equalTo : "#password"

			}

		},

		messages : { 

			"user.passwd" : {

				required : " 必填项",

				minlength : jQuery.format(" 密码长度不少于 {0} 位 "),

				maxlength : jQuery.format(" 密码长度不超过 {0} 位 ")

			},
			"newPasswd" : {
				
				required : " 必填项",
				
				minlength : jQuery.format(" 密码长度不少于 {0} 位 "),
				
				maxlength : jQuery.format(" 密码长度不超过 {0} 位 ")
				
			},

			"confirmPasswd" : {

				minlength : jQuery.format(" 密码长度不少于 {0} 位 "),

				required : " 必填项",

				equalTo : " 密码不一致"

			}

		}

	});

});
$(document).ready(function() {

	$("#updateForm").validate({
		event : "keyup" || "blur"
	});
});
$(document).ready(function() {
	

		$('#updateForm').submit(function() {
			
			if(!$("#updateForm").valid()){
				return false;
			}
			jQuery.ajax({

				url : 'changePW',

				data : $('#updateForm').serialize(),

				type : "POST",

				success : function(data)

				{
					if(data.success){
						alert("更新成功");
						$("#update").attr("disabled","disabled");
					}else{
						alert("更新失败");
					}
				}

			});

			return false;

		});
	});