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
	<form method="post">
		<table>
			<tr>
				<th>거래처코드</th>
				<td>
					<input type="text" name="buyerId"  maxlength="6" readonly
						class="form-control" value="${buyer.buyerId}" />
					<span class="text-danger">${errors.buyerId}</span>
				</td>
			</tr>
			<tr>
				<th>거래처명</th>
				<td>
					<input type="text" name="buyerName"  maxlength="40" 
						class="form-control" value="${buyer.buyerName}" />
					<span class="text-danger">${errors.buyerName}</span>
				</td>
			</tr>
			<tr>
				<th>분류</th>
				<td>
					<select name="buyerLgu"  class="form-select">
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
					<span class="text-danger">${errors.buyerLgu}</span>
				</td>
			</tr>
			<tr>
				<th>거래은행</th>
				<td>
					<input type="text" name="buyerBank" maxlength="40"
						class="form-control" value="${buyer.buyerBank}" />
					<span class="text-danger">${errors.buyerBank}</span>
				</td>
			</tr>
			<tr>
				<th>계좌</th>
				<td>
					<input type="text" name="buyerBankno" maxlength="40"
						class="form-control" value="${buyer.buyerBankno}" />
					<span class="text-danger">${errors.buyerBankno}</span>
				</td>
			</tr>
			<tr>
				<th>계좌주</th>
				<td>
					<input type="text" name="buyerBankname" maxlength="15"
						class="form-control" value="${buyer.buyerBankname}" />
					<span class="text-danger">${errors.buyerBankname}</span>
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" name="buyerZip" maxlength="7"
						class="form-control" value="${buyer.buyerZip}" />
					<span class="text-danger">${errors.buyerZip}</span>
				</td>
			</tr>
			<tr>
				<th>주소1</th>
				<td>
					<input type="text" name="buyerAdd1" maxlength="100"
						class="form-control" value="${buyer.buyerAdd1}" />
					<span class="text-danger">${errors.buyerAdd1}</span>
				</td>
			</tr>
			<tr>
				<th>주소2</th>
				<td>
					<input type="text" name="buyerAdd2" maxlength="80"
						class="form-control" value="${buyer.buyerAdd2}" />
					<span class="text-danger">${errors.buyerAdd2}</span>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="buyerComtel" 
					maxlength="14" class="form-control" value="${buyer.buyerComtel}" />
					<span class="text-danger">${errors.buyerComtel}</span>
				</td>
			</tr>
			<tr>
				<th>팩스</th>
				<td>
					<input type="text" name="buyerFax"  maxlength="20"
						class="form-control" value="${buyer.buyerFax}" />
					<span class="text-danger">${errors.buyerFax}</span>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="buyerMail"  maxlength="40"
						class="form-control" value="${buyer.buyerMail}" />
					<span class="text-danger">${errors.buyerMail}</span>
				</td>
			</tr>
			<tr>
				<th>담당자</th>
				<td>
					<input type="text" name="buyerCharger" maxlength="10"
						class="form-control" value="${buyer.buyerCharger}" />
					<span class="text-danger">${errors.buyerCharger}</span>
				</td>
			</tr>
			<tr>
				<th>내선번호</th>
				<td>
					<input type="text" name="buyerTelext" maxlength="2"
						class="form-control" value="${buyer.buyerTelext}" />
					<span class="text-danger">${errors.buyerTelext}</span>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록" class="btn btn-success"/>
					<input type="reset" value="취소" class="btn btn-danger"/>
					<a href="javascript:history.back();" class="btn btn-secondary">뒤로가기</a>
					<a href="<c:url value='/buyer/buyerList.do'/>" class="btn btn-secondary">목록으로</a>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$("[name=buyerLgu]").val("${buyer.buyerLgu}");
	</script>
	<jsp:include page="/includee/postScript.jsp" />
</body>
</html>













