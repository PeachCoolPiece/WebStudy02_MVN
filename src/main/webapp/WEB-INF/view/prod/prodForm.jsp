<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
	<form method="post" enctype="multipart/form-data">  <!-- multipart는 바디를 여러개를 쪼갠다.   -->
		<table>
		<%-- 	<tr>
				<th>상품코드</th>
				<td>
					<input type="text" name="prodId" readonly maxlength="10"
					class="form-control" value="${prod.prodId}" />
					<span class="text-danger">${errors.prodId}</span>
				</td>
			</tr> --%>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="prodName"  maxlength="40"
					class="form-control" value="${prod.prodName}" />
					<span class="text-danger">${errors.prodName}</span>
				</td>
			</tr>
			<tr>
				<th>분류코드</th>
				<td>
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
					<span class="text-danger">${errors.prodLgu}</span>
				</td>
			</tr>
			<tr>
				<th>거래처코드</th>
				<td>
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
					<span class="text-danger">${errors.prodBuyer}</span>
				</td>
			</tr>
			<tr>
				<th>구매가</th>
				<td>
					<input type="number" name="prodCost" 
					maxlength="22" class="form-control" value="${prod.prodCost}" />
					<span class="text-danger">${errors.prodCost}</span>
				</td>
			</tr>
			<tr>
				<th>판매가</th>
				<td>
					<input type="number" name="prodPrice" 
					maxlength="22" class="form-control" value="${prod.prodPrice}" />
					<span class="text-danger">${errors.prodPrice}</span>
				</td>
			</tr>
			<tr>
				<th>세일가</th>
				<td>
					<input type="number" name="prodSale" 
					maxlength="22" class="form-control" value="${prod.prodSale}" />
					<span class="text-danger">${errors.prodSale}</span>
				</td>
			</tr>
			<tr>
				<th>상품요약</th>
				<td>
					<input type="text" name="prodOutline" 
					maxlength="100" class="form-control" value="${prod.prodOutline}" />
					<span class="text-danger">${errors.prodOutline}</span>
				</td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td>
					<textarea name="prodDetail" >${prod.prodDetail}</textarea>	
					<span class="text-danger">${errors.prodDetail}</span>
				</td>
			</tr>
			<tr>
				<th>이미지경로</th>
				<td>
					<input type="file" name="prodImage" />
					<span>${errors.prodImg}</span>
					<!-- 업로드 할떄는 Image -->
				</td>
			</tr>
			<tr>
				<th>재고</th>
				<td>
					<input type="number" name="prodTotalstock"
					maxlength="22" class="form-control" value="${prod.prodTotalstock}" />
					<span class="text-danger">${errors.prodTotalstock}</span>
				</td>
			</tr>
			<tr>
				<th>입고일</th>
				<td>
					<input type="date" name="prodInsdate" maxlength="7"
					class="form-control" value="${prod.prodInsdate}" />
					<span class="text-danger">${errors.prodInsdate}</span>
				</td>
			</tr>
			<tr>
				<th>적정재고</th>
				<td>
					<input type="number" name="prodProperstock" 
					maxlength="22" class="form-control" value="${prod.prodProperstock}" />
					<span class="text-danger">${errors.prodProperstock}</span>
				</td>
			</tr>
			<tr>
				<th>크기</th>
				<td>
					<input type="text" name="prodSize" maxlength="20"
					class="form-control" value="${prod.prodSize}" />
					<span class="text-danger">${errors.prodSize}</span>
				</td>
			</tr>
			<tr>
				<th>색상</th>
				<td>
					<input type="text" name="prodColor" maxlength="20"
					class="form-control" value="${prod.prodColor}" />
					<span class="text-danger">${errors.prodColor}</span>
				</td>
			</tr>
			<tr>
				<th>배송방법</th>
				<td>
					<input type="text" name="prodDelivery" maxlength="255"
					class="form-control" value="${prod.prodDelivery}" />
					<span class="text-danger">${errors.prodDelivery}</span>
				</td>
			</tr>
			<tr>
				<th>단위</th>
				<td>
					<input type="text" name="prodUnit" maxlength="6"
					class="form-control" value="${prod.prodUnit}" />
					<span class="text-danger">${errors.prodUnit}</span>
				</td>
			</tr>
			<tr>
				<th>입고량</th>
				<td>
					<input type="number" name="prodQtyin" maxlength="22"
					class="form-control" value="${prod.prodQtyin}" />
					<span class="text-danger">${errors.prodQtyin}</span>
				</td>
			</tr>
			<tr>
				<th>출고량</th>
				<td>
					<input type="number" name="prodQtysale" maxlength="22"
					class="form-control" value="${prod.prodQtysale}" />
					<span class="text-danger">${errors.prodQtysale}</span>
				</td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td>
					<input type="number" name="prodMileage" maxlength="22"
					class="form-control" value="${prod.prodMileage}" />
					<span class="text-danger">${errors.prodMileage}</span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록" class="btn btn-success"/>
					<input type="reset" value="취소" class="btn btn-danger"/>
					<a href="javascript:history.back();" class="btn btn-secondary">뒤로가기</a>
					<a href="<c:url value='/buyer/buyerList.do'/>" class="btn btn-secondary">목록으로</a>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$("[name=prodLgu]").on("change", function(event){
			let lgu = $(this).val();
			prodBuyerTag.find("option").not(":first").hide();
			prodBuyerTag.find("option").filter(`.\${lgu}`).show();
		}).val("${prod.prodLgu}");
		let prodBuyerTag = $("[name=prodBuyer]").val("${prod.prodBuyer}");
	</script>
	<jsp:include page="/includee/postScript.jsp" />
</body>
</html>