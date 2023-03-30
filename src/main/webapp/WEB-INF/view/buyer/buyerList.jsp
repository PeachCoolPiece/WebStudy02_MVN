<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp"/>
</head>
<body>
<table class="table table-bordered">
	<thead class="table-success">
		<tr>
			<th>일련번호</th>
			<th>거래처명</th>
			<th>분류</th>
			<th>소재지</th>
			<th>담당자</th>
			<th>이메일</th>
			<th>연락처</th>
			<th>거래품목수</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="buyerList" value="${pagination.dataList }" />
		<c:if test="${not empty buyerList }">
			<c:forEach items="${buyerList }" var="buyer">
				<c:url var="viewURL" value="/buyer/buyerView.do">
					<c:param name="what" value="${buyer.buyerId }"/>
				</c:url>
				<tr>
					<td>${buyer.rnum }</td>
					<td><a href="${viewURL }">${buyer.buyerName }</a></td>
					<td>${buyer.lprodNm }</td>
					<td>${buyer.buyerAdd1 }</td>
					<td>${buyer.buyerCharger }</td>
					<td>${buyer.buyerMail }</td>
					<td>${buyer.buyerComtel }</td>
					<td>${buyer.prodCount }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty buyerList }">
			<tr>
				<td colspan="8">거래 품목 없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">
				<div class="pagingArea d-flex justify-content-center">
					${pagination.pagingHTML }
				</div>
				
				<div id="searchUI" class="row d-flex justify-content-center">
					<div class="col-auto">	
						<select name="buyerLgu" class="form-select col-auto">
							<option value>전체</option>
							<option value="P101">컴퓨터제품</option>
							<option value="P102">전자제품</option>
							<option value="P201">여성캐주얼</option>
							<option value="P202">남성캐주얼</option>
							<option value="P301">피혁잡화</option>
							<option value="P302">화장품</option>
							<option value="P401">음반/CD</option>
							<option value="P402">도서</option>
							<option value="P403">문구류</option>
							<option value="P502">수산물</option>
							<option value="P999">자동차</option>
							<option value="P902">축산물</option>
							<option value="P501">농산물</option>
							<option value="P903">바지</option>
							<option value="P901">가전제품</option>
							<option value="P801">정장</option>
						</select>
					</div>
					<div class="col-auto">	
						<input type="text" name="buyerAdd1"  class="form-control col-auto" placeholder="소재지"/>
					</div>
					<div class="col-auto">	
						<input type="text" name="buyerName"  class="form-control col-auto" placeholder="거래처명"/>
					</div>
					<div class="col-auto">	
						<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
						<a href="<c:url value='/buyer/buyerInsert.do'/>" class="btn btn-secondary">신규등록</a>
					</div>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<div style="border: 1px solid green;">
	<h4>검색 조건 전송을 위한 Hidden Form</h4>
	<form name="searchForm">
		<input type="text" name="page" placeholder="page"/>
		<input type="text" name="buyerLgu" placeholder="buyerLgu"/>
		<input type="text" name="buyerAdd1" placeholder="buyerAdd1"/>
		<input type="text" name="buyerName" placeholder="buyerName"/>
	</form>
</div>
<script>
	$("[name=buyerLgu]").val("${pagination.detailCondition.buyerLgu}");
	$("[name=buyerAdd1]").val("${pagination.detailCondition.buyerAdd1}");
	$("[name=buyerName]").val("${pagination.detailCondition.buyerName}");
	let searchForm = $("[name=searchForm]");
	let searchUI = $("#searchUI").on("click", "#searchBtn" , function(){
		$(this).parents("#searchUI").find(":input[name]").each(function(idx, input){
			let iptName = input.name;
			let iptValue = $(input).val();
			searchForm.find(`[name=\${iptName}]`).val(iptValue);
		});
		searchForm.submit();
	});
	let fn_paging = function(page, event){
		searchForm.find("[name=page]").val(page);
		searchForm.submit();
		return false;
	}
</script>
<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>