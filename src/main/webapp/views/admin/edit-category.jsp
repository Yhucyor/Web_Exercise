<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title>
</head>

<body>

	<form
		action="${pageContext.request.contextPath}/admin/category/edit"
		method="post"
		enctype="multipart/form-data">

		<input
			type="hidden"
			name="id"
			value="${category.categoryid}">

		<label>Category Name:</label>
		<br>

		<input
			type="text"
			name="categoryname"
			value="${category.categoryname}">

		<br>

		<label>Images:</label>
		<br>

		<c:if test="${category.images != null && category.images != ''}">

			<img
				src="${category.images}"
				width="120"
				height="120"
				alt="Category Image">

		</c:if>

		<input
			type="file"
			name="images">

		<br>

		<label>Status:</label>
		<br>

		<input
			type="number"
			name="status"
			value="${category.status}">

		<br>
		<br>

		<button type="submit">
			Submit
		</button>

	</form>

</body>
</html>
