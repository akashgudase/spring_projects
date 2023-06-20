<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div {
	width: 200px;
	height: 200px;
	border: 1px solid;
	margin-left: 650px;
	margin-top: 150px;
}

.input {
	margin-left: 14px;
	margin-top: 18px;
}

#input {
	margin-left: 60px;
	margin-top: 25px;
}
</style>
</head>
<body>
	<div>
		<form:form action="saveUser" modelAttribute="user">
			<form:input class="input" path="name" placeholder="Enter user name" />
			<form:input class="input" path="email" placeholder="Enter email" />
			<form:password class="input" path="password"
				placeholder="Enter password" />
			<form:button id="input">Sign up</form:button>
		</form:form>
	</div>
</body>
</html>