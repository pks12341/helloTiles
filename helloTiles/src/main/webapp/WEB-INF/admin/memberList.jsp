<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>회원분류</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${memberlist }" var="member">
		<tr>
			<td>${member.mid }</td>
			<td>${member.name }</td>
			<td>${member.phone }</td>
			<td>${member.pass }</td>			
			<td>${member.responsbility }</td>			
		</tr>
	</c:forEach>
	</tbody>
</table>

