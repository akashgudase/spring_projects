<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
a {
	text-decoration: none;
}

div {
	width: 200px;
	height: 200px;
	border: 1px solid;
	margin-left: 650px;
	margin-top: 150px;
}

.input {
	margin-left: 14px;
	margin-top: 14px;
}

#input {
	margin-left: 66px;
	margin-top: 14px;
}

h4 {
	margin-left: 18px;
	margin-top: 40px;
}
</style>
<body>
	<div>
		<form:form action="validate" modelAttribute="user">
			<form:input class="input" path="email" placeholder="Enter your email" />
			<form:password class="input" path="password"
				placeholder="Enter your password" />
			<form:button id="input">Log in</form:button>
		</form:form>
		<h4>
			New user? <a href="signUp">SignUp</a> here.
		</h4>
	</div>
</body>
</html>