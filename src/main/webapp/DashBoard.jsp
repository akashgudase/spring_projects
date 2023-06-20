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
			<form action="showUser">
				<input class="input" type="submit" value="User details">
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
					<th>Quantity</th>
					<th>Price</th>
					<th>DOM</th>
					<th>DOE</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<table:forEach var="medicine" items="${medicines}">
					<tr>
						<td>${medicine.getId()}</td>
						<td>${medicine.getName()}</td>
						<td>${medicine.getQuantity()}</td>
						<td>${medicine.getPrice()}</td>
						<td>${medicine.getDateOfManufacture()}</td>
						<td>${medicine.getDateOfExpiry()}</td>
						<td><a href="editMedicine?id=${medicine.getId()}">Edit</a></td>
						<td><a href="deleteMedicine?id=${medicine.getId()}">Delete</a></td>
					</tr>
				</table:forEach>
			</table>
		</div>
	</div>
</body>
</html>