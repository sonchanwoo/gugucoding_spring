<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
	
	<form id="form" hidden="true" method="GET">
	</form>
	
	<script type="text/javascript">
	
		const modifyButton = document.querySelector("#modifyButton");
		const listButton = document.querySelector("#listButton");
		
		const form = document.querySelector("#form");
		/*
		function list(){
			form.action="/board/list";
			form.submit();
		}*/
		
		function list() { /*여기서 input지우고 뭐고 하지말고 그냥 location으로 해버리면 안되냐*/
			location.href = "/board/list";
		}
		
		function modify(){
			form.innerHTML = '<input id="bno" name="bno" value="${vo.bno}" />';
			form.action="/board/modify";
			form.submit();
		}
		
		modifyButton.addEventListener("click",modify);
		listButton.addEventListener("click",list);
	
	</script>
	
</body>
</html>