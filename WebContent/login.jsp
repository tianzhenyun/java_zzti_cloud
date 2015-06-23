<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact Login</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/materialize.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/materialize.js"></script>

</head>
<body>
	<div class="row">
		<nav>
			<div class="nav-wrapper">
				<div class="col s12">
					<a href="#!" class="brand-logo" style="position:inherit">Contacts</a>
				</div>
			</div>
		</nav>
	</div>
	
	<div class="container section">
		<div class="align">
			<h4 class="header">Log In</h4>
		</div>
		<div class="row">
			<form class="col s12 m8 offset-m2 l6 offset-l3"
				action="${pageContext.request.contextPath}/servlet/LoginServlet"
				method="post">
				<div class="row">
					<div class="input-field col s12">						
					<input id="phone" type="text" name="phone"
						value="${form.phone }"
						class='${form.errors.phone==null?"":"invalid tooltipped" }'
						required data-position="right" data-delay="50" data-tooltip="${form.errors.phone}"/>
						<label for="phone">Phone</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
					<input id="password" type="password" name="password"
						class='${form.errors.password==null?"":"invalid tooltipped" }'
						required data-position="right" data-delay="50" data-tooltip="${form.errors.password}"" />
					<label for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<button class="btn waves-effect waves-light right" type="submit">
						Submit <i class="mdi-content-send right"></i>
					</button>
					<div class="align">
						<a href="${pageContext.request.contextPath }/servlet/ForgotPasswordUIServlet">Forgot
							password?</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>