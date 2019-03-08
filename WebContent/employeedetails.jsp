<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<style>
body {
	text-align: center;
	padding-top: 50px;
	font-family: Times New Roman;
	font-size: 19px;
}

form {
	display: inline-block;
}
</style>
<body>

	<form method="post" action="ViewEmployeeServlet">
		<button style="width: 70px;" type="submit">View</button>
	</form>
	<div style="padding-left: 1250px;">
		<a href="admin.html"> <img border="0" alt="W3Schools"
			src="homeicon.jpg" width="25" height="30">
		</a>
	</div>

	<form method="post" action="AddEmployeeServlet">
		<img src="employee.jpg" height="230" width="250">
		<h2>Employee Details</h2>
		<table>
			<tr align="center">
				<td>Name :</td>
				<td><input type="text" name="employeeName"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr align="center">
				<td>Phone :</td>
				<td><input type="tel" maxlength="10" name="phone"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr align="center">
				<td>Address :</td>
				<td><input type="text" name="employeeAddress"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button style="width: 70px;" type="submit">Submit</button>
				</td>
			</tr>
			<tr>
				<td>${DETAILS}</td>
			</tr>
		</table>

	</form>
</body>
</html>