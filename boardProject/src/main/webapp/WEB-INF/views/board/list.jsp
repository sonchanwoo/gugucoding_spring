<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>BoardList</title>
</head>
<body>

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
					<td> <c:out value="${vo.bno }"></c:out> </td>
					<td> <a href="/board/get?bno=${vo.bno }"> <c:out value="${vo.title }"></c:out> </a> </td>
					<td> <c:out value="${vo.writer }"></c:out> </td>
					<td> <fmt:formatDate pattern="yyyy/MM/dd" value="${vo.regDate }"/> </td>
					<td> <fmt:formatDate pattern="yyyy/MM/dd" value="${vo.updateDate }"/> </td>		
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button id="regButton">register</button>
	
	<script type="text/javascript">
	
		const regButton = document.querySelector("#regButton");
		
		function register(){
			location.href="/board/register";
		}
		
		regButton.addEventListener("click",register);
	
	</script>
</body>
</html>