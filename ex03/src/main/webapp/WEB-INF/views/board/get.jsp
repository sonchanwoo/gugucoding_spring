<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<div>
	<label>bno</label><br /> <input type="text" readonly
		value="${vo.bno }" />
</div>

<div>
	<label>title</label><br /> <input type="text" readonly
		value="${vo.title }" />
</div>

<div>
	<label>writer</label><br /> <input type="text" readonly
		value="${vo.writer }" />
</div>

<div>
	<label>content</label><br />
	<textarea readOnly rows="3" cols=""><c:out
			value="${vo.content }"></c:out></textarea>
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
	<button id="listButton">list</button>
</div>

<form id='operForm' hidden="true" method="get">
	<input name="bno" value='<c:out value="${vo.bno }" />' /> <input
		name="pageNum" value='<c:out value="${criteria.pageNum }" />' /> <input
		name="amount" value='<c:out value="${criteria.amount }" />' /> <input
		name='type' value='<c:out value="${ criteria.type }"/>' /> <input
		name='keyword' value='<c:out value="${ criteria.keyword }"/>' />
</form>

<!-- 댓글 -->
<div class='row'>
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New
					Reply</button>
			</div>

			<div class="panel-body">
				<ul class="chat">

				</ul>
			</div>

			<div class="panel-footer"></div>


		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label> <input class="form-control" name='reply'
						value='New Reply!!!!'>
				</div>
				<div class="form-group">
					<label>Replyer</label> <input class="form-control" name='replyer'
						value='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label> <input class="form-control"
						name='replyDate' value='2018-01-01 13:13'>
				</div>

			</div>
			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var bnoValue = '<c:out value="${vo.bno}"/>';
						var replyUL = $(".chat");

						showList(1);

						function showList(page) {

							replyService
									.getList(
											{
												bno : bnoValue,
												page : page || 1
											},
											function(list) {

												var str = "";
												if (list == null
														|| list.length == 0) {

													replyUL.html("");

													return;
												}
												for (var i = 0, len = list.length || 0; i < len; i++) {
													str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
													str += "  <div><div class='header'><strong class='primary-font'>"
															+ list[i].replyer
															+ "</strong>";
													str += "    <small class='pull-right text-muted'>"
															+ replyService
																	.displayTime(list[i].replyDate)
															+ "</small></div>";
													str += "    <p>"
															+ list[i].reply
															+ "</p></div></li>";
												}
												replyUL.html(str);
											});//end function

						}//end showList 
						
						var modal = $(".modal");
					    var modalInputReply = modal.find("input[name='reply']");
					    var modalInputReplyer = modal.find("input[name='replyer']");
					    var modalInputReplyDate = modal.find("input[name='replyDate']");
					    
					    var modalModBtn = $("#modalModBtn");
					    var modalRemoveBtn = $("#modalRemoveBtn");
					    var modalRegisterBtn = $("#modalRegisterBtn");
					    
					    $("#addReplyBtn").on("click", function(e){
					        
					        modal.find("input").val("");
					        modalInputReplyDate.closest("div").hide();
					        modal.find("button[id !='modalCloseBtn']").hide();
					        
					        modalRegisterBtn.show();
					        
					        $(".modal").modal("show");
					        
					      });
					    
					    modalRegisterBtn.on("click",function(e){
					        
					        var reply = {
					              reply: modalInputReply.val(),
					              replyer:modalInputReplyer.val(),
					              bno:bnoValue
					            };
					        replyService.add(reply, function(result){
					          
					          alert(result);
					          
					          modal.find("input").val("");
					          modal.modal("hide");
					          
					          showList(1);
					          
					        });
					        
					      });

					});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		const operForm = $("#operForm");

		//list
		$("#listButton").on("click", function() {
			operForm.attr("action", "/board/list");
			operForm.find("input[name='bno']").remove();
			operForm.submit();
		});//end

		//modify
		$("#modifyButton").on("click", function() {
			operForm.attr("action", "/board/modify");
			operForm.submit();
		});//end

	});
</script>
<%@ include file="../includes/footer.jsp"%>
