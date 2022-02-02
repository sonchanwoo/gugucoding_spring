const replyService = (function(){

	function add(reply, callback, error) {//성공하면 callback()호출, 실패하면 error()호출
	
		$.ajax({//호출만
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {//첫번째매개변수는 success메세지를 제공함
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			},
		})
	}
	
	function getList(param, callback, error) {//외부에서 호출시({bno,page},출력함수)를 줌

	    var bno = param.bno;
	    var page = param.page || 1;//없으면 무적권 1이라는뜻
	    
	    $.getJSON("/replies/pages/" + bno + "/" + page + ".json",
	        function(data) {//ajax는 호출만, getJson은 호출+데이터받아오기
	    	
	          if (callback) {
	            callback(data); //출력함수에 데이터를 전달하고 실행함
	          }
	        }).fail(function(xhr, status, err) {
	      if (error) {
	        error();
	      }
	    });
	  }
	
	function remove(rno, callback, error) {
		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			success : function(deleteResult, status, xhr) {
				if (callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function update(reply, callback, error) {

		console.log("RNO: " + reply.rno);

		$.ajax({
			type : 'put',
			url : '/replies/' + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function get(rno, callback, error) {

		$.get("/replies/" + rno + ".json", function(result) {

			if (callback) {
				callback(result);
			}

		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	function displayTime(timeValue) {

		var today = new Date();

		var gap = today.getTime() - timeValue;

		var dateObj = new Date(timeValue);
		var str = "";

		if (gap < (1000 * 60 * 60 * 24)) {

			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();

			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
					':', (ss > 9 ? '' : '0') + ss ].join('');

		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
			var dd = dateObj.getDate();

			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
					(dd > 9 ? '' : '0') + dd ].join('');
		}
	}
	
	return {
		add : add,
		get : get,
		getList : getList,
		remove : remove,
		update : update,
		displayTime : displayTime
	};

})();