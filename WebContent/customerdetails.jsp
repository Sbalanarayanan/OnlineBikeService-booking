<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
<style>
body {
	background-image: url('bikeinpieces.gif');
	background-size: 50%;
	background-repeat: no-repeat;
	background-attachment: fixed;
	height: 100%;
	width: 100%;
	text-align: center;
	padding-top: 130px;
	font-family: Times New Roman;
	font-size: 19px
}

form {
	display: inline-block;
}
</style>
</head>
<body>
	${COUNT} ${SLOT} ${DISPLAY}
	<h2>Service Providers</h2>
	<form method="post" action="AddDetailServlet">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</td>

				<td>
					<table>
						<tr align="left">
							<td>Customer Name :</td>
							<td><input type="text" name="customerName" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Phone :</td>
							<td><input type="number" maxlength="10" name="customerPhone" onkeypress='return event.charCode >= 48 && event.charCode <= 57' required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Address :</td>
							<td><input type="text" name="customerAddress" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Bike Company :</td>
							<td><input type="text" name="companyName" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Bike Name :</td>
							<td><input type="text" name="bikeName" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Bike Model :</td>
							<td><input type="text" name="bikeModel" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Bike Number :</td>
							<td><input type="text" name="bikeNumber" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr align="left">
							<td>Service type :</td>
							<td><select name="serviceType">
									<c:forEach var="serviceType" items="${SERVICETYPE}">
										<option value="${serviceType.id}">${serviceType.name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
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
					</table>
				</td>


			</tr>
		</table>

	</form>
</body>
</html>