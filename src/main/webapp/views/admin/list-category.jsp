<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category List</title>

<style>
	body {
		font-family: Arial, sans-serif;
		background-color: #f5f6fa;
		margin: 0;
		padding: 30px;
	}

	.container {
		max-width: 1000px;
		margin: auto;
		background: white;
		padding: 25px;
		border-radius: 12px;
		box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
	}

	h2 {
		margin-top: 0;
	}

	.btn-add {
		display: inline-block;
		padding: 10px 16px;
		background-color: #28a745;
		color: white;
		text-decoration: none;
		border-radius: 6px;
		margin-bottom: 20px;
	}

	table {
		width: 100%;
		border-collapse: collapse;
	}

	th,
	td {
		border: 1px solid #ddd;
		padding: 12px;
		text-align: center;
	}

	th {
		background-color: #f0f2f5;
	}

	img {
		width: 100px;
		height: 80px;
		object-fit: cover;
		border-radius: 6px;
	}

	.btn-edit {
		color: #0d6efd;
		text-decoration: none;
	}

	.btn-delete {
		color: red;
		text-decoration: none;
	}
</style>

</head>

<body>

<div class="container">

	<h2>Danh sách danh mục</h2>

	<a
		class="btn-add"
		href="${pageContext.request.contextPath}/admin/category/add">
		Thêm danh mục
	</a>

	<table>

		<thead>
			<tr>
				<th>STT</th>
				<th>ID</th>
				<th>Hình ảnh</th>
				<th>Tên danh mục</th>
				<th>Trạng thái</th>
				<th>Hành động</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach
				items="${cateList}"
				var="cate"
				varStatus="STT">

				<tr>

					<td>
						${STT.index + 1}
					</td>

					<td>
						${cate.categoryid}
					</td>

					<td>

						<c:if test="${cate.images != null && cate.images != ''}">

							<img
								src="${cate.images}"
								alt="Category Image">

						</c:if>

					</td>

					<td>
						${cate.categoryname}
					</td>

					<td>

						<c:choose>

							<c:when test="${cate.status == 1}">
								Hoạt động
							</c:when>

							<c:otherwise>
								Không hoạt động
							</c:otherwise>

						</c:choose>

					</td>

					<td>

						<a
							class="btn-edit"
							href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.categoryid}">
							Sửa
						</a>

						|

						<a
							class="btn-delete"
							href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.categoryid}">
							Xóa
						</a>

					</td>

				</tr>

			</c:forEach>

		</tbody>

	</table>

</div>

</body>
</html>
