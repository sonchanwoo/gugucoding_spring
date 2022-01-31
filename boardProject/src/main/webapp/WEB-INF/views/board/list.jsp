<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<table>
	<thead>
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>writer</th>
			<th>registerDate</th>
			<th>updateDate</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="vo">
			<tr>
				<td><c:out value="${vo.bno }"></c:out></td>
				<td><a class="move" href="${vo.bno }"> <c:out
							value="${vo.title }"></c:out>
				</a></td>
				<td><c:out value="${vo.writer }"></c:out></td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${vo.regDate }" />
				</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd"
						value="${vo.updateDate }" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="modal" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Modal Title</h4>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					Close</button>
			</div>
		</div>
	</div>
</div>

<!-- pageMaker -->
<div class='row'>
	<ul class="pagination">

		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous"><a
				href="${pageMaker.startPage - 1}">Previous</a></li>
		</c:if>

		<c:forEach var="num" begin="${pageMaker.startPage }"
			end="${pageMaker.endPage }">
			<li class="paginate_button ${criteria.pageNum==num ? "active":"" }">
				<a href="${num}">${num }</a>
			</li>
		</c:forEach>

		<c:if test="${pageMaker.next}">
			<li class="paginate_button next"><a
				href="${pageMaker.endPage + 1}">Next</a></li>
		</c:if>

	</ul>
</div>

<button id="regButton">register</button>

<form id="actionForm" action="/board/list" method="GET">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }" />
	<input type="hidden" name="amount" value="${pageMaker.cri.amount }" />
</form>

<script type="text/javascript">
	$(document)	.ready(
			function() {
						//modal
						const result = '<c:out value="${result}" />';

						checkModal(result);

						history.replaceState({}, null, null);

						function checkModal(result) {

							if (result === '' || history.state)
								return;

							if (parseInt(result) > 0) {
								$(".modal-body").html(
										"게시글" + parseInt(result)
												+ " 번이 등록되었습니다.");
							}

							$("#myModal").modal("show");

						}//end-modal

						
						//register
						$("#regButton").on("click", function() {
							location.href = "/board/register";
						});//end-register

						
						//move page
						const actionForm = $("#actionForm");

						$(".paginate_button a")	.on("click",
						function(e) {
								e.preventDefault();
											
								actionForm.find("input[name='pageNum']").val($(this).attr("href"));
						
								actionForm.attr("action","/board/list");
								actionForm.submit();
						});//end-move page
						
						
						//move get
						$(".move").on("click", function(e){
							e.preventDefault();
							
							actionForm.append("<input type='hidden' name='bno' value='' />");
							
							actionForm.find("input[name='bno']").val($(this).attr("href"));
							
							actionForm.attr("action","/board/get");
							actionForm.submit();
						})//end move

					});
</script>
<%@ include file="../includes/footer.jsp"%>
