<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp"/>
</head>
<%
	List<MemberVO> list =  (List)request.getAttribute("list");

%>
<body>

<table class="table table-bordered">
	<thead>
		<tr>
	
			<th>회원아이디</th>
			<th>회원명</th>
			<th>생일</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>기념일자</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		
			<%
			for(MemberVO mem : list){			
				%>
				<tr>
				<% 

			%>
			<td class="memId" id="<%=mem.getMemId()%>"><%=mem.getMemId()%></td>
			<td><%=mem.getMemName()%></td>
			<td><%=mem.getMemBir()%></td>
			<td><%=mem.getMemMail()%></td>
			<td><%=mem.getMemHp()%></td>
			<td><%=mem.getMemAdd1()%></td>
			<td><%=mem.getMemMemorialday()%></td>
			<td><%=mem.getMemMileage()%></td>
			</tr>
			<%
				}
			%>
		
	
	
	</tbody>

</table>

<jsp:include page="/includee/postScript.jsp"/>
<script type="text/javascript">

$(".memId").on('click',function(e){
	let {id} = e.target;
	console.log(id);
	location = '<%=request.getContextPath()%>/member/memberView.do?who=' + id
});

</script>
</body>
</html>