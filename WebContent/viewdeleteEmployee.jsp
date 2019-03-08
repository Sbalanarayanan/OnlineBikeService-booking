<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>


	<div style="padding-left: 1250px;">
		<a href="employeedetails.jsp"> <img border="0" alt="W3Schools"
			src="homeicon.jpg" width="25" height="30">
		</a>

	</div>

	<h2 style="text-align: center";>Employee</h2>
	<form method="post">
		<div align="center">
			<table
				style="font-family: times new roman; border-collapse: collapse">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">EmpId
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Name
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Phone
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Address
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employeeList" items="${DELETEEMPLOYEE}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${employeeList.id}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${employeeList.name}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${employeeList.phone}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${employeeList.address}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tr>
					<td></td>

				</tr>
			</table>
		</div>
	</form>

</body>
</html>