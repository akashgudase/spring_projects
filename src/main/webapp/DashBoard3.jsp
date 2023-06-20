<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="table" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

#box1 {
	display: inline-block;
}

#box2 {
	margin-left: 425px;
	margin-top: 50px;
}

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
	<div id="box1">
		<div>
			<form action="addMedicine">
				<input class="input" type="submit" value="Add medicine">
			</form>
			<form action="showMedicines">
				<input class="input" type="submit" value="Show medicines">
			</form>
			<form action="logOut">
				<input class="input" type="submit" value="Log out">
			</form>
		</div>
		<div id="box2">
			<table border="1px">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<table:forEach var="user" items="${user}">
					<tr>
						<td>${user.getId()}</td>
						<td>${user.getName()}</td>
						<td>${user.getEmail()}</td>
						<td>${user.getPassword()}</td>
						<td><a href="editUser?id=${user.getId()}">Edit</a></td>
						<td><a href="deleteUser?id=${user.getId()}">Delete</a></td>
					</tr>
				</table:forEach>
			</table>
		</div>
	</div>
</body>
</html>