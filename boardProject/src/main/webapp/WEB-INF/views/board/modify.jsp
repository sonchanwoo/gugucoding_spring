<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>

<form id="modifyForm" action="/board/modify" method="POST">

	<div>
		<label>bno</label><br /> <input name="bno" type="text" readOnly
			value="${vo.bno }" />
	</div>

	<div>
		<label>title</label><br /> <input name="title" type="text" required
			name="title" value="${vo.title }" />
	</div>

	<div>
		<label>writer</label><br /> <input name="writer" readonly type="text"
			required name="writer" value="${vo.writer }" />
	</div>

	<div>
		<label>content</label><br />
		<textarea name="content" rows="3" required><c:out
				value="${vo.content }" />
		</textarea>
	</div>

	<div>
		<label>registerDate</label><br /> <input type="text" readonly
			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${vo.regDate }" />' />
	</div>

	<div>
		<label>updateDate</label><br /> <input type="text" readonly
			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${vo.updateDate }" />' />
	</div>

	<div>
		<button data-oper="modify">modify</button>
		<button data-oper="remove">remove</button>
		<button data-oper="list" type="button">list</button>
	</div>

	<input type="hidden" name="pageNum"
		value='<c:out value="${criteria.pageNum }" />' /> <input
		type="hidden" name="amount"
		value='<c:out value="${criteria.amount }" />' />

</form>

<script type="text/javascript">
	$(document).ready(
			function() {
				const modifyForm = $("#modifyForm");

				$("button").on(
						"click",
						function(e) {

							e.preventDefault();

							const oper = $(this).data("oper");

							if (oper === "remove")
								modifyForm.attr("action", "/board/remove");

							if (oper === "list") {
								modifyForm.attr("action", "/board/list")
										.attr("method", "get");

								const pageNum = $("input[name='pageNum']")
										.clone();
								const amount = $("input[name='amount']")
										.clone();

								modifyForm.empty();
								modifyForm.append(pageNum);
								modifyForm.append(amount);
							}
							
							modifyForm.submit();
						});
			});
</script>
<%@ include file="../includes/footer.jsp"%>
