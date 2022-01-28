<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp" %>

	<form id="form" method="POST">

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
			<button id="modifyButton">modify</button>
			<button id="removeButton">remove</button>
			<button id="listButton" type="button">list</button>
		</div>

	</form>

	<script type="text/javascript">
		const removeButton = document.querySelector("#removeButton");

		function list() {
			location.href = "/board/list";//여기도 form을 get으로 바꾸고 액션을 /board/list바꾸는 거 말고는 안되나?
		}

		function modify(e) {
			e.preventDefault();

			form.action = "/board/modify";
			form.submit();
		}

		function remove(e) {
			e.preventDefault();

			form.action = "/board/remove";
			form.submit();
		}

		modifyButton.addEventListener("click", modify);
		removeButton.addEventListener("click", remove);
		listButton.addEventListener("click", list);
	</script>
<%@ include file="../includes/footer.jsp"%>
