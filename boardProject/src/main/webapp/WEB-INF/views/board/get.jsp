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
	</form>
	
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
