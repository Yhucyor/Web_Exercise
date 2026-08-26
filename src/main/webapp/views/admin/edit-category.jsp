<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Edit Category</title>

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

	.category-image {
		width: 120px;
		height: 100px;
		object-fit: cover;
		border-radius: 8px;
		margin-bottom: 10px;
	}

	.btn-submit {
		padding: 10px 18px;
		border: none;
		background-color: #0d6efd;
		color: white;
		border-radius: 6px;
		cursor: pointer;
	}

	.btn-back {
		margin-left: 10px;
		text-decoration: none;
		color: #333;
	}
</style>

</head>

<body>

<div class="container">

	<h2>Chỉnh sửa danh mục</h2>

	<form
		action="${pageContext.request.contextPath}/admin/category/edit"
		method="post">

		<input
			type="hidden"
			name="id"
			value="${category.categoryid}">

		<div class="form-group">

			<label>Tên danh mục:</label>

			<input
				type="text"
				name="categoryname"
				value="${category.categoryname}"
				required>

		</div>

		<div class="form-group">

			<label>Hình ảnh hiện tại:</label>

			<c:if test="${category.images != null && category.images != ''}">

				<c:url
					value="/image"
					var="imgUrl">

					<c:param
						name="fname"
						value="${category.images}" />

				</c:url>

				<br>

				<img
					class="category-image"
					src="${imgUrl}"
					alt="Category Image">

			</c:if>

		</div>

		<div class="form-group">

			<label>Đường dẫn hình ảnh:</label>

			<input
				type="text"
				name="images"
				value="${category.images}">

		</div>

		<div class="form-group">

			<label>Trạng thái:</label>

			<select name="status">

				<option
					value="1"
					${category.status == 1 ? 'selected' : ''}>

					Hoạt động

				</option>

				<option
					value="0"
					${category.status == 0 ? 'selected' : ''}>

					Không hoạt động

				</option>

			</select>

		</div>

		<button
			type="submit"
			class="btn-submit">

			Cập nhật

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