<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//특정 지역을 검색하여 해당 지역에 사는 고객만 검색하기
	//목적지 : gogek_list
	//프로그램을 맨 처음 시작했을 때는 전체조회(null or empty경우)
	//파라미터가 넘어왔을 때 해당 지역에 사는 고객만 조회
	function search(){
		let search = document.getElementById("search").value;
		location.href='gogek_list?search='+search
	}
</script>
</head>
<body>
	<div align="center">
		지역:
		<input id="search" placeholder="검색어를 입력하세요">
		<input type="button" value="검색" onclick="search();">
	</div>
	<table border="1" align="center">
	<tr>
		<th>고객번호</th>
		<th>담당자</th>
		<th>이름</th>
		<th>주소</th>
		<th>주민번호</th>
	</tr>
	<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.gobun}</td>
		<td>${vo.godam}</td>
		<td>${vo.goname}</td>
		<td>${vo.goaddr}</td>
		<td>${vo.gojumin}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>





