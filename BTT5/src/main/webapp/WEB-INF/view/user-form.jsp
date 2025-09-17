<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	<div class="container mt-5">
		<h2>User Profile</h2>
		<form action="user" method="post">
			<!-- Email (readonly) -->
			<div class="mb-3 row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="email" name="email" value="${user.email}">
				</div>
			</div>

			<!-- Phone -->
			<div class="mb-3 row">
				<label for="phone" class="col-sm-2 col-form-label">Phone
					number</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" name="phone"
						value="${user.phone}">
				</div>
			</div>

			<!-- Password -->
			<div class="mb-3 row">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						name="password" value="${user.passWord}">
				</div>
			</div>

			<!-- Avatar -->
			<div class="mb-3 row">
				<label for="avatar" class="col-sm-2 col-form-label">Choose
					avatar</label>
				<div class="col-sm-10">
					<input class="form-control" type="file" id="avatar" name="avatar">
					<c:if test="${not empty user.avatar}">
						<img src="${user.avatar}" alt="Avatar" class="mt-2" width="100">
					</c:if>
				</div>
			</div>

			<!-- Submit -->
			<div class="mb-3 row">
				<div class="col-sm-10 offset-sm-2">
					<button type="submit" class="btn btn-primary">Update
						Profile</button>
				</div>
			</div>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>

</body>
</html>