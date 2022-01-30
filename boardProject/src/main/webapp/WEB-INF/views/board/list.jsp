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
				<td><a href="/board/get?bno=${vo.bno }"> <c:out
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

<button id="regButton">register</button>

<script type="text/javascript">
	$(document).ready(
			function() {

				//modal
				const result = '<c:out value="${result}" />';

				checkModal(result);
				
				history.replaceState({},null,null);

				function checkModal(result) {

					if (result === '' || history.state)
						return;

					if (parseInt(result) > 0) {
						$(".modal-body").html(
								"게시글" + parseInt(result) + " 번이 등록되었습니다.");
					}

					$("#myModal").modal("show");
				}

				//register
				const regButton = document.querySelector("#regButton");

				function register() {
					location.href = "/board/register";
				}

				regButton.addEventListener("click", register);
			});
</script>
<%@ include file="../includes/footer.jsp"%>
