<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Reset password</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<div>
		<div>
			<h3>Reset Password</h3>
		</div>
		<div>
			<form action="${pageContext.request.contextPath }/servlet/ResetPasswordServlet?guid=${param.guid}" method="post">
				<div>
					<span>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</span>
					<input type="password" name="newpassword" value="${form.newpassword}"/>
					<span class="error">${form.errors.newpassword }</span>
				</div>
				<div>
					<span>确认密码：</span>
					<input type="password" name="confirmpassword" value="${form.confirmpassword}"/>
					<span class="error">${form.errors.confirmpassword }</span>
				</div>
				<div>
					<input type="submit" value="确认"/>
					<input type="button" onclick="window.close();" value="关闭"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>