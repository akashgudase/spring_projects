<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.input {
	width: 100px;
	height: 22px;
	border: 1px solid;
	color: black;
	background-color: #6495ED;
	text-decoration: none;
	text-align: center;
	display: block;
	margin-top: 5px;
}
</style>
</head>
<body>
	<h1>${message}</h1>
	<div>
		<form action="addMedicine">
			<input class="input" type="submit" value="Add medicine">
		</form>
		<form action="showMedicines">
			<input class="input" type="submit" value="Show medicines">
		</form>
		<form action="showUser">
			<input class="input" type="submit" value="User details">
		</form>
		<form action="logOut">
			<input class="input" type="submit" value="Log out">
		</form>
	</div>
</body>
</html>