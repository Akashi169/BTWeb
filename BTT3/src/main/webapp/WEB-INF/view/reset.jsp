<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5" style="max-width: 400px;">
    <h3 class="text-center">Đặt lại mật khẩu</h3>
    
    <form action="reset" method="post">
        <div class="mb-3">
            <label class="form-label">Mật khẩu mới</label>
            <input type="password" name="newPassword" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Xác nhận mật khẩu</label>
            <input type="password" name="confirmPassword" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success w-100">Đổi mật khẩu</button>
    </form>

    <c:if test="${not empty alert}">
        <div class="alert alert-danger mt-3">${alert}</div>
    </c:if>
</div>
</body>
</html>
