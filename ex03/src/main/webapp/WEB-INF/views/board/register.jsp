<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

	<form action="/board/register" method="POST">

		<div>
			<label>title</label><br />
			<input name="title" type="text" required placeholder="title" />
		</div>

		<div>
			<label>writer</label><br />
			<input name="writer"  type="text"  required placeholder="writer" />
		</div>

		<div>
			<label>content</label><br />
			<textarea name="content"  rows="3" cols="" required placeholder="content" ></textarea>
		</div>

		<button type="submit">register</button>
		<button id="listButton" type="button">list</button>
	</form>

	<script type="text/javascript">
		function list() {
			location.href = "/board/list";
		}

		listButton.addEventListener("click", list);
	</script>
<%@ include file="../includes/footer.jsp"%>
