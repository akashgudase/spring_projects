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
	height: 260px;
	border: 1px solid;
	margin-left: 650px;
	margin-top: 150px;
}

.input {
	margin-left: 14px;
	margin-top: 14px;
}

#input {
	margin-left: 70px;
	margin-top: 14px;
}
</style>
</head>
<body>
	<div>
		<form:form action="updateUser" modelAttribute="user">
			<form:input class="input" path="id" readonly="true" />
			<form:input class="input" path="name" />
			<form:input class="input" path="email" />
			<form:input class="input" path="password" />
			<form:button id="input">Update</form:button>
		</form:form>
	</div>
</body>
</html>