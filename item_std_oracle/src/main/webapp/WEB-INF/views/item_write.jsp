<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
	function fn_submit() {
		var formData = $("#frm").serialize();//form 요소 자체
		//비동기 전송방식의 jquery 함수
		$.ajax({
			type : "post",
			data : formData,
			url : "item_write_ok",
			success : function(data) {
				alert("저장완료");
				location.href="write_result";
			},
			error : function() {
				alert("오류발생");
			}
		});
	}
</script>
</head>
<body>
<!-- 	<form method="post" action="write_result"> -->
	<form id="frm">
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<input type="text" name="description">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="전송" onclick="fn_submit()">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>