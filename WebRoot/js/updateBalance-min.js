KISSY.add("updateBalance",function(S,Switchable,Calendar){
        var $ = S.all, Dom = S.DOM, Event = S.Event,IO=S.io;

	    _Update = {
			init:function(){
				
				Event.on("#update","click",function(){
					var span = S.one("#balance")[0];
					var action = Dom.attr(this,"url");
					IO({
		    	        url:action,
		    	        type:"get",
		    	        dataType:"json",
		    	        success:function(data){
		    	            if(!data){return;}
		    	            if(data.success){
		    	            	span.innerHTML=data.user.balance;
		    	            }
		    	            else{
		    	            	if(data.errorMsg){
		    	            		alert(data.errorMsg);
		    	            	}
		    	            	else{
		    	            		alert("操作失败！");
		    	            	}
		    	            }
		    	        },
		    	        error:function(){
		    	        	alert("服务器连接失败，请重试！");
		    	        }
		    	    });
				});

			}
	    };
		return updateBalance = _Update;
	}
);