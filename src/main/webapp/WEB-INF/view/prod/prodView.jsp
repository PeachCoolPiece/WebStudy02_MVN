<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
		<table class="table table-bordered">
		<tr>
			<th>상품코드</th>
			<td>${prod.prodId}</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td>${prod.prodName}</td>
		</tr>
		<tr>
			<th>상품분류</th>
			<td>${prod.lprodNm}</td>
		</tr>
		<tr>
			<th>거래처</th>
			<td>
				<table>
					<thead>
						<tr>
							<th>거래처코드</th>
							<td>${prod.buyer.buyerId}</td>
							<th>거래처명</th>
							<td>${prod.buyer.buyerName}</td>
							<th>거래처소재지역</th>
							<td>${prod.buyer.buyerAdd1}</td>
							<th>담당자명</th>
							<td>${prod.buyer.buyerCharger}</td>
							<th>연락처</th>
							<td>${prod.buyer.buyerComtel}</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<th>구매가</th>
			<td>${prod.prodCost}</td>
		</tr>
		<tr>
			<th>판매가</th>
			<td>${prod.prodPrice}</td>
		</tr>
		<tr>
			<th>세일가</th>
			<td>${prod.prodSale}</td>
		</tr>
		<tr>
			<th>상품요약</th>
			<td>${prod.prodOutline}</td>
		</tr>

		<tr>
			<th>이미지</th>
			<td><img src="<c:url value='/resources/prodImages/${prod.prodImg}'/>"></td>
		</tr>
		<tr>
			<th>재고</th>
			<td>${prod.prodTotalstock}</td>
		</tr>
		<tr>
			<th>입고일</th>
			<td>${prod.prodInsdate}</td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td>${prod.prodProperstock}</td>
		</tr>
		<tr>
			<th>크기</th>
			<td>${prod.prodSize}</td>
		</tr>
		<tr>
			<th>색상</th>
			<td>${prod.prodColor}</td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td>${prod.prodDelivery}</td>
		</tr>
		<tr>
			<th>단위</th>
			<td>${prod.prodUnit}</td>
		</tr>
		<tr>
			<th>입고량</th>
			<td>${prod.prodQtyin}</td>
		</tr>
		<tr>
			<th>출고량</th>
			<td>${prod.prodQtysale}</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>${prod.prodMileage}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="${pageContext.request.contextPath} /prod/prodList.do" class="btn btn-secondary">상품목록</a>
			</td>
		</tr>
		<tr>
			<th>구매자리스트</th>
			<td>
				<table>
					<thead>
					<c:forEach items="${prod.memberList }" var="member">
					<c:if test="${not empty prod.memberList}">
						<tr>
						<c:url value="/member/memberView.do" var="memURL">
							<c:param name="who" value="${member.memId}"></c:param>
						</c:url>
							<th>구매지이름</th>
							<td><a href="${memURL}">${member.memName}</a> </td>
							<th>주소</th>
							<td>${member.memAdd1}</td>
							<th>이메일</th>
							<td>${member.memMail}</td>
							<th>마일리지</th>
							<td>${member.memMileage}</td>
						</tr>
						</c:if>
					 </c:forEach> 
					 <c:if test="${ empty prod.memberList}">
						<tr>
							<td colspan="4">구매자가 없습니다.</td>
						</tr>
						</c:if>
					</thead>
				</table>
			</td>
		</tr>
		
	</table>
	<jsp:include page="/includee/postScript.jsp" />
</body>
</html>