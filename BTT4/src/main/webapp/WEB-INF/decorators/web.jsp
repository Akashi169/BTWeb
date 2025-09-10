<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><decorator:title default="Trang mặc định" /></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
</head>
<body>

	<%@ include file="/common/web/header.jsp"%>
	<body><sitemesh:write property="body" />
</body>

	<%@ include file="/common/web/footer.jsp"%>
</body>
</html>