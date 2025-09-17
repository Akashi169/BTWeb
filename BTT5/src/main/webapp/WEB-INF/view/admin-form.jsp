<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>JSP Bootstrap Demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<h1 class="text-center my-4">Manager users</h1>
		<%--<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/category/add">Add
			Category</a> --%>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#userModal">Add User</button>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Email</th>
					<th>Username</th>
					<th>Password</th>
					<th>Avatar</th>
					<th>Role ID</th>
					<th>Phone</th>
					<th>Create Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.username}</td>	
						<td>${user.password}</td>
						<td>${user.roleid}</td>
						<td>${user.phone}
						<td>${user.createDate}</td>
						<td><c:choose>
								<c:when test="${not empty user.avatar}">
									<img
										src="${pageContext.request.contextPath}/images/${user.avatar}"
										alt="Category Image" width="100">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/images/default.png"
										alt="No Image" width="100">
								</c:otherwise>
							</c:choose></td>
						<td>
							<button type="button" class="btn btn-warning"
								data-bs-toggle="modal" data-bs-target="#editUserModal"
								data-id="${user.id}" 
								data-name="${user.usename}"
								data-email="${user.email}"
								data-password="${user.password}"
								data-userroleid="${user.role.id}"
								data-phone="${user.phone}"
								>Edit</button>
							<form
								action="${pageContext.request.contextPath}/categories/delete"
								method="post" style="display: inline;">
								<input type="hidden" name="id" value="${user.id}" />
								<button type="submit" class="btn btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa không?');">
									Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="modal fade" id="categoryModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add Category</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/categories/add"
						method="post">
						<div class="mb-3">
							<label class="form-label">User Name</label> <input
								type="text" name="username" class="form-control" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label> <input
								type="text" name="username" class="form-control" required />
						</div>
						
						<div class="mb-3">
							<label class="form-label">Email</label> <input
								type="text" name="email" class="form-control" />
						</div>
						
						<div class="mb-3">
							<label class="form-label">Role ID</label> <input type="number"
								name="roleid" class="form-control" required />
						</div>
						
						<div class="mb-3">
							<label class="form-label">Image URL</label> <input type="text"
								name="imageUrl" class="form-control" />
						</div>
						<button type="submit" class="btn btn-success">Save</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="editCategoryModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Edit Category</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/categories/update"
						method="post">
						<input type="hidden" name="id" id="editId" />
						<div class="mb-3">
							<label class="form-label">Category Name</label> <input
								type="text" name="name" id="editName" class="form-control"
								required />
						</div>
						<div class="mb-3">
							<label class="form-label">User ID</label> <input type="number"
								name="userId" id="editUser" class="form-control" required />
						</div>
						<div class="mb-3">
							<label class="form-label">Image URL</label> <input type="text"
								name="imageUrl" id="editImage" class="form-control" />
						</div>
						<button type="submit" class="btn btn-success">Update</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>

	<script>
		const editModal = document.getElementById('editCategoryModal');
		editModal.addEventListener('show.bs.modal', function(event) {
			const button = event.relatedTarget;
			const id = button.getAttribute('data-id');
			const name = button.getAttribute('data-name');
			const userId = button.getAttribute('data-userid');
			const imageUrl = button.getAttribute('data-imageurl');

			document.getElementById('editId').value = id;
			document.getElementById('editName').value = name;
			document.getElementById('editUser').value = userId;
			document.getElementById('editImage').value = imageUrl;
		});
	</script>
</body>

</html>
