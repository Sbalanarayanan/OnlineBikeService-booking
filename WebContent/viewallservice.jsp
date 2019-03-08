<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service</title>
</head>
<body>
	<div align="center">
		<div style="padding-left: 1300px">
			<a href="admin.html"> <img border="0" alt="W3Schools"
				src="homeicon.jpg" width="35" height="30">
			</a> <a href="servicename.jsp"> <img border="0" alt="W3Schools"
				src="reply-512.png" width="35" height="30">
			</a>
		</div>
		<form method="post">
			<h3>service details</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Id</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Service
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Days
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="viewservicename" items="${TYPENAME}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${viewservicename.id}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${viewservicename.name}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${viewservicename.days}</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
		</form>
	</div>


</body>
</html>