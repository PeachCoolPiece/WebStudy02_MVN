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
<h4>상품 목록 조회</h4>
<table class="table table-bordered">
	<thead class="table-success">
		<tr>
			<th>일련번호</th>
			<th>상품명</th>
			<th>상품분류</th>
			<th>거래처</th>
			<th>입고일</th>
			<th>판매가</th>
			<th>마일리지</th>
			<th>구매자수</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="prodList" value="${pagination.dataList }" />
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<tr>
					<td>${prod.rnum }</td>
					<td>
						<c:url value="/prod/prodView.do" var="viewURL">
							<c:param name="what" value="${prod.prodId }" />
						</c:url>
						<a href="${viewURL }">${prod.prodName }</a>
					</td>
					<td>${prod.lprodNm }</td>
					<td>${prod.buyer.buyerName }</td>
					<td>${prod.prodInsdate }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodMileage }</td>
					<td>${prod.memCount }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="7">상품 없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				<div class="pagingArea d-flex justify-content-center">
					${pagination.pagingHTML }
				</div>
				
				<div id="searchUI" class="row d-flex justify-content-center">
					<div class="col-auto">
						<select name="prodLgu" class="form-select">
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
						<select name="prodBuyer" class="form-select">
							<option value>전체</option>
							<option class="P101" value="P10101">삼성컴퓨터</option>
							<option class="P101" value="P10102">삼보컴퓨터</option>
							<option class="P101" value="P10103">현주컴퓨터</option>
							<option class="P102" value="P10201">대우전자</option>
							<option class="P102" value="P10202">삼성전자</option>
							<option class="P201" value="P20101">대현</option>
							<option class="P201" value="P20102">마르죠</option>
							<option class="P202" value="P20201">LG패션</option>
							<option class="P202" value="P20202">캠브리지</option>
							<option class="P301" value="P30101">가파치</option>
							<option class="P302" value="P30201">한국화장품</option>
							<option class="P302" value="P30202">피리어스</option>
							<option class="P302" value="P30203">참존</option>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="prodName" class="form-control"/>
					</div>
					<div class="col-auto">
						<input type="button" value="검색" id="searchBtn" class="btn btn-primary"/>
						<input type="button" value="상품추가" id="insertFrom" class="btn btn-primary"/>
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
		<input type="text" name="prodLgu" placeholder="prodLgu"/>
		<input type="text" name="prodBuyer" placeholder="prodBuyer"/>
		<input type="text" name="prodName" placeholder="prodName"/>
	</form>
</div>
<script>
	$("[name=prodLgu]").on("change", function(event){
		let lgu = $(this).val();
		prodBuyerTag.find("option").not(":first").hide();
		prodBuyerTag.find("option").filter(`.\${lgu}`).show();
	}).val("${pagination.detailCondition.prodLgu}");
	let prodBuyerTag = $("[name=prodBuyer]").val("${pagination.detailCondition.prodBuyer}");
	$("[name=prodName]").val("${pagination.detailCondition.prodName}");
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
$('#insertFrom').on('click',function(){
	location = "<%=request.getContextPath()%>/prod/prodInsert.do"
});
</script>
<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>



