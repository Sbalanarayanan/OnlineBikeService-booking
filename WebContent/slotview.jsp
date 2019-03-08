<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Slots</title>
</head>
<body>

	<div style="padding-left: 1250px;">
		<a href="slot.jsp"> <img border="0" alt="W3Schools"
			src="reply-512.png" width="35" height="30">
		</a>
	</div>
	<h2 style="text-align: center";>Slot</h2>
	<form method="post">
		<div align="center">
			<table
				style="font-family: times new roman; border-collapse: collapse">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Id
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">TodaySlot
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Date
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="slotList" items="${SLOT}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${slotList.id}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${slotList.count}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								${slotList.date}</td>
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