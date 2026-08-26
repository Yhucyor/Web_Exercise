<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
</head>

<body>

	<form
		action="${pageContext.request.contextPath}/admin/category/add"
		method="post"
		enctype="multipart/form-data">

		<label>Category Name:</label>
		<br>

		<input
			type="text"
			name="categoryname">

		<br>

		<label>Images:</label>
		<br>

		<input
			type="file"
			name="images">

		<br>

		<label>Status:</label>
		<br>

		<input
			type="number"
			name="status"
			value="1">

		<br>
		<br>

		<button type="submit">
			Submit
		</button>

	</form>

</body>
</html>
