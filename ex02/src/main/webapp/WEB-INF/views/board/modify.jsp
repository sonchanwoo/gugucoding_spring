<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>	
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">			
					
				<form action="/board/modify" method="post">
				
				<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }" />' />
				<input type="hidden" name="amount" value='<c:out value="${cri.amount}" />' />
				
				
					<div class="form-group">
						<label>Bno</label>
						<input class="form-control" name="bno" value='<c:out value='${board.bno }'/>' readOnly />
					</div>
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value='<c:out value='${board.title }'/>'  />
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content"><c:out value="${board.content }" />
						</textarea>
					</div>
					
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer" value='<c:out value='${board.writer }'/>' readOnly />
					</div>
					
					<div class="form-group" hidden>
						<label>RegDate</label>
						<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regDate}"/>' readOnly />
					</div>
					
					<div class="form-group" hidden>
						<label>UpdateDate</label>
						<input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' readOnly />
					</div>
					
					<button type="submit" data-oper="modify" class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value= '${board.bno }'/>'">
						Modify
					</button>
					<button type="submit" data-oper="remove" class="btn btn-danger">
						Remove
					</button>
					<button type="submit" data-oper="list" class="btn btn-primary">
						List
					</button>
				</form>
			</div>
		
		</div>	
	</div>
</div>

<script type="text/javascript">
$(document).ready(	
	function(){
		
		
		
		
		const formObj=$("form");
		
		$('button').on("click",function(e){
			e.preventDefault();
			const operation=$(this).data("oper");
			
			if(operation === 'remove'){
				formObj.attr("action","/board/remove");
			}else if(operation ==='list'){
				/*
				self.location="/board/list";
				return;*/
				formObj.attr("action","/board/list").attr("method","get");
				const pageNumTag = $("input[name='pageNum']").clone();
				const amountTag = $("input[name='amount']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
			}
			formObj.submit();
		});
		
		
		
		
	}		
);
</script>

<%@ include file="../includes/footer.jsp"%>