<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<form action="login" method="post">
    <h2>Tạo tài khoản mới</h2>

    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>

    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản"
                       name="username"
                       class="form-control">
            </div>
        </label>
    </section>

</form>

</body>
</html>
