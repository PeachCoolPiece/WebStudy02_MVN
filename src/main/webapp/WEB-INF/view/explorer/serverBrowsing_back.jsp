<%@page import="java.util.stream.Collectors"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp"/>
<style type="text/css">
	.folder{
		background-color: red;
		
	}
	.file {
		background-color: green;
	}
</style>
</head>
<body>
<ul id="explorer">

</ul>
<script type="text/javascript">
let getDataRendering = function(base){
	let data = {};
	if(base) data['base'] = base
	$.getJSON("",{
		base:"test"
	}).done(function(resp, textStatus, jqXHR) {
		let dataList = resp.chidren;
		let liTags = [];
		$.each(dataList,function(idx,file){
			let li =  $("<li>")
				.addClass(file.folder ? "folder":"file")
					.data("url",file.url)
					.data("source",file)
					.html(file.name)
			liTags.push(li);
		});
		explorer.empty();
		explorer.append(liTags);
	});
}
let explorer = 	$("#explorer").on("click","li.folder",function(){
	//	location.href = "?base=/04"
			let base = $(this).data("url");
			getDataRendering(base);
	});
	getDataRendering();
</script>
<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>