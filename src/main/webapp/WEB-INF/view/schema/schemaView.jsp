<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp"/>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>테이블명</th>
			<th>테이블스페이스명</th>
			<th>레코드수</th>
		</tr>
	</thead>
	<tbody id="tableTbody">
		
	</tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
        
	      <div class="modal-body">
			<table>
				<thead>
					<tr>
						<th>테이블명</th>
						<th>컬럼명</th>
						<th>데이터타입</th>
						<th>데이터길이</th>
						<th>널허용</th>
					</tr>
				</thead>
				<tbody id="colTbody">
				
				</tbody>
			</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        
	      </div>
		
    </div>
  </div>
</div>
<script type="text/javascript">
let tableTbody = $("#tableTbody").data("propNames", ["tableName", "tablespaceName", "numRows"]);
let colTbody = $("#colTbody").data("propNames", ["tableName", "columnName", "dataType", "dataLength", "nullable"]);

let makeCommonTR = function(sourceObj, listTbody){
	let propNames = listTbody.data("propNames");
	let tdTags = [];
	$(propNames).each(function(idx, name){
		tdTags.push( $("<td>").html(sourceObj[name]) );
	});
	return $("<tr>").append(tdTags).data("source", sourceObj);
} 

let makeTableTR = function(tableSchemaVO){
	return $("<tr data-bs-toggle='modal' data-bs-target='#exampleModal'>").append(
				$("<td>").html(tableSchemaVO.tableName)
				, $("<td>").html(tableSchemaVO.tablespaceName)
				, $("<td>").html(tableSchemaVO.numRows)
			).data("source", tableSchemaVO);
}

let makeColTR = function(colSchemaVO){
	return $("<tr>").append(
			$("<td>").html(colSchemaVO.tableName)
			, $("<td>").html(colSchemaVO.columnName)
			, $("<td>").html(colSchemaVO.dataType)
		).data("colsource", colSchemaVO);	
}
let exampleModal = $("#exampleModal").on("show.bs.modal", function(event){
	let tr = event.relatedTarget;
	let tableSchemaVO = $(tr).data("source");
	$.getJSON("<%=request.getContextPath() %>/schema/columnSchema"
				, {
						what:tableSchemaVO.tableName
				}
			)
		.done(function(resp){
			let trTags = [];
			$(resp.columnList).each(function(idx, colSchemaVO){
				trTags.push( makeCommonTR(colSchemaVO, colTbody) );
			});
			colTbody.empty();
			colTbody.append(trTags);
		});
}).on("hidden.bs.modal", function(event){
	$(this).find("tbody").empty();
});

$.getJSON("<%=request.getContextPath() %>/schema/tableSchema")
	.done(function(resp){
		let trTags = [];
		$(resp.tableList).each(function(idx, tableSchemaVO){
			let jqTr = makeCommonTR(tableSchemaVO, tableTbody);
//				data-bs-toggle='modal' data-bs-target='#exampleModal'
			jqTr.attr({
				"data-bs-toggle":"modal"
				, "data-bs-target":"#exampleModal"
			});
			trTags.push( jqTr );
		});
		tableTbody.empty();
		tableTbody.append(trTags);
	});
</script>
</script>

<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>