<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Booked Details</title>
</head>
<body style="text-align: center;">
	<div style="padding-left: 1300px">
		<a href="go.html"> <img border="0" alt="W3Schools"
			src="homeicon.jpg" width="25" height="30">
		</a>
	</div>

	<div align="center">
		<form method="post">
			<h3>Service Booked Details</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Customer
							Name</th>
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
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Date
						</th>



					</tr>
				</thead>
				<tbody>
					<c:forEach var="custdetail" items="${CUSTOMERDETAILS}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.name}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.address}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.companyName}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.bikeName}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.bikeModel}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.bikeNumber}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.customerIssue.name}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${custdetail.expectedDate}</td>


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
	<!-- <a href="customerdetails.jsp">
				<img border="0" alt="W3Schools" src="reply-512.png" width="25" height="30">
				</a> -->
	<h4>${DETAILS}</h4>
</body>
</html>