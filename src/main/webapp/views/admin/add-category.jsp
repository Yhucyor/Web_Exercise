<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Add Category</title>

<style>
	body {
		font-family: Arial, sans-serif;
		background-color: #f5f6fa;
		margin: 0;
		padding: 30px;
	}

	.container {
		width: 500px;
		margin: auto;
		background: white;
		padding: 25px;
		border-radius: 12px;
		box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
	}

	h2 {
		margin-top: 0;
	}

	.form-group {
		margin-bottom: 18px;
	}

	label {
		display: block;
		font-weight: bold;
		margin-bottom: 7px;
	}

	input,
	select {
		width: 100%;
		padding: 10px;
		border: 1px solid #ccc;
		border-radius: 6px;
		box-sizing: border-box;
	}

	.btn-submit {
		padding: 10px 18px;
		border: none;
		background-color: #28a745;
		color: white;
		border-radius: 6px;
		cursor: pointer;
	}

	.btn-back {
		display: inline-block;
		margin-left: 10px;
		text-decoration: none;
		color: #333;
	}
</style>

</head>

<body>

<div class="container">

	<h2>Thêm danh mục</h2>

	<form
		action="${pageContext.request.contextPath}/admin/category/add"
		method="post">

		<div class="form-group">

			<label>Tên danh mục:</label>

			<input
				type="text"
				name="categoryname"
				placeholder="Nhập tên danh mục"
				required>

		</div>

		<div class="form-group">

			<label>Đường dẫn hình ảnh:</label>

			<input
				type="text"
				name="images"
				placeholder="Ví dụ: category/phone.jpg">

		</div>

		<div class="form-group">

			<label>Trạng thái:</label>

			<select name="status">

				<option value="1">
					Hoạt động
				</option>

				<option value="0">
					Không hoạt động
				</option>

			</select>

		</div>

		<button
			type="submit"
			class="btn-submit">

			Thêm

		</button>

		<a
			class="btn-back"
			href="${pageContext.request.contextPath}/admin/category/list">

			Quay lại

		</a>

	</form>

</div>

</body>
</html>