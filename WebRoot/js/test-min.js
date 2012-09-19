KISSY.add("test",function(S,Switchable,Calendar){
        var $ = S.all, Dom = S.DOM, Event = S.Event;

	    _Test = {
			init:function(){
				
				Event.on("#able","click",function(){
					
					alert("hello!");
				});
				
				window.onresize = this.resize;

			}
	    };
		return Test = _Test;
	},{
		requires : [
					'switchable',
					'calendar'
				]
			}
);