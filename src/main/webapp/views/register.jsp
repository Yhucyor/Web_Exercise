<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background-color: #f2f2f2;
	color: #333;
}

.register-box {
	width: 460px;
	margin: 40px auto;
	padding: 24px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 4px 18px rgba(0, 0, 0, 0.15);
}

h2 {
	margin-top: 0;
	color: #45ad4f;
}

label {
	display: block;
	margin-top: 14px;
	margin-bottom: 6px;
	font-weight: bold;
}

input,
select {
	width: 100%;
	padding: 10px;
	border: 1px solid #d9d9d9;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 15px;
}

input.error {
	border-color: #d93025;
	background-color: #fff8f8;
}

.field-error {
	margin-top: 5px;
	color: #d93025;
	font-size: 13px;
}

button {
	width: 100%;
	margin-top: 18px;
	padding: 12px;
	border: none;
	border-radius: 8px;
	background-color: #4caf50;
	color: #fff;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
}

button:hover {
	background-color: #3f9d45;
}

.message {
	margin-bottom: 12px;
	padding: 10px;
	border-radius: 4px;
	background-color: #fff3cd;
	color: #7a5a00;
}

.login-link {
	margin-top: 14px;
	text-align: center;
}

.login-link a {
	color: #2b7cff;
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="register-box">
		<h2>Register Account</h2>

		<c:if test="${not empty alert}">
			<div class="message">${alert}</div>
		</c:if>

		<form action="register" method="post">
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" value="${usernameValue}"
				class="${fieldError == 'username' ? 'error' : ''}" required>
			<c:if test="${fieldError == 'username'}">
				<div class="field-error">Username da duoc su dung.</div>
			</c:if>

			<label for="fullname">Full Name:</label>
			<input type="text" id="fullname" name="fullname" value="${fullnameValue}" required>

			<label for="email">Email:</label>
			<input type="email" id="email" name="email" value="${emailValue}"
				class="${fieldError == 'email' ? 'error' : ''}" required>
			<c:if test="${fieldError == 'email'}">
				<div class="field-error">Email da ton tai.</div>
			</c:if>

			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required>

			<label for="confirmPassword">Re-type Password:</label>
			<input type="password" id="confirmPassword" name="confirmPassword"
				class="${fieldError == 'confirmPassword' ? 'error' : ''}" required>
			<c:if test="${fieldError == 'confirmPassword'}">
				<div class="field-error">Mat khau nhap lai khong khop.</div>
			</c:if>

			<label for="phone">Phone:</label>
			<input type="text" id="phone" name="phone" value="${phoneValue}"
				class="${fieldError == 'phone' ? 'error' : ''}" required>
			<c:if test="${fieldError == 'phone'}">
				<div class="field-error">So dien thoai da ton tai.</div>
			</c:if>

			<label for="roleid">Role:</label>
			<select id="roleid" name="roleid">
				<option value="3">User</option>
				<option value="2">Manager</option>
				<option value="1">Admin</option>
			</select>

			<button type="submit">Register</button>
		</form>

		<div class="login-link">
			Already have an account? <a href="login">Login</a>
		</div>
	</div>
</body>
</html>
