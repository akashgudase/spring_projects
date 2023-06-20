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
	height: 290px;
	border: 1px solid;
	margin-left: 650px;
	margin-top: 150px;
}

.input1 {
	margin-left: 14px;
	margin-top: 14px;
}

#input2 {
	margin-left: 18px;
	margin-top: 14px;
}

#input3 {
	margin-left: 22px;
	margin-top: 14px;
}

#input {
	margin-left: 75px;
	margin-top: 14px;
}

.label {
	margin-left: 10px;
}

.label1 {
	width: 100px;
	height: 20px;
	margin-left: 10px;
	margin-top: 12px;
	margin-left: 10px;
	border: none;
}
</style>
</head>
<body>
	<div>
		<form:form action="saveMedicine" modelAttribute="medicine">
			<form:input class="input1" path="name"
				placeholder="Enter medicine name" />
			<div class="label1">
				<label>Enter quantity</label>
			</div>
			<form:input class="input1" path="quantity" />
			<div class="label1">
				<label>Enter price</label>
			</div>
			<form:input class="input1" path="price" />
			<label class="label">DOM</label>
			<form:input id="input2" type="date" path="dateOfManufacture" />
			<label class="label">DOE</label>
			<form:input id="input3" type="date" path="dateOfExpiry" />
			<form:button id="input">Add</form:button>
		</form:form>
	</div>
</body>
</html>