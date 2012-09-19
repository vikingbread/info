KISSY.add("user",function(S,Switchable,Calendar){
        var $ = S.all, Dom = S.DOM, Event = S.Event,IO=S.io;

	    _Update = {
	    	able:function(){
	    		Event.on(".able","click",function(){
	    			var thisA = this;
	    			
					var span = Dom.children(this,".info")[0];
					
					var action = Dom.attr(this,"url");
					IO({
		    	        url:action,
		    	        type:"get",
		    	        dataType:"json",
		    	        success:function(data){
		    	            if(!data){return;}
		    	            if(data.success){
		    	            	var param = action.substring(action.indexOf("?",0),action.length);
		    	            	var url;
		    	            	if(action.charAt(0)=='d'){
		    	            		url = "enableUser" + param;
		    	            		span.innerHTML = "起用";
		    	            	}else{
		    	            		url = "disableUser" + param;
		    	            		span.innerHTML = "停用" ;
		    	            	}
		    	            	Dom.attr(thisA,"url",url);
		    	         //   	alert(param);
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
	    	},
			init:function(){
				this.able();
			}
	    };
		return user = _Update;
	}
);