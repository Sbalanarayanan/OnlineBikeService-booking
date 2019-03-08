<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delivery</title>
<style>
form {
	display: inline-block;
}
</style>
</head>
<body>
	<h2 style="text-align: center";>Deliver</h2>
	<div style="padding-left: 1250px;">
		<a href="admin.html"> <img border="0" alt="W3Schools"
			src="homeicon.jpg" width="25" height="30">
		</a>
	</div>
	<div style="text-align: center;">
		<form method="post" action="ListDateServlet">
			<table>


				<tr>
					<td>date:</td>
					<td><input type="date" name="dateview"></td>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Ok</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align: center; padding-top: 30px">
		<form method="post">
			<h3>List to Deliver</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Customer
							Name</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Phone
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Address
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Company
							Name</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Bike
							Name</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Bike
							Model</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Bike
							Number</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Service
							Type</th>



					</tr>
				</thead>
				<tbody>
					<c:forEach var="dateList" items="${CUSTOMERDETAILS}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.name}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.phone}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.address}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.companyName}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.bikeName}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.bikeModel}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.bikeNumber}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${dateList.customerIssue.name}</td>


						</tr>
					</c:forEach>
				</tbody>

			</table>
			<table>

				<tr>
					<td></td>

					<td></td>
				</tr>

			</table>

		</form>
	</div>

</body>
</html>