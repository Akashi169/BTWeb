<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-light">
    <div class="card p-4 shadow" style="width: 400px;">
        <h3 class="text-center">Quên mật khẩu</h3>
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>
        <c:if test="${message != null}">
            <div class="alert alert-success text-center">${message}</div>
        </c:if>
        
        <form action="forgot" method="post">
            <div class="mb-3">
                <label>Email</label>
                <input type="text" name="email" class="form-control" placeholder="Nhập email đã đăng ký" required>
            </div>
            <div class="mb-3">
                <label>Mật khẩu mới</label>
                <input type="password" name="newPassword" class="form-control" placeholder="Nhập mật khẩu mới" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đặt lại mật khẩu</button>
        </form>
    </div>
</body>
</html>
