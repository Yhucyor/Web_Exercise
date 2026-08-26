<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 40px;
	background-color: #f2f2f2;
	color: #222;
}

.container {
	max-width: 600px;
	padding: 24px;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 6px;
	box-shadow: 0 4px 14px rgba(0, 0, 0, 0.12);
}

h1 {
	margin-top: 0;
	color: #45ad4f;
}

.user-info {
	margin: 16px 0;
	padding: 12px;
	background-color: #f0fff2;
	border-left: 4px solid #4caf50;
}

a {
	display: inline-block;
	margin-top: 10px;
	color: #ffffff;
	background-color: #4caf50;
	padding: 8px 14px;
	text-decoration: none;
	border-radius: 4px;
}

a:hover {
	background-color: #3f9d45;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Home Page</h1>

		<c:choose>
			<c:when test="${not empty sessionScope.roleName and not empty sessionScope.username}">
				<div class="user-info">
					<strong>${sessionScope.roleName}</strong> - ${sessionScope.username}
				</div>
				<a href="logout">Dang xuat</a>
			</c:when>
			<c:otherwise>
				<p>Ban chua dang nhap.</p>
				<a href="login">Dang nhap</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
