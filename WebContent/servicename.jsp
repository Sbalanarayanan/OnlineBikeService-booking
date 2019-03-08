<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Services</title>
</head>
<body>
	<h2 style="text-align: center";>Services</h2>
	<div style="padding-left: 1270px;">
		<a href="admin.html"> <img border="0" alt="W3Schools"
			src="homeicon.jpg" width="25" height="30">
		</a>
	</div>
	<div style="text-align: center";>
		<img border="0" alt="W3Schools" src="servicename.jpg" width="350"
			height="260">
	</div>
	<table>
		<tr>
			<td>
				<div style="padding-left: 200px;">
					<form method="post" action="ServiceNameServlet">
						<table>
							<tr>
								<td></td>
								<td><h3>List of Services</h3></td>
							</tr>
							<tr></tr>

							<tr>
								<td></td>
								<td><button type="Submit">View All</button></td>
							</tr>
						</table>
					</form>
				</div>
			</td>


			<td>
				<div style="padding-left: 100px;">
					<form method="post" action="AddServiceTypeServlet">
						<table>
							<tr>
								<td></td>
								<td><h3>Add</h3></td>
							</tr>
							<tr></tr>
							<tr>
								<td>Name :</td>
								<td><input type="text" name="typename" required></td>
							</tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<td>Days:</td>
								<td><input type="number" name="days" required></td>
							</tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<td></td>
								<td>
									<button type="Submit">Add</button>
								</td>
							</tr>
						</table>

					</form>
				</div>

			</td>
			<td>
				<div style="padding-left: 100px;">
					<form method="post" action="DeleteServiceServlet">
						<table>
							<tr>
								<td></td>
								<td><h3>Delete</h3></td>
							</tr>
							<tr>
								<td>Service Id:</td>
								<td><input type="number" name="id" required></td>
							</tr>
							<tr></tr>
							<tr></tr>

							<tr>
								<td></td>
								<td><button type="submit">Delete</button></td>
							</tr>
						</table>
					</form>
				</div>
			</td>


		</tr>
	</table>


</body>
</html>