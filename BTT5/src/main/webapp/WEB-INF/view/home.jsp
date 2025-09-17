<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang Home</title>
</head>
<body>
	<h1>Xin chào, đây là Home Page</h1>
	<p>Nội dung chính của Home sẽ được render vào chỗ
		${sitemeshPage.body} trong web.jsp.</p>
	<c:if test="${not empty sessionScope.message}">
		<div class="alert alert-success">${sessionScope.message}</div>
		<c:remove var="message" scope="session" />
	</c:if>
</body>
</html>
