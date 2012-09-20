KISSY.add("getId", function(S, Switchable, Calendar) {
	var Dom = S.DOM, Event = S.Event, IO = S.io;

	_getId = {
		init : function() {
			Event.on("#getId", "click", function() {
				var input = S.one("#idNumber")[0];
				IO({
					url : "getId",
					type : "get",
					dataType : "json",
					success : function(data) {
						if (!data) {
							return false;
						}
						if (data.idNumber) {
							input.value = data.idNumber;
						} else {
							alert("没有读到Id号，请确认到读卡器的连接是否正常！");
							// }
						}
					},
					error : function() {
						alert("服务器连接失败，请重试！");
					}
				});
				return false;
			});

		}
	};
	return getId = _getId;
});