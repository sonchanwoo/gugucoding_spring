<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp" %>

	<div>
		<label>bno</label><br/>
		<input type="text" readonly	value="${vo.bno }" />
	</div>

	<div>
		<label>title</label><br/>
		<input type="text" readonly	value="${vo.title }" />
	</div>
	
	<div>
		<label>writer</label><br/>
		<input type="text" readonly	value="${vo.writer }" />
	</div>
	
	<div>
		<label>content</label><br/>
		<textarea readOnly rows="3" cols=""><c:out value="${vo.content }"></c:out></textarea>
	</div>
	
	<div>
		<label>registerDate</label><br/>
		<input type="text" readonly	value='<fmt:formatDate pattern="yyyy/MM/dd" value="${vo.regDate }" />'  />
	</div>
	
	<div>
		<label>updateDate</label><br/>
		<input type="text" readonly	value='<fmt:formatDate pattern="yyyy/MM/dd" value="${vo.updateDate }" />'  />
	</div>
	
	<div>
		<button id="modifyButton">modify</button>
		<button id="listButton">list</button>
	</div>	
	
	<form id ='operForm' hidden = "true" method="get">
		<input name="bno" value='<c:out value="${vo.bno }" />' />
		<input name="pageNum" value='<c:out value="${criteria.pageNum }" />' />
		<input name="amount" value='<c:out value="${criteria.amount }" />' />
		<input name='type' value='<c:out value="${ criteria.type }"/>' />
		<input name='keyword' value='<c:out value="${ criteria.keyword }"/>' />
	</form>
	
	<script type="text/javascript" src="/resources/js/reply.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		
		const bnoValue = '${vo.bno}';
		
		//add-test
		/*replyService.add(
		{reply:"jsonTest",replyer:"tester",bno:bnoValue},//첫번째매개변수 = 데이터
		function(result){//두번째매개변수 = 성공시 실행될 콜백함수
			alert(result);//reply.js에서 success시에 콜백함수에 뭘 줬을까? 브라우저에서 성공콜백함수에 기본적으로 제공하는 result를 줬네(?)
		}
		);*/
		
		//getListTest
		/*replyService.getList({bno:bnoValue, page:2}, function(list){//list는 getJSON이 받아온 data를 의미
			for(let i =0, len = list.length||0 ; i<len;i++){
				console.log(list[i]);
			}
		});*/
		
		/*
		//getTest
		replyService.get(4,function(data){
			console.log(data);
		});		
		*/
		
		/*
		//updateTest
		replyService.update({
			  rno : 10,
			  bno : bnoValue,
			  reply : "Modified Reply...."
			}, function(result) {
			  alert("수정 완료...");
			});
		*/
		
		/*
		//deleteTest
		replyService.remove(17, function(count) {
		   console.log(count);
		   if (count === "success") {
		     alert("REMOVED");
		   }
		 }, function(err) {
		   alert('ERROR...');
		 });
	
});
		*/
	</script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		const operForm = $("#operForm");
		
		//list
		$("#listButton").on("click", function(){
			operForm.attr("action","/board/list");
			operForm.find("input[name='bno']").remove();
			operForm.submit();
		});//end
		
		//modify
		$("#modifyButton").on("click",function(){
			operForm.attr("action","/board/modify");			
			operForm.submit();
		});//end
		
	});
	
	</script>
<%@ include file="../includes/footer.jsp"%>
