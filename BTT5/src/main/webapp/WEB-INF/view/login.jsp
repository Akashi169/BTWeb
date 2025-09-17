<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    body {
        background: #f5f6fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .login-container {
        width: 400px;
        padding: 30px;
        background: #fff;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }
    .login-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }
    .input-group-text {
        background: #f0f0f0;
    }
    .btn-login {
        width: 100%;
        background: #007bff;
        color: #fff;
        font-weight: bold;
    }
    .btn-login:hover {
        background: #0056b3;
    }
    .extra-links {
        text-align: center;
        margin-top: 15px;
    }
</style>
</head>
<body>
    <div class="login-container">
        <h2><i class="fas fa-user-circle"></i> Đăng nhập</h2>
        
       >
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>
        
      
        <form action="login" method="post">
           
            <div class="mb-3">
                <label class="form-label">Tên đăng nhập</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                    <input type="text" name="username" class="form-control" placeholder="Nhập tài khoản" required
                    value="${cookie.username.value != null ? cookie.username.value : ''}">
                </div>
            </div>
            
           
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
                    <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required 
                   value="${cookie.password.value != null ? cookie.password.value : ''}">
                </div>
            </div>
            
          
            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" name="remember" id="remember">
                <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
            </div>
            
      
            <button type="submit" class="btn btn-login">Đăng nhập</button>
        </form>
        
       >
        <div class="extra-links">
            <a href="register.jsp">Đăng ký</a> | <a href="forgot">Quên mật khẩu?</a>
        </div>
    </div>
</body>
</html>
