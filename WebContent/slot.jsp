<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Slot</title>
<style>
form {
	display: inline-block;
}
</style>
</head>
<body>
	<form method=post action="SlotViewServlet">
		<button type="Submit">Slot View</button>
	</form>

	<div style="padding-left: 1250px;">
		<a href="admin.html"> <img border="0" alt="W3Schools"
			src="homeicon.jpg" width="25" height="30"> <!-- <input type="image" src="reply-512.png" alt="Go to service" width="50" height="50"> -->
		</a>
	</div>
	<h2 style="text-align: center";>Today Slot</h2>
	<div style="text-align: center; padding-top: 160px;">
		<form method="post" action="SlotServlet">
			<table>
				<tr>
					<td align="left">Id:</td>
					<td><input type="number" name="id" required></td>
				</tr>
				<tr>
					<td align="left">Today slot count:</td>
					<td><input type="number" name="count" required></td>
				</tr>
				<tr>
					<td align="left">Date:</td>
					<td><input type="date" name="date" required></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><button type="Submit">OK</button></td>
				</tr>
			</table>
		</form>
	</div>


	<!-- <form method="post" action=>
	<button type="Submit">view by dates</button>
	</form> -->

</body>
</html>