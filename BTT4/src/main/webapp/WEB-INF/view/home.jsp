<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trang Home</title>
</head>
<body>
    <h1>Xin chào, đây là Home Page</h1>
    <p>Nội dung chính của Home sẽ được render vào chỗ ${sitemeshPage.body} trong web.jsp.</p>
</body>
</html>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
		<h1 class="text-center my-4">Categories</h1>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/category/add">Add
			Category</a>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#categoryModal">Add Category</button>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>User</th>
					<th>Image</th>
					<th>Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${categories}">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.userId}</td>
						<td><c:choose>
								<c:when test="${not empty category.imageUrl}">
									<img
										src="${pageContext.request.contextPath}/images/${category.imageUrl}"
										alt="Category Image" width="100">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/images/default.png"
										alt="No Image" width="100">
								</c:otherwise>
							</c:choose></td>
						<td><a
							href="${pageContext.request.contextPath}/categories/${category.id}"
							class="btn btn-info">View</a> <a
							href="${pageContext.request.contextPath}/categories/edit/${category.id}"
							class="btn btn-warning">Edit</a>
							<form
								action="${pageContext.request.contextPath}/categories/${category.id}"
								method="post" style="display: inline;">
								<input type="hidden" name="_method" value="delete" />
								<button type="submit" class="btn btn-danger">Delete</button>
							</form></td>
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
					<form action="${pageContext.request.contextPath}/category/add"
						method="post">
						<div class="mb-3">
							<label class="form-label">Category Name</label> <input
								type="text" name="name" class="form-control" required />
						</div>
						<div class="mb-3">
							<label class="form-label">User ID</label> <input type="number"
								name="userId" class="form-control" required />
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>

</html>








<!-- <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault" bis_skin_checked="1">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01" bis_skin_checked="1">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav> 
 --> --%>