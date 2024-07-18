<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function find(){
		let deptno = document.getElementById("deptno").value;
		
		//목적지 : sawon_list
		//파라미터 : deptno
		//특이사항
		//sawon_list에서 처음 시작하게 되면 deptno에는 값이 들어있지 않음
		//이럴때는 모든 사원 조회를 하세요
		location.href="sawon_list?deptno="+deptno
	}
</script>
</head>
<body>
	<div align="center">
		부서번호:
		<select id="deptno">
			<option value="0">:::부서를 선택하세요:::</option>
			<option value="10">총무부</option>
			<option value="20">영업부</option>
			<option value="30">전산실</option>
			<option value="40">관리부</option>
			<option value="50">경리부</option>
		</select>
		<input type="button" value="검색" onclick="find()">
	</div>
	<table border="1" align="center">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>급여</th>
			<th>입사일</th>
		</tr>
		<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.sabun}</td>
			<td>${vo.saname}</td>
			<td>${vo.sajob}</td>
			<td>${vo.sapay}</td>
			<td>${vo.sahire }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>